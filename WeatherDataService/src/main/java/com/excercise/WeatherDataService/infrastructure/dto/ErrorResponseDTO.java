package com.excercise.WeatherDataService.infrastructure.dto;

import org.springframework.validation.FieldError;

public record ErrorResponseDTO(
        String field,
        String errorMessage
) {
    public ErrorResponseDTO(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
