package com.myapp.backendactivityfinder.mapper;

import com.myapp.backendactivityfinder.domain.Weather;
import com.myapp.backendactivityfinder.domain.WeatherDto;
import com.myapp.backendactivityfinder.weather.WeatherClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeatherMapperTestSuite {

    @Autowired
    WeatherMapper weatherMapper;

    @Autowired
    WeatherClient weatherClient;

    @Test
    public void testMapToWeather() {

        //Given
        WeatherDto weatherDto = weatherClient.getWeather("warszawa");

        //When
        Weather result = weatherMapper.mapToWeather(weatherDto);

        //Then
        assertEquals("Warszawa", result.getStacja());
    }
}
