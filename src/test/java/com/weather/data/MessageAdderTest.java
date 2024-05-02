package com.weather.data;

import com.weather.data.DTO.AggregatedData;
import com.weather.data.service.MessageAdder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(properties = {
        "weather.api.temperatureThreshold=40",
        "weather.api.windThreshold=10",
        "weather.api.umbrellaMessage=Carry umbrella",
        "weather.api.sunscreenMessage=Use sunscreen lotion",
        "weather.api.windMessage=It is too windy, watch out!"
})
public class MessageAdderTest {

    @Autowired
    private MessageAdder messageAdder;

    @Mock
    private AggregatedData aggregatedData;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMessageForHighTemperatureAndWind() {
        when(aggregatedData.getMaxTemp()).thenReturn(315.0); // 42 degrees Celsius
        when(aggregatedData.getWindSpeed()).thenReturn(15.0);
        Set<String> st =  new HashSet<>();
        st.add("clear");
        when(aggregatedData.getWeatherCondition()).thenReturn(st);

        List<String> messages = messageAdder.getMessage(aggregatedData);

        assertEquals(3, messages.size());
        assertEquals("Carry umbrella", messages.get(0));
        assertEquals("Use sunscreen lotion", messages.get(1));
        assertEquals("It is too windy, watch out!", messages.get(2));
    }

    @Test
    public void testGetMessageForRainyWeather() {
        when(aggregatedData.getMaxTemp()).thenReturn(290.0); // 17 degrees Celsius
        when(aggregatedData.getWindSpeed()).thenReturn(5.0);
        Set<String> st =  new HashSet<>();
        st.add("rain");
        when(aggregatedData.getWeatherCondition()).thenReturn(st);
        List<String> messages = messageAdder.getMessage(aggregatedData);

        assertEquals(1, messages.size());
        assertEquals("Carry umbrella", messages.get(0));
    }
}
