package com.excercise.WeatherDataService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClient {

    @Bean
    public org.springframework.web.reactive.function.client.WebClient openWeatherWebClient() {
        return org.springframework.web.reactive.function.client.WebClient.builder()
                .baseUrl("https://api.openweathermap.org/data/2.5")
                .build();
    }

}
