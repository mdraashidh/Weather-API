package com.raashidh.weather_api.client;


import com.raashidh.weather_api.config.WeatherProperties;
import com.raashidh.weather_api.dto.GeocodingResponse;
import com.raashidh.weather_api.dto.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiClient {

    private final RestClient restClient;
    private final WeatherProperties weatherProperties;

//    @Value("${weather.geocoding-url}")
//    private String geocodingUrl;
//
//    @Value("${weather.forecast-url}")
//    private String forecastUrl;

    public WeatherApiClient(RestClient.Builder restClientBuilder,
                            WeatherProperties weatherProperties) {
        this.restClient = restClientBuilder.build();
        this.weatherProperties = weatherProperties;
    }

    public GeocodingResponse getLocation(String city) {

        return restClient.get()
                .uri(weatherProperties.getGeocodingUrl()
                        + "?name={city}&count=1&language=en&format=json", city)
                .retrieve()
                .body(GeocodingResponse.class);
    }

    public WeatherApiResponse getWeather(double latitude, double longitude) {

        return restClient.get()
                .uri(weatherProperties.getForecastUrl()
                                + "?latitude={latitude}"
                                + "&longitude={longitude}"
                                + "&current=temperature_2m,apparent_temperature,wind_speed_10m,relative_humidity_2m,weather_code",
                        latitude, longitude)
                .retrieve()
                .body(WeatherApiResponse.class);
    }

    public WeatherApiResponse getForecast(double latitude, double longitude) {

        return restClient.get()
                .uri(weatherProperties.getForecastUrl()
                                + "?latitude={latitude}"
                                + "&longitude={longitude}"
                                + "&daily=temperature_2m_max,temperature_2m_min,weather_code"
                                + "&timezone=auto",
                        latitude, longitude)
                .retrieve()
                .body(WeatherApiResponse.class);
    }

}
