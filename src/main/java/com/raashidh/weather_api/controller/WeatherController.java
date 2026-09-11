package com.raashidh.weather_api.controller;

import com.raashidh.weather_api.dto.ForecastResponse;
import com.raashidh.weather_api.dto.ForecastWeatherResponse;
import com.raashidh.weather_api.dto.WeatherApiResponse;
import com.raashidh.weather_api.dto.WeatherResponse;
import com.raashidh.weather_api.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public  WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }



    @GetMapping("/api/weather")
    public WeatherResponse  getCurrentWeather(
            @RequestParam
            @NotBlank(message = "City must not be blank")
            String city
    ) {
        return weatherService.getWeatherOf(city);
    }

    @GetMapping("/api/weather/forecast")
    public ForecastWeatherResponse getForecast(@RequestParam String city) {
        return weatherService.getForecasts(city);
    }
}
