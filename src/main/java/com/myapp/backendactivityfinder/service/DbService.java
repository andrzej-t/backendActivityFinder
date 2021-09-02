package com.myapp.backendactivityfinder.service;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DbService {

    private final ActivityRepository repository;

    public Set<Activity> getAllActivities() { return repository.findAll();}

}
