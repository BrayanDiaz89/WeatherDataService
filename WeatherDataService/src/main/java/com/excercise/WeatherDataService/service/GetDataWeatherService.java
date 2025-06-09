package com.excercise.WeatherDataService.service;

import com.excercise.WeatherDataService.config.WebClient;
import com.excercise.WeatherDataService.model.apiDTO.OpenWeatherApiResponse;
import com.excercise.WeatherDataService.model.apiDTO.RequestDTO;
import com.excercise.WeatherDataService.model.apiDTO.WeatherResponseDTO;
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
                .bodyToMono(OpenWeatherApiResponse.class)
               .map(apiResponse -> {
                   try{
                      return new WeatherResponseDTO(
                               apiResponse.name(),
                               apiResponse.weather().get(0).description(),
                               apiResponse.main().temp(),
                               apiResponse.main().humidity(),
                               apiResponse.wind().speed()
                       );
                   } catch (Exception e){
                       throw new RuntimeException("Error parsing JSON: " + e.getMessage());
                   }
               });
    }
}
