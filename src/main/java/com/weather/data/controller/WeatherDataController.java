package com.weather.data.controller;

import com.weather.data.DTO.WeatherDataResponse;
import com.weather.data.service.WeatherDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherDataController {
    private final WeatherDataService weatherDataService;

    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping
    public ResponseEntity<List<WeatherDataResponse>> getWeatherForecast(
            @RequestParam(required = false, defaultValue = "mumbai") String city,
            @RequestParam(required = false, defaultValue = "3") int days) {
        List<WeatherDataResponse> response = weatherDataService.getWeatherForecast(city, days);
        return ResponseEntity.ok(response);
    }

}
