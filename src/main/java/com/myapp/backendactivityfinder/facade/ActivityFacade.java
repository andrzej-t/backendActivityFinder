package com.myapp.backendactivityfinder.facade;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import com.myapp.backendactivityfinder.exception.ActivitiesNotFoundException;
import com.myapp.backendactivityfinder.mapper.ActivityMapper;
import com.myapp.backendactivityfinder.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class ActivityFacade {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityMapper activityMapper;

    public List<ActivityDto> showActivities() {
        List<Activity> activityList = activityService.getAllActivities();
        return activityMapper.mapToActivityDtoList(activityList);
    }

    public ActivityDto refreshActivities(ActivityDto activityDto) {
        Activity activity = activityMapper.mapToActivity(activityDto);
        Activity savedActivity = activityService.saveActivity(activity);
        return activityMapper.mapToActivityDto(savedActivity);
    }

    public ResponseEntity<ActivityDto> refresh(@RequestBody ActivityDto activity) {
        Optional<Activity> byId = activityService.update(activity);
        return byId.map(value -> new ResponseEntity<>(activityMapper.mapToActivityDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public void makeAct(@RequestBody ActivityDto activityDto) {
        Activity activity = activityMapper.mapToActivity(activityDto);
        activityService.saveActivity(activity);
    }

    public ResponseEntity<ActivityDto> getWithId(@PathVariable Long id) {
        Optional<Activity> activityById = activityService.findById(id);
        return activityById.map(activity ->
                new ResponseEntity<>(activityMapper.mapToActivityDto(activity),
                        HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public void removeAct() throws ActivitiesNotFoundException {
        if (!activityService.getAllActivities().isEmpty()) {
            activityService.deleteActivities();
        } else {
            throw new ActivitiesNotFoundException();
        }
    }

    public List<Activity> showNewestAct() { return activityService.getNewestAct(); }

    public List<Activity> showRandomAct() { return activityService.getRandomAct(); }

    public List<Activity> showNameAct() { return activityService.getNameAct(); }

    public List<Activity> showMinTimeAct() { return activityService.getMinTimeAct(); }

    public List<Activity> showMaxTimeAct() { return activityService.getMaxTimeAct(); }

    public List<Activity> showOnePersonAct() { return activityService.getOnePersonAct(); }

    public List<Activity> showTwoPeopleAct() { return activityService.getTwoPeopleAct(); }

    public List<Activity> showMorePeopleAct() { return activityService.getMorePeopleAct(); }

    public List<Activity> showOutdoorAct() { return activityService.getOutdoorAct(); }

    public List<Activity> showIndoorAct() { return activityService.getIndoorAct(); }

    public List<Activity> showSummerAct() { return activityService.getSummerAct(); }

    public List<Activity> showWinterAct() { return activityService.getWinterAct(); }

    public List<Activity> showInCarAct() { return activityService.getInCarAct(); }

    public List<Activity> showEducationalAct() { return activityService.getEducationalAct(); }

    public List<Activity> showArtAct() { return activityService.getArtAct(); }

    public List<Activity> showMotionAct() { return activityService.getMotionAct(); }

    public void resetFilters() { activityService.clearFilters(); }
}
