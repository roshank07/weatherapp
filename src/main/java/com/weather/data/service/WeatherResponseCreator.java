package com.weather.data.service;

import com.weather.data.DTO.AggregatedData;
import com.weather.data.DTO.WeatherDataResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherResponseCreator {
    private final MessageAdder messageAdder;

    public WeatherResponseCreator(MessageAdder messageAdder) {
        this.messageAdder = messageAdder;
    }

    public List<WeatherDataResponse> createWeatherDataResponses(List<AggregatedData> aggregatedDataList, Integer numberOfDays) {
        // Sort the list by date in ascending order
        aggregatedDataList.sort(Comparator.comparing(AggregatedData::getDate));

        // Select the top 'numberOfDays' entries after sorting
        return aggregatedDataList.stream()
                .limit(numberOfDays)
                .map(aggregatedData -> new WeatherDataResponse(
                        aggregatedData.getDate().toString(),
                        aggregatedData.getMinTemp()-273,
                        aggregatedData.getMaxTemp()-273,
                        aggregatedData.getWindSpeed(),
                        messageAdder.getMessage(aggregatedData)
                ))
                .collect(Collectors.toList());
    }
}
