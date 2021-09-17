package com.myapp.backendactivityfinder.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherMapper {

    public Weather mapToWeather(final WeatherDto weather) {
        return new Weather(weather.getStacja(), weather.getTemperatura(), weather.getPredkosc_wiatru(), weather.getSuma_opadu(), weather.getCisnienie());
    }
}
