package com.myapp.backendactivityfinder.weather;

import lombok.*;

@AllArgsConstructor
@Getter
public class Weather {

    private String stacja;
    
    private String temperatura;

    private String predkosc_wiatru;

    private String suma_opadu;
    
    private String cicnienie;
}
