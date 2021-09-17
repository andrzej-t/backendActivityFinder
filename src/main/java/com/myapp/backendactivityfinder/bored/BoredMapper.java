package com.myapp.backendactivityfinder.bored;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoredMapper {

    public Bored mapToBored(final BoredDto boredDto) {
        return new Bored(boredDto.getActivity());
    }
}
