package com.myapp.backendactivityfinder.mapper;

import com.myapp.backendactivityfinder.bored.BoredClient;
import com.myapp.backendactivityfinder.domain.Bored;
import com.myapp.backendactivityfinder.domain.BoredDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoredMapperTestSuite {

    @Autowired
    BoredMapper boredMapper;

    @Autowired
    BoredClient boredClient;

    @Test
    public void testMapToBored() {

        //Given
        BoredDto boredDto = boredClient.getBored();

        //When
        Bored result = boredMapper.mapToBored(boredDto);

        //Then
        assertEquals(boredDto.getActivity(), result.getActivity());
    }
}
