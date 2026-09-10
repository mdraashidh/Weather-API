package com.raashidh.weather_api.client;


import com.raashidh.weather_api.dto.GeocodingResponse;
import com.raashidh.weather_api.dto.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiClient {

    private final RestClient restClient;

    @Value("${weather.geocoding-url}")
    private String geocodingUrl;

    @Value("${weather.forecast-url}")
    private String forecastUrl;

    public WeatherApiClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public GeocodingResponse getLocation(String city) {

        return restClient.get()
                .uri(geocodingUrl
                        + "?name={city}&count=1&language=en&format=json", city)
                .retrieve()
                .body(GeocodingResponse.class);
    }

    public WeatherApiResponse getWeather(double latitude, double longitude) {

        return restClient.get()
                .uri(forecastUrl
                                + "?latitude={latitude}"
                                + "&longitude={longitude}"
                                + "&current=temperature_2m,wind_speed_10m,weather_code",
                        latitude, longitude)
                .retrieve()
                .body(WeatherApiResponse.class);
    }

}
