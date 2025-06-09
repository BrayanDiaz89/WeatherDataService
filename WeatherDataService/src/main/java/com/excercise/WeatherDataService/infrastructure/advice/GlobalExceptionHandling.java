package com.excercise.WeatherDataService.infrastructure.advice;

import com.excercise.WeatherDataService.infrastructure.dto.ErrorResponseDTO;
import com.excercise.WeatherDataService.infrastructure.error.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomException(ApplicationException e) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("request", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
