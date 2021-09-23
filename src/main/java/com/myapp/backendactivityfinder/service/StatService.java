package com.myapp.backendactivityfinder.service;

import com.myapp.backendactivityfinder.domain.Statistics;
import com.myapp.backendactivityfinder.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatService {

    private final StatisticsRepository statisticsRepository;

    public Statistics saveStatistics(final Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    public List<Statistics> getAllStatistics() { return statisticsRepository.findAll(); }

    public void deleteStatistics() { statisticsRepository.deleteAll(); }

    public Long getLikes() {
        return statisticsRepository.findAllByLikeStat(1L).stream().count();
    }
}
