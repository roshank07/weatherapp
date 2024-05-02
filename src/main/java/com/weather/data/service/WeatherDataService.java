package com.weather.data.service;

import com.weather.data.DTO.AggregatedData;
import com.weather.data.DTO.WeatherDataResponse;
import com.weather.data.DTO.WeatherEntry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherDataService {
    private final WeatherAPIClient weatherAPIClient;
    private final WeatherEntryAggregator weatherEntryAggregator;
    private final WeatherResponseCreator weatherResponseCreator;

    public WeatherDataService(WeatherAPIClient weatherAPIClient, WeatherEntryAggregator weatherEntryAggregator,
                              WeatherResponseCreator weatherResponseCreator) {
        this.weatherAPIClient = weatherAPIClient;
        this.weatherEntryAggregator = weatherEntryAggregator;
        this.weatherResponseCreator = weatherResponseCreator;
    }

    public List<WeatherDataResponse> getWeatherForecast(Integer numberOfDays) {
        List<WeatherEntry> weatherEntries = weatherAPIClient.getWeatherForecast().getList();
        List<AggregatedData> aggregatedData = weatherEntryAggregator.aggregateData(weatherEntries);
        return weatherResponseCreator.createWeatherDataResponses(aggregatedData,numberOfDays);
    }
}
