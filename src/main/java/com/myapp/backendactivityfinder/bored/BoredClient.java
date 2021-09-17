package com.myapp.backendactivityfinder.bored;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Component
@RequiredArgsConstructor
@Slf4j
public class BoredClient {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    BoredConfig boredConfig;

    public BoredDto getBored() {
        URI url = UriComponentsBuilder.fromHttpUrl(boredConfig.getBoredApiEndpoint())
                .build()
                .encode()
                .toUri();

        BoredDto response = restTemplate.getForObject(url, BoredDto.class);
        return response;
    }
}
