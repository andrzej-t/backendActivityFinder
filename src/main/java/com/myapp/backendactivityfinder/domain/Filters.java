package com.myapp.backendactivityfinder.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Filters {
    boolean artFilter;
    boolean eduFilter;
    boolean motFilter;
    boolean carFilter;
    boolean oneFilter;
    boolean twoFilter;
    boolean moreFilter;
    boolean outFilter;
    boolean inFilter;
    boolean summerFilter;
    boolean winterFilter;
}
