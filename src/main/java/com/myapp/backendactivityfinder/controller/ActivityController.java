package com.myapp.backendactivityfinder.controller;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import com.myapp.backendactivityfinder.mapper.ActivityMapper;
import com.myapp.backendactivityfinder.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {

    @Autowired
    private DbService service;
    @Autowired
    private ActivityMapper activityMapper;

    @GetMapping
    public List<ActivityDto> getActivities() {
        List<Activity> activityList = service.getAllActivities();
        return activityMapper.mapToActivityDtoList(activityList);
    }
}
