package com.weather.data.service;

import com.weather.data.DTO.AggregatedData;
import com.weather.data.DTO.WeatherEntry;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class WeatherEntryAggregator {
    public List<AggregatedData> aggregateData(List<WeatherEntry> weatherEntries) {
        Map<LocalDate, AggregatedData> aggregatedDataMap = new HashMap<>();

        weatherEntries.forEach(weatherEntry -> {
                    LocalDate date = Instant.ofEpochSecond(weatherEntry.getDt())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();

                    AggregatedData aggregatedData = aggregatedDataMap.getOrDefault(date, new AggregatedData(
                            date, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, new HashSet<>()));

                    // Update the aggregated data for this date
                    aggregatedData.setMinTemp(Math.min(aggregatedData.getMinTemp(), weatherEntry.getMain().getTempMin()));
                    aggregatedData.setMaxTemp(Math.max(aggregatedData.getMaxTemp(), weatherEntry.getMain().getTempMax()));
                    aggregatedData.setWindSpeed(Math.max(aggregatedData.getWindSpeed(), weatherEntry.getWind().getSpeed()));

                    weatherEntry.getWeather().forEach(weatherCondition ->
                            aggregatedData.getWeatherCondition().add(weatherCondition.getMain()));

                    // Put the updated aggregated data back into the map
                    aggregatedDataMap.put(date, aggregatedData);
                }
        );

        // Convert the map values to a list
        return new ArrayList<>(aggregatedDataMap.values());

    }
}
