package com.weather.data.service;

import com.weather.data.DTO.AggregatedData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageAdder {
    public List<String> getMessage(AggregatedData aggregatedData) {
        List<String> messages = new ArrayList<>();

        if(aggregatedData.getMaxTemp() > 31) {
            messages.add("Carry umbrella");
            messages.add("Use sunscreen lotion");
        }

        if(aggregatedData.getWindSpeed() > 5) {
            messages.add("It’s too windy, watch out!");
        }

        if(aggregatedData.getWeatherCondition().contains("rain")) {
            messages.add("Carry an umbrella");
        }

        return messages;
    }
}
