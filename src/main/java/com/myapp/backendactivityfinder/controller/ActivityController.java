package com.myapp.backendactivityfinder.controller;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import com.myapp.backendactivityfinder.mapper.ActivityMapper;
import com.myapp.backendactivityfinder.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ActivityController {

    private final DbService service;
    private final ActivityMapper activityMapper;

    public List<ActivityDto> getActivities() {
        List<Activity> activityList = service.getAllActivities();
        return activityMapper.mapToActivityDtoList(activityList);
    }
}
