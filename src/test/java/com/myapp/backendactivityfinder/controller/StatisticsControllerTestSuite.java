package com.myapp.backendactivityfinder.controller;

import com.google.gson.Gson;
import com.myapp.backendactivityfinder.domain.Statistics;
import com.myapp.backendactivityfinder.domain.StatisticsDto;
import com.myapp.backendactivityfinder.mapper.StatisticsMapper;
import com.myapp.backendactivityfinder.service.StatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(StatisticsController.class)
public class StatisticsControllerTestSuite {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private StatisticsMapper statisticsMapper;

    @Autowired
    StatisticsController statisticsController;

    @MockBean
    private StatService statService;

    @Test
    public void shouldSaveLikes() throws Exception {

        //Given
        StatisticsDto statisticsDto = new StatisticsDto(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
        Statistics statistics = new Statistics(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
        when(statisticsMapper.mapToStatistics(statisticsDto)).thenReturn(statistics);
        when(statService.saveStatistics(statistics)).thenReturn(statistics);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(statistics);

        //When & Then
        mockMvc.perform(post("/v1/stat/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().is(200));
    }
}
