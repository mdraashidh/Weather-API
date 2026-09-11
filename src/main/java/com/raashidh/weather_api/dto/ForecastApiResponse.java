package com.raashidh.weather_api.dto;

import java.util.List;

public class ForecastApiResponse {

    private Daily daily;

    public Daily getDaily() {
        return daily;
    }

    public static class Daily {

        private List<String> time;
        private List<Double> temperature_2m_max;
        private List<Double> temperature_2m_min;
        private List<Integer> weather_code;

        public List<String> getTime() {
            return time;
        }

        public List<Double> getTemperature_2m_max() {
            return temperature_2m_max;
        }

        public List<Double> getTemperature_2m_min() {
            return temperature_2m_min;
        }

        public List<Integer> getWeather_code() {
            return weather_code;
        }
    }
}
