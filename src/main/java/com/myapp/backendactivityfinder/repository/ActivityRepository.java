package com.myapp.backendactivityfinder.repository;

import com.myapp.backendactivityfinder.domain.Activity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
    @Override
    Set<Activity> findAll();
}
