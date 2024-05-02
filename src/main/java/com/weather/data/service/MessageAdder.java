package com.weather.data.service;

import com.weather.data.DTO.AggregatedData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageAdder {
    @Value("${weather.api.temperatureThreshold}")
    private String temperatureThreshold;

    @Value("${weather.api.windThreshold}")
    private String windThreshold;

    @Value("${weather.api.umbrellaMessage}")
    private String umbrellaMessage;

    @Value("${weather.api.sunscreenMessage}")
    private String sunscreenMessage;

    @Value("${weather.api.windMessage}")
    private String windMessage;


    public List<String> getMessage(AggregatedData aggregatedData) {
        List<String> messages = new ArrayList<>();

        if(aggregatedData.getMaxTemp() - 273 > Double.parseDouble(temperatureThreshold)) {
            messages.add(umbrellaMessage);
            messages.add(sunscreenMessage);
        }

        if(aggregatedData.getWindSpeed() > Double.parseDouble(windThreshold)) {
            messages.add(windMessage);
        }

        if(aggregatedData.getWeatherCondition().contains("rain")) {
            messages.add(umbrellaMessage);
        }

        return messages;
    }
}
