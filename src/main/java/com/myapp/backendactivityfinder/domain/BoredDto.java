package com.myapp.backendactivityfinder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class BoredDto {

    @JsonProperty("activity")
    private String activity;
}
