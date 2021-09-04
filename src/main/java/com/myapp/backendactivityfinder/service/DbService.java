package com.myapp.backendactivityfinder.service;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final ActivityRepository repository;

    public List<Activity> getAllActivities() { return repository.findAll();}

    public List<Activity> getWinterAct() { return repository.findByWinter(true);}

    public List<Activity> getSummerAct() { return repository.findBySummer(true);}

    public List<Activity> getInCarAct() { return repository.findByInCar(true);}

}
