package com.myapp.backendactivityfinder.domain;

import lombok.*;

@AllArgsConstructor
@Getter
public class Weather {

    private String stacja;
    
    private String temperatura;

    private String predkosc_wiatru;

    private String suma_opadu;
    
    private String cisnienie;

    @Override
    public String toString() {
        return "Weather: " + stacja + '\n' +
                "temperatura: " + temperatura + '\n' +
                "prędkość wiatru: " + predkosc_wiatru + '\n' +
                "suma opadu: " + suma_opadu + '\n' +
                "cisnienie: " + cisnienie + '\n';
    }
}
