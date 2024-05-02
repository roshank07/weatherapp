package com.weather.data.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class AggregatedData {
    private LocalDate date;
    private double minTemp;
    private double maxTemp;
    private double windSpeed;
    private Set<String> weatherCondition;
}
