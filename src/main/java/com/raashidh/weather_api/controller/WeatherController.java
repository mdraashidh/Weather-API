package com.raashidh.weather_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/api/weather")
    public String getWeather() {
        return "Weather API is Working!!";
    }
}
