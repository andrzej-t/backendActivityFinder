package com.myapp.backendactivityfinder.mapper;

import com.myapp.backendactivityfinder.domain.Statistics;
import com.myapp.backendactivityfinder.domain.StatisticsDto;
import org.springframework.stereotype.Service;

@Service
public class StatisticsMapper {

    public Statistics mapToStatistics(final StatisticsDto statisticsDto) {

        return  new Statistics(
                statisticsDto.getId(),
                statisticsDto.getLikeStat(),
                statisticsDto.getArtStat(),
                statisticsDto.getEduStat(),
                statisticsDto.getMotionStat(),
                statisticsDto.getCarStat(),
                statisticsDto.getOneStat(),
                statisticsDto.getTwoStat(),
                statisticsDto.getMoreStat(),
                statisticsDto.getOutdoorStat(),
                statisticsDto.getIndoorStat(),
                statisticsDto.getSummerStat(),
                statisticsDto.getWinterStat()
        );
    }

    public StatisticsDto mapToStatisticsDto(final Statistics statistics) {

        return  new StatisticsDto(
                statistics.getId(),
                statistics.getLikeStat(),
                statistics.getArtStat(),
                statistics.getEduStat(),
                statistics.getMotionStat(),
                statistics.getCarStat(),
                statistics.getOneStat(),
                statistics.getTwoStat(),
                statistics.getMoreStat(),
                statistics.getOutdoorStat(),
                statistics.getIndoorStat(),
                statistics.getSummerStat(),
                statistics.getWinterStat()
        );
    }
}
