package com.excercise.WeatherDataService.model.apiDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RequestDTO(
        @NotBlank(message = "Debes ingresar una ciudad.")
        String city,
        @Pattern(regexp = "^[A-Za-z]{2}$")
        String lang
) { }
