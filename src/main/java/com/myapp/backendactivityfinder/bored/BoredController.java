package com.myapp.backendactivityfinder.bored;

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
    public Bored showNameday() {
        return boredMapper.mapToBored(boredClient.getBored());
    }
}
