
package com.raashidh.weather_api.service;

import com.raashidh.weather_api.client.WeatherApiClient;
import com.raashidh.weather_api.dto.GeocodingResponse;
import com.raashidh.weather_api.dto.WeatherApiResponse;
import com.raashidh.weather_api.dto.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public final WeatherApiClient weatherApiClient;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public WeatherResponse getWeatherOf(String city) {

        //converting city name into coordinates
        GeocodingResponse geocodingResponse =  weatherApiClient.getLocation(String.valueOf(city));

        //retriving the location details which are on the locations list
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

        return new WeatherResponse(
                location.getName(),
                current.getTemperature_2m(),
                current.getWind_speed_10m(),
                current.getWeather_code()
        );
    }

}

