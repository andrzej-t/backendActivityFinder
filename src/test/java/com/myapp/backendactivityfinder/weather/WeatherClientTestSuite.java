package com.myapp.backendactivityfinder.weather;

import com.myapp.backendactivityfinder.domain.WeatherDto;
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
public class WeatherClientTestSuite {

    @InjectMocks
    private WeatherClient weatherClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WeatherConfig weatherConfig;

    @Test
    public void  ShouldFetchWeather() throws URISyntaxException {

        //Given
        when(weatherConfig.getWeatherApiEndpoint()).thenReturn("https://test.com");

        WeatherDto weatherDto = new WeatherDto("testStacja", "testTemperatura", "testPredkoscWiatru", "testSumaOpadu", "testCisnienie");

        URI url = new URI("https://test.com" + "/station/" + weatherDto.getStacja());

        when(restTemplate.getForObject(url, WeatherDto.class)).thenReturn(weatherDto);

        //When
        WeatherDto fetchedTemperature = weatherClient.getWeather(weatherDto.getStacja());

        //Then
        assertEquals("testStacja", fetchedTemperature.getStacja());
        assertEquals("testTemperatura", fetchedTemperature.getTemperatura());
        assertEquals("testPredkoscWiatru", fetchedTemperature.getPredkosc_wiatru());
        assertEquals("testSumaOpadu", fetchedTemperature.getSuma_opadu());
        assertEquals("testCisnienie", fetchedTemperature.getCisnienie());
    }
}
