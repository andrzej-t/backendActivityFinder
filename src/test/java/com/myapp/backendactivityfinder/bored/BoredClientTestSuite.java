package com.myapp.backendactivityfinder.bored;

import com.myapp.backendactivityfinder.domain.BoredDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BoredClientTestSuite {

    @InjectMocks
    private BoredClient boredClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private BoredConfig boredConfig;

    @Test
    public void ShouldFetchActivityFromBored() throws URISyntaxException {

        //Given
        when(boredConfig.getBoredApiEndpoint()).thenReturn("https://test.com");
        URI url = new URI("https://test.com");
        BoredDto boredDto = new BoredDto("Test my application");
        when(restTemplate.getForObject(url, BoredDto.class)).thenReturn(boredDto);

        //When
        BoredDto fetchedActivity = boredClient.getBored();

        //Then
        assertEquals("Test my application", fetchedActivity.getActivity());
    }
}
