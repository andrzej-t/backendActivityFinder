package com.myapp.backendactivityfinder.controller;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import com.myapp.backendactivityfinder.exception.ActivitiesNotFoundException;
import com.myapp.backendactivityfinder.facade.ActivityFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ActivityController {

    @Autowired
    private ActivityFacade activityFacade;

    @GetMapping(value = "/activities")
    public List<ActivityDto> getActivities() { return activityFacade.showActivities(); }

    @PutMapping(value = "/activity")
    public ActivityDto updateActivity(@RequestBody ActivityDto activityDto) { return activityFacade.refreshActivities(activityDto); }

    @PutMapping(value = "/update")
    public ResponseEntity<ActivityDto> update(@RequestBody ActivityDto activity) { return activityFacade.refresh(activity); }

    @PostMapping(value = "/activity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createActivity(@RequestBody ActivityDto activityDto) { activityFacade.makeAct(activityDto); }

    @GetMapping(value = "/activity/{id}")
    public ResponseEntity<ActivityDto> getById(@PathVariable Long id) { return activityFacade.getWithId(id); }

    @DeleteMapping(value = "/activities")
    public void deleteActivities() throws ActivitiesNotFoundException { activityFacade.removeAct(); }

    @GetMapping(value = "/random")
    public List<Activity> getRandomActivities() { return activityFacade.showRandomAct(); }

    @GetMapping(value = "/name")
    public List<Activity> getNameActivities() { return activityFacade.showNameAct(); }

    @GetMapping(value = "/min")
    public List<Activity> getMinTimeActivities() {
        return activityFacade.showMinTimeAct();
    }

    @GetMapping(value = "/max")
    public List<Activity> getMaxTimeActivities() { return activityFacade.showMaxTimeAct(); }

    @GetMapping(value = "/one")
    public List<Activity> getOneActivities() {
        return activityFacade.showOnePersonAct();
    }

    @GetMapping(value = "/two")
    public List<Activity> getTwoActivities() {
        return activityFacade.showTwoPeopleAct();
    }

    @GetMapping(value = "/more")
    public List<Activity> getMorePeopleActivities() { return activityFacade.showMorePeopleAct(); }

    @GetMapping(value = "/outdoor")
    public List<Activity> getOutdoorActivities() {
        return activityFacade.showOutdoorAct();
    }

    @GetMapping(value = "/indoor")
    public List<Activity> getIndoorActivities() {
        return activityFacade.showIndoorAct();
    }

    @GetMapping(value = "/summer")
    public List<Activity> getSummerActivities() {
        return activityFacade.showSummerAct();
    }

    @GetMapping(value = "/winter")
    public List<Activity> getWinterActivities() {
        return activityFacade.showWinterAct();
    }

    @GetMapping(value = "/car")
    public List<Activity> getInCarActivities() {
        return activityFacade.showInCarAct();
    }

    @GetMapping(value = "/educational")
    public List<Activity> getEducationalActivities() {
        return activityFacade.showEducationalAct();
    }

    @GetMapping(value = "/art")
    public List<Activity> getArtActivities() {
        return activityFacade.showArtAct();
    }

    @GetMapping(value = "/motion")
    public List<Activity> getMotionActivities() {
        return activityFacade.showMotionAct();
    }

    @GetMapping(value = "/newest")
    public List<Activity> getNewestActivities() { return activityFacade.showNewestAct(); }
}