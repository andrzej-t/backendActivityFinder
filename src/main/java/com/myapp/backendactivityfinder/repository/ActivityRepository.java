package com.myapp.backendactivityfinder.repository;

import com.myapp.backendactivityfinder.domain.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

    @Override
    List<Activity> findAll();

    List<Activity> findByWinter(Boolean winter);

    List<Activity> findBySummer(Boolean summer);

    List<Activity> findByInCar(Boolean inCar);
}
