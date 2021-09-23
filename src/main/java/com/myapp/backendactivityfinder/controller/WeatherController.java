package com.myapp.backendactivityfinder.controller;

import com.myapp.backendactivityfinder.domain.Weather;
import com.myapp.backendactivityfinder.weather.WeatherClient;
import com.myapp.backendactivityfinder.mapper.WeatherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/weather")
@RequiredArgsConstructor
public class WeatherController {

    @Autowired
    WeatherClient weatherClient;
    @Autowired
    WeatherMapper weatherMapper;

    @GetMapping(value = "/get/{stacja}")
    public Weather getWeather(@PathVariable String stacja) {

        return weatherMapper.mapToWeather(weatherClient.getWeather(stacja));
    }
}
