package com.myapp.backendactivityfinder.controller;

import com.myapp.backendactivityfinder.domain.Statistics;
import com.myapp.backendactivityfinder.exception.StatisticsNotFoundException;
import com.myapp.backendactivityfinder.domain.StatisticsDto;
import com.myapp.backendactivityfinder.mapper.StatisticsMapper;
import com.myapp.backendactivityfinder.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/stat")
@RequiredArgsConstructor
public class StatisticsController {

    @Autowired
    private StatService statService;

    @Autowired
    private StatisticsMapper statisticsMapper;

    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveValue(@RequestBody StatisticsDto statisticsDto) {
        Statistics statistics = statisticsMapper.mapToStatistics(statisticsDto);
        statService.saveStatistics(statistics);
    }

    @DeleteMapping(value = "/clear")
    public void clearStatistics() throws StatisticsNotFoundException {
        if (!statService.getAllStatistics().isEmpty()) {
            statService.deleteStatistics();
        } else {
            throw new StatisticsNotFoundException();
        }
    }

    @PutMapping(value = "/update")
    public StatisticsDto updateStatistics(@RequestBody StatisticsDto statisticsDto) {
        Statistics statistics = statisticsMapper.mapToStatistics(statisticsDto);
        Statistics savedStatistics = statService.saveStatistics(statistics);
        return statisticsMapper.mapToStatisticsDto(savedStatistics);
    }

    @GetMapping(value = "/likes")
    public Long showLikes() { return statService.getLikes(); }

}
