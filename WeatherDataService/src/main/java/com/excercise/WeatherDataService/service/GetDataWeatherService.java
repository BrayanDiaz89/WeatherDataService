package com.excercise.WeatherDataService.service;

import com.excercise.WeatherDataService.config.WebClient;
import com.excercise.WeatherDataService.model.apiDTO.RequestDTO;
import com.excercise.WeatherDataService.model.apiDTO.WeatherResponseDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetDataWeatherService {

    @Autowired
    private WebClient webClient;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${API_KEY}")
    private String apiKey;

    public Mono<WeatherResponseDTO> getDataFromOpenWeather(RequestDTO request){
       return webClient.openWeatherWebClient().get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", request.city())
                        .queryParam("appid", apiKey)
                        .queryParam("units", "metric")
                        .queryParam("lang", request.lang())
                        .build())
                .retrieve()
                .bodyToMono(String.class)
               .map(json -> {
                   try{
                       JsonNode root = objectMapper.readTree(json);
                       String cityName = root.path("name").asText();
                       String description = root.path("weather").get(2).path("description").asText();
                       Double temperature = root.path("main").path("temp").asDouble();
                       Integer humidity = root.path("main").path("humidity").asInt();
                       Double windSpeed = root.path("wind").path("speed").asDouble();
                       return new WeatherResponseDTO(
                               cityName,
                               description,
                               temperature,
                               humidity,
                               windSpeed
                       );
                   } catch (Exception e){
                       throw new RuntimeException("Error parsing JSON: " + e.getMessage());
                   }
               });
    }
}
