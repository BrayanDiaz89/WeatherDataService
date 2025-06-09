package com.excercise.WeatherDataService.model.apiDTO;

import com.excercise.WeatherDataService.model.apiDTO.jsonAPI.Main;
import com.excercise.WeatherDataService.model.apiDTO.jsonAPI.Weather;
import com.excercise.WeatherDataService.model.apiDTO.jsonAPI.Wind;

import java.util.List;

public record OpenWeatherApiResponse(
        String name,
        List<Weather> weather,
        Main main,
        Wind wind
            ) {
}
