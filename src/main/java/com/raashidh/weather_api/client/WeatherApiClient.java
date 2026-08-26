package com.raashidh.weather_api.client;


import com.raashidh.weather_api.dto.GeocodingResponse;
import com.raashidh.weather_api.dto.WeatherApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiClient {

    private final RestClient restClient;

    public WeatherApiClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public GeocodingResponse getLocation(String city) {

        return restClient.get()
                .uri("https://geocoding-api.open-meteo.com/v1/search"
                        + "?name={city}&count=1&language=en&format=json", city)
                .retrieve()
                .body(GeocodingResponse.class);
    }

    public WeatherApiResponse getWeather(double latitude, double longitude) {

        return restClient.get()
                .uri("https://api.open-meteo.com/v1/forecast"
                                + "?latitude={latitude}"
                                + "&longitude={longitude}"
                                + "&current=temperature_2m,wind_speed_10m,weather_code",
                        latitude, longitude)
                .retrieve()
                .body(WeatherApiResponse.class);
    }

}
