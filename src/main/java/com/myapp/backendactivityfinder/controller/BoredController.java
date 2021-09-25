package com.myapp.backendactivityfinder.controller;

import com.myapp.backendactivityfinder.bored.BoredClient;
import com.myapp.backendactivityfinder.mapper.BoredMapper;
import com.myapp.backendactivityfinder.domain.Bored;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/bored")
@RequiredArgsConstructor
public class BoredController {

    @Autowired
    BoredClient boredClient;

    @Autowired
    BoredMapper boredMapper;

    @PostMapping(value = "/show")
    public Bored showBored() {
        return boredMapper.mapToBored(boredClient.getBored());
    }
}
