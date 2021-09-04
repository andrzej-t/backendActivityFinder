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

//    @GetMapping(value = "/min")
//    public List<Activity> getMinTimeActivities() {
//        return service.getMinTimeAct();
//    }
//
//    @GetMapping(value = "/max")
//    public List<Activity> getMaxTimeActivities() {
//        return service.getMaxTimeAct();
//    }

    @GetMapping(value = "/one")
    public List<Activity> getOneActivities() {
        return service.getOnePersonAct();
    }

    @GetMapping(value = "/two")
    public List<Activity> getTwoActivities() {
        return service.getTwoPeopleAct();
    }

    @GetMapping(value = "/more")
    public List<Activity> getMorePeopleActivities() {
        return service.getMorePeopleAct();
    }

    @GetMapping(value = "/outdoor")
    public List<Activity> getOutdoorActivities() {
        return service.getOutdoorAct();
    }

    @GetMapping(value = "/indoor")
    public List<Activity> getIndoorActivities() {
        return service.getIndoorAct();
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

    @GetMapping(value = "/educational")
    public List<Activity> getEducationalActivities() {
        return service.getEducationalAct();
    }

    @GetMapping(value = "/art")
    public List<Activity> getArtActivities() {
        return service.getArtAct();
    }

    @GetMapping(value = "/motion")
    public List<Activity> getMotionActivities() {
        return service.getMotionAct();
    }

    @GetMapping(value = "/favourite")
    public List<Activity> getFavouriteActivities() {
        return service.getFavouriteAct();
    }
}
