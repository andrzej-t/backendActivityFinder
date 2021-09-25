package com.myapp.backendactivityfinder.mapper;

import com.myapp.backendactivityfinder.domain.Statistics;
import com.myapp.backendactivityfinder.domain.StatisticsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatisticsMapperTestSuite {

    @Autowired
    StatisticsMapper statisticsMapper;

    @Test
    public void testMapToStatistics() {

        //Given
        StatisticsDto statisticsDto = new StatisticsDto(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L );

        //When
        Statistics result = statisticsMapper.mapToStatistics(statisticsDto);

        //Then
        assertEquals(1L, result.getId());
        assertEquals(1L, result.getLikeStat());
        assertEquals(1L, result.getArtStat());
        assertEquals(1L, result.getEduStat());
        assertEquals(1L, result.getMotionStat());
        assertEquals(1L, result.getCarStat());
        assertEquals(1L, result.getOneStat());
        assertEquals(1L, result.getTwoStat());
        assertEquals(1L, result.getMoreStat());
        assertEquals(1L, result.getOutdoorStat());
        assertEquals(1L, result.getIndoorStat());
        assertEquals(1L, result.getSummerStat());
        assertEquals(1L, result.getWinterStat());
    }

    @Test
    public void testMapToStatisticsDto() {

        //Given
        Statistics statistics = new Statistics(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L );

        //When
        StatisticsDto result = statisticsMapper.mapToStatisticsDto(statistics);

        //Then
        assertEquals(1L, result.getId());
        assertEquals(1L, result.getLikeStat());
        assertEquals(1L, result.getArtStat());
        assertEquals(1L, result.getEduStat());
        assertEquals(1L, result.getMotionStat());
        assertEquals(1L, result.getCarStat());
        assertEquals(1L, result.getOneStat());
        assertEquals(1L, result.getTwoStat());
        assertEquals(1L, result.getMoreStat());
        assertEquals(1L, result.getOutdoorStat());
        assertEquals(1L, result.getIndoorStat());
        assertEquals(1L, result.getSummerStat());
        assertEquals(1L, result.getWinterStat());
    }
}
