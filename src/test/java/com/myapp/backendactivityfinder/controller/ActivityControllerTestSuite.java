package com.myapp.backendactivityfinder.controller;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import com.myapp.backendactivityfinder.facade.ActivityFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;

@SpringJUnitWebConfig
@WebMvcTest(ActivityController.class)
public class ActivityControllerTestSuite {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ActivityFacade activityFacade;

    @Test
    public void testShouldGetActivities() throws Exception {

        //Given
        List<ActivityDto> activityDtoList = new ArrayList<>();
        activityDtoList.add(new ActivityDto(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, false));
        activityDtoList.add(new ActivityDto(2L, "testName2", "testDescription2", 10, 60, true, true, true, true, true, true, true, true, true, true, true, false));
        when(activityFacade.showActivities()).thenReturn(activityDtoList);

        //When & Then
        mockMvc.perform(get("/v1/activities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[1].name", is("testName2")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[1].description", is("testDescription2")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[1].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[1].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[1].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[1].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[1].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[1].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[1].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[1].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[1].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[1].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[1].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[1].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[1].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(false)))
                .andExpect(jsonPath("$[1].favourite", is(false)));
    }

    @Test
    public void testShouldGetMinTimeActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showMinTimeAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/min")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetMaxTimeActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showMaxTimeAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/max")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetOnePersonActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showOnePersonAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/one")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetTwoPeopleActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showTwoPeopleAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/two")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetMorePeopleActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showMorePeopleAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/more")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetOutdoorActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showOutdoorAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/outdoor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetIndoorActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showIndoorAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/indoor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetSummerActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showSummerAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/summer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetWinterActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showWinterAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/winter")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetCarActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showInCarAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/car")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetEducationalActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showEducationalAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/educational")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetArtActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showArtAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/art")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }

    @Test
    public void testShouldGetMotionActivities() throws Exception {

        //Given
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(1L, "testName1", "testDescription1", 10, 60, true, true, true, true, true, true, true, true, true, true, true, true));
        when(activityFacade.showMotionAct()).thenReturn(activityList);

        //When & Then
        mockMvc.perform(get("/v1/motion")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testName1")))
                .andExpect(jsonPath("$[0].description", is("testDescription1")))
                .andExpect(jsonPath("$[0].minTime", is(10)))
                .andExpect(jsonPath("$[0].maxTime", is(60)))
                .andExpect(jsonPath("$[0].onePerson", is(true)))
                .andExpect(jsonPath("$[0].twoPeople", is(true)))
                .andExpect(jsonPath("$[0].morePeople", is(true)))
                .andExpect(jsonPath("$[0].outdoor", is(true)))
                .andExpect(jsonPath("$[0].indoor", is(true)))
                .andExpect(jsonPath("$[0].summer", is(true)))
                .andExpect(jsonPath("$[0].winter", is(true)))
                .andExpect(jsonPath("$[0].inCar", is(true)))
                .andExpect(jsonPath("$[0].educational", is(true)))
                .andExpect(jsonPath("$[0].art", is(true)))
                .andExpect(jsonPath("$[0].motion", is(true)))
                .andExpect(jsonPath("$[0].favourite", is(true)));
    }


}
