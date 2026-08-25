package com.raashidh.weather_api.dto;

import java.util.*;
import javax.xml.stream.Location;

public class GeocodingResponse {

    private List<Location> results;

    public List<Location> getResults() {
        return results;
    }

    public static class Location {
        private String name;
        private double latitue;
        private double longitude;

        public String getName() {
            return name;
        }

        public double getLatitue() {
            return latitue;
        }

        public double getLontitue() {
            return longitude;
        }
    }
}
