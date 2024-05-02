package com.weather.data.service;

import com.weather.data.DTO.WeatherAPIClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherAPIClient {

    @Value("${weather.api.baseurl}")
    private String baseUrl;

    @Value("${weather.api.key}")
    private String apiKey;


    private final RestTemplate restTemplate;

    @Autowired
    public WeatherAPIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherAPIClientResponse getWeatherForecast(String city,Integer numberOfDays) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("cnt", numberOfDays*8)
                .toUriString();

        return restTemplate.getForObject(url, WeatherAPIClientResponse.class);
    }
}

