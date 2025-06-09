package com.excercise.WeatherDataService.model.apiDTO;

public record WeatherResponseDTO(
        String cityName,
        String description,
        Double temperature,
        Integer humidity,
        Double windSpeed
) {
}
