package com.raashidh.weather_api.dto;

public class WeatherApiResponse {

    public static class Current {

        /* the variables are named like this because of weather_api_response
           will send response in this format to reduce the variable name mapping */

        private double temperature_2m;
        private double apparent_temperature;
        private double wind_speed_10m;
        private double relative_humidity_2m;
        private int weather_code;


        public double getTemperature_2m() {
            return temperature_2m;
        }

        public double getApparent_temperature() {
            return apparent_temperature;
        }

        public double getWind_speed_10m() {
            return wind_speed_10m;
        }

        public double getRelative_humidity_2m() {
            return relative_humidity_2m;
        }

        public int getWeather_code() {
            return weather_code;
        }
    }
    private Current current;

    public Current getCurrent() {
        return current;
    }

}
