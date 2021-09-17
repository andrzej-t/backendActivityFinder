package com.myapp.backendactivityfinder.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class WeatherDto {

    @JsonProperty("stacja")
    private String stacja;

    @JsonProperty("temperatura")
    private String temperatura;

    @JsonProperty("predkosc_wiatru")
    private String predkosc_wiatru;

    @JsonProperty("suma_opadu")
    private String suma_opadu;

    @JsonProperty("cisnienie")
    private String cisnienie;
}
