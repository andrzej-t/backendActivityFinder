package com.myapp.backendactivityfinder.logic;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class Logic {

    @Autowired
    private DbService service;

    public List<Activity> getRandomAct() {
        Random random = new Random();
        List<Activity> randomList = new ArrayList<>();
        randomList.add(service.getAllActivities().get(random.nextInt(service.getAllActivities().size())));
        return randomList;
    }
}