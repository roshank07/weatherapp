package com.weather.data.DTO;
import lombok.Data;
import java.util.List;

@Data
public class WeatherAPIClientResponse {
    private List<WeatherEntry> list;
}
