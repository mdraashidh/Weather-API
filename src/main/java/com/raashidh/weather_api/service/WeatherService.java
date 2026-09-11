
package com.raashidh.weather_api.service;

import com.raashidh.weather_api.client.WeatherApiClient;
import com.raashidh.weather_api.dto.GeocodingResponse;
import com.raashidh.weather_api.dto.WeatherApiResponse;
import com.raashidh.weather_api.dto.WeatherResponse;
import com.raashidh.weather_api.exception.CityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import com.raashidh.weather_api.util.WeatherCodeMapper;

@Service
public class WeatherService {

    public final WeatherApiClient weatherApiClient;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    @Cacheable(value = "weather", key = "#city.trim().toLowerCase")
    public WeatherResponse getWeatherOf(String city) {

        city = city.trim();

        //converting city name into coordinates
        GeocodingResponse geocodingResponse =  weatherApiClient.getLocation(String.valueOf(city));

        //retriving the location details which are on the locations list
        if(geocodingResponse == null
                || geocodingResponse.getResults() == null
                ||  geocodingResponse.getResults().isEmpty()){
            throw new CityNotFoundException(city);
        }
        GeocodingResponse.Location location = geocodingResponse
                .getResults().get(0);



        //fetching weather using coordinates
        WeatherApiResponse weatherApiResponse =
                weatherApiClient.getWeather(
                        location.getLatitude(),
                        location.getLongitude()
                );

        //geting live weather
        WeatherApiResponse.Current current =
                weatherApiResponse.getCurrent();

        String condition = WeatherCodeMapper.getCondition(current.getWeather_code());
        return new WeatherResponse(
                location.getName(),
                current.getTemperature_2m(),
                current.getApparent_temperature(),
                current.getWind_speed_10m(),
                current.getRelative_humidity_2m(),
                condition
        );
    }

}

