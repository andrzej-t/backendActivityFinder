package com.myapp.backendactivityfinder.controller;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import com.myapp.backendactivityfinder.mapper.ActivityMapper;
import com.myapp.backendactivityfinder.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ActivityController {

    @Autowired
    private DbService service;
    @Autowired
    private ActivityMapper activityMapper;

    @GetMapping(value = "/activities")
    public List<ActivityDto> getActivities() {
        List<Activity> activityList = service.getAllActivities();
        return activityMapper.mapToActivityDtoList(activityList);
    }

    @GetMapping(value = "/summer")
    public List<Activity> getSummerActivities() {
        return service.getSummerAct();
    }

    @GetMapping(value = "/winter")
    public List<Activity> getWinterActivities() {
        return service.getWinterAct();
    }

    @GetMapping(value = "/car")
    public List<Activity> getInCarActivities() {
        return service.getInCarAct();
    }

}
