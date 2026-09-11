package com.raashidh.weather_api.dto;


public class WeatherResponse {

    private String city;
    private double temperature;
    private double feelsLike;
    private double windSpeed;
    private double humidity;
    private String condition;

    public WeatherResponse(String city, double temperature,
                           double feelsLike, double windSpeed,
                           double humidity, String condition) {
        this.city = city;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.condition = condition;

    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getCondition(){
        return condition;
    }


}
