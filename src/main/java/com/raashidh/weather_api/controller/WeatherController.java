package com.raashidh.weather_api.controller;

import com.raashidh.weather_api.dto.WeatherApiResponse;
import com.raashidh.weather_api.dto.WeatherResponse;
import com.raashidh.weather_api.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public  WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }



    @GetMapping("/api/weather")
    public WeatherResponse  getCurrentWeather(@RequestParam String city) {
        return weatherService.getWeatherOf(city);
    }
}
