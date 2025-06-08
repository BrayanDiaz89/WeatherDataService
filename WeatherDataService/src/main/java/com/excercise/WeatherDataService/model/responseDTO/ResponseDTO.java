package com.excercise.WeatherDataService.model.responseDTO;

public record ResponseDTO(
        String city,
        Double temperature,
        String condition,
        Boolean humid,
        Boolean cold,
        Boolean windy,
        Double windSpeed
        ) {
}
