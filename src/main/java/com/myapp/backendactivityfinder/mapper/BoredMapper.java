package com.myapp.backendactivityfinder.mapper;

import com.myapp.backendactivityfinder.domain.Bored;
import com.myapp.backendactivityfinder.domain.BoredDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoredMapper {

    public Bored mapToBored(final BoredDto boredDto) {
        return new Bored(boredDto.getActivity());
    }
}
