package com.raashidh.weather_api.dto;

import java.util.List;

public class ForecastWeatherResponse {

    private String city;
    private List<ForecastResponse> forecasts;

    public ForecastWeatherResponse(String city, List<ForecastResponse> forecasts) {
        this.city = city;
        this.forecasts = forecasts;
    }

    public String getCity() {
        return city;
    }
    public List<ForecastResponse> getForecasts() {
        return  forecasts;
    }
}
