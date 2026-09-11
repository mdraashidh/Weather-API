package com.raashidh.weather_api.dto;

public class ForecastResponse {

    private String date;
    private double maxTemperature;
    private double minTemperature;
    private String condition;

    public ForecastResponse(
            String date,
            double maxTemperature,
            double minTemperature,
            String condition
    ) {
        this.date = date;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.condition = condition;
    }

    public String getDate() {
        return date;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public String getCondition() {
        return condition;
    }
}