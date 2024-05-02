package com.weather.data.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WeatherDataResponse {
    private String date;
    private double minTemp;
    private double maxTemp;
    private double windSpeed;
    private List<String> messages;

}
