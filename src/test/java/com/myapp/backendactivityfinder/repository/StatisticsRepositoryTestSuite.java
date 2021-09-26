package com.myapp.backendactivityfinder.repository;

import com.myapp.backendactivityfinder.domain.Statistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StatisticsRepositoryTestSuite {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Test
    public void testStatisticsRepositorySave() {

        //Given
        Statistics statistics = new Statistics(null, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);

        //When
        statisticsRepository.save(statistics);

        //Then
        Long id = statistics.getId();
        Optional<Statistics> findStatistics = statisticsRepository.findById(id);
        assertTrue(findStatistics.isPresent());

        //CleanUp
        statisticsRepository.deleteById(id);
    }
}
