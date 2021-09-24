package com.myapp.backendactivityfinder.mapper;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ActivityMapperTestSuite {

    @Autowired
    ActivityMapper activityMapper;

    @Test
    public void testMapToActivity() {
        //Given
        ActivityDto activityDto = new ActivityDto(1L, "testName", "testDescription", 15, 30, true, true,true, true, true, true, true, true, true, true, true, false);

        //When
        Activity result = activityMapper.mapToActivity(activityDto);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("testName", result.getName());
        assertEquals("testDescription", result.getDescription());
        assertEquals(15, result.getMinTime());
        assertEquals(30, result.getMaxTime());
        assertEquals(true, result.getOnePerson());
        assertEquals(true, result.getTwoPeople());
        assertEquals(true, result.getMorePeople());
        assertEquals(true, result.getOutdoor());
        assertEquals(true, result.getIndoor());
        assertEquals(true, result.getSummer());
        assertEquals(true, result.getWinter());
        assertEquals(true, result.getInCar());
        assertEquals(true, result.getEducational());
        assertEquals(true, result.getArt());
        assertEquals(true, result.getMotion());
        assertEquals(false, result.getFavourite());
    }

    @Test
    public void testMapToActivityDto() {
        //Given
        Activity activity = new Activity(1L, "testName", "testDescription", 15, 30, true, true,true, true, true, true, true, true, true, true, true, false);

        //When
        ActivityDto result = activityMapper.mapToActivityDto(activity);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("testName", result.getName());
        assertEquals("testDescription", result.getDescription());
        assertEquals(15, result.getMinTime());
        assertEquals(30, result.getMaxTime());
        assertEquals(true, result.getOnePerson());
        assertEquals(true, result.getTwoPeople());
        assertEquals(true, result.getMorePeople());
        assertEquals(true, result.getOutdoor());
        assertEquals(true, result.getIndoor());
        assertEquals(true, result.getSummer());
        assertEquals(true, result.getWinter());
        assertEquals(true, result.getInCar());
        assertEquals(true, result.getEducational());
        assertEquals(true, result.getArt());
        assertEquals(true, result.getMotion());
        assertEquals(false, result.getFavourite());
    }

    @Test
    public void testMapToActivityDtoList() {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName", "testDescription", 15, 30, true, true,true, true, true, true, true, true, true, true, true, false));

        //When
        List<ActivityDto> result = activityMapper.mapToActivityDtoList(activityList);

        //Then
        assertEquals(1L, result.get(0).getId());
        assertEquals("testName", result.get(0).getName());
        assertEquals("testDescription", result.get(0).getDescription());
        assertEquals(15, result.get(0).getMinTime());
        assertEquals(30, result.get(0).getMaxTime());
        assertEquals(true, result.get(0).getOnePerson());
        assertEquals(true, result.get(0).getTwoPeople());
        assertEquals(true, result.get(0).getMorePeople());
        assertEquals(true, result.get(0).getOutdoor());
        assertEquals(true, result.get(0).getIndoor());
        assertEquals(true, result.get(0).getSummer());
        assertEquals(true, result.get(0).getWinter());
        assertEquals(true, result.get(0).getInCar());
        assertEquals(true, result.get(0).getEducational());
        assertEquals(true, result.get(0).getArt());
        assertEquals(true, result.get(0).getMotion());
        assertEquals(false, result.get(0).getFavourite());
    }
}
