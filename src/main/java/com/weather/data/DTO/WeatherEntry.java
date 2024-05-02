package com.weather.data.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WeatherEntry {
    private long dt;
    @JsonProperty("dt_txt")
    private String dtTxt;
    private TemperatureDetails main;
    private Wind wind;
    private List<WeatherCondition> weather;


    @Data
    public static class TemperatureDetails {
        @JsonProperty("temp_min")
        private double tempMin;
        @JsonProperty("temp_max")
        private double tempMax;
    }

    @Data
    public static class Wind {
        private double speed;
    }

    @Data
    public static class WeatherCondition {
        private String main;
    }
}