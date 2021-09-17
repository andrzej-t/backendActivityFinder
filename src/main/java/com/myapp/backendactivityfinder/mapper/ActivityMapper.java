package com.myapp.backendactivityfinder.mapper;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityMapper {

    public Activity mapToActivity(final ActivityDto activityDto) {
        return new Activity(
                activityDto.getId(),
                activityDto.getName(),
                activityDto.getDescription(),
                activityDto.getMinTime(),
                activityDto.getMaxTime(),
                activityDto.getOnePerson(),
                activityDto.getTwoPeople(),
                activityDto.getMorePeople(),
                activityDto.getOutdoor(),
                activityDto.getIndoor(),
                activityDto.getSummer(),
                activityDto.getWinter(),
                activityDto.getInCar(),
                activityDto.getEducational(),
                activityDto.getArt(),
                activityDto.getMotion(),
                activityDto.getFavourite()
        );
    }

    public ActivityDto mapToActivityDto(final Activity activity) {
        return new ActivityDto(
                activity.getId(),
                activity.getName(),
                activity.getDescription(),
                activity.getMinTime(),
                activity.getMaxTime(),
                activity.getOnePerson(),
                activity.getTwoPeople(),
                activity.getMorePeople(),
                activity.getOutdoor(),
                activity.getIndoor(),
                activity.getSummer(),
                activity.getWinter(),
                activity.getInCar(),
                activity.getEducational(),
                activity.getArt(),
                activity.getMotion(),
                activity.getFavourite()
        );
    }

    public List<ActivityDto> mapToActivityDtoList(final List<Activity> activityList) {
        return  activityList.stream()
                .map(this::mapToActivityDto)
                .collect(Collectors.toList());
    }
}