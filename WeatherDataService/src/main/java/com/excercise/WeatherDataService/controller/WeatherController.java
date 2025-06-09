package com.excercise.WeatherDataService.controller;

import com.excercise.WeatherDataService.model.apiDTO.RequestDTO;
import com.excercise.WeatherDataService.model.responseDTO.ResponseDTO;
import com.excercise.WeatherDataService.service.GetDataWeatherService;
import com.excercise.WeatherDataService.service.WeatherResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

    @Autowired
    private GetDataWeatherService getDataWeatherService;
    @Autowired
    private WeatherResponseService weatherResponseService;

    @PostMapping("weatherLocation")
    public Mono<ResponseDTO> getWeatherLocation(@RequestBody @Valid RequestDTO request){
        return getDataWeatherService.getDataFromOpenWeather(request)
                .map(weatherResponseService::serviceResponse);
    }
}
