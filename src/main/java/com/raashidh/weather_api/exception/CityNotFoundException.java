package com.raashidh.weather_api.exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(String city){
        super("city not found : " + city);
    }
}
