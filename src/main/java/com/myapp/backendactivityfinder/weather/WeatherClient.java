package com.myapp.backendactivityfinder.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherClient {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    WeatherConfig weatherConfig;

    public WeatherDto getWeather(String city) {
        URI url = UriComponentsBuilder.fromHttpUrl(weatherConfig.getWeatherApiEndpoint() + "/station/" + city)
                .build()
                .encode()
                .toUri();

        WeatherDto boardsResponse = restTemplate.getForObject(url, WeatherDto.class);
        return boardsResponse;
    }
}
