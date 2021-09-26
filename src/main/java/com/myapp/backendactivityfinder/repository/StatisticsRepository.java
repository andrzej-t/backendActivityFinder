package com.myapp.backendactivityfinder.repository;

import com.myapp.backendactivityfinder.domain.Statistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Long> {

    @Override
    List<Statistics> findAll();

    List<Statistics> findAllByLikeStat(Long aLong);
}
