package com.excercise.WeatherDataService.infrastructure.error;

public class ApplicationException extends RuntimeException{

    public ApplicationException(String message){
        super(message);
    }
    public ApplicationException(String message, Throwable cause){
        super(message, cause);
    }

}
