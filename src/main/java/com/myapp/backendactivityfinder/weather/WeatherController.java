package com.myapp.backendactivityfinder.weather;

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

    @GetMapping(value = "/get/{city}")
    public WeatherDto getWeather(@PathVariable String city) {
        return weatherClient.getWeather(city);
    }
}
