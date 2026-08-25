package com.raashidh.weather_api.dto;


public class WeatherResponse {

    private String city;
    private double temperature;
    private double windSpeed;
    private int weatherCode;

    public WeatherResponse(String city, double temperature, double windSpeed, int weatherCode) {
        this.city = city;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.weatherCode = weatherCode;
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getWeatherCode() {
        return weatherCode;
    }


}
