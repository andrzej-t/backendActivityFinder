package com.myapp.backendactivityfinder.bored;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BoredConfig {
    @Value("${bored.api.endpoint.prod}")
    private String boredApiEndpoint;
}
