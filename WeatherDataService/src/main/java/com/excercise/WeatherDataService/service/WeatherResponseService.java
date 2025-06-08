package com.excercise.WeatherDataService.service;

import com.excercise.WeatherDataService.model.apiDTO.WeatherResponseDTO;
import com.excercise.WeatherDataService.model.responseDTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherResponseService {

    @Autowired
    GetDataWeatherService dataWeatherService;

    public ResponseDTO serviceResponse(WeatherResponseDTO weatherResponseDTO){
        Boolean cold = weatherResponseDTO.temperature() < 10;
        Boolean windy = weatherResponseDTO.windSpeed() > 10;
        Boolean humid = weatherResponseDTO.humidity() > 80;
        return new ResponseDTO(
                weatherResponseDTO.cityName(),
                weatherResponseDTO.temperature(),
                weatherResponseDTO.description(),
                humid,
                cold,
                windy,
                weatherResponseDTO.windSpeed()
                );
    }


}
