package com.myapp.backendactivityfinder.service;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final ActivityRepository repository;

    public List<Activity> getNameAct() { return repository.findByName(null);}

    public List<Activity> getMinTimeAct() { return repository.findByMinTime(null);}

    public List<Activity> getMaxTimeAct() { return repository.findByMaxTime(null);}

    public List<Activity> getOnePersonAct() { return repository.findByOnePerson(true);}

    public List<Activity> getTwoPeopleAct() { return repository.findByTwoPeople(true);}

    public List<Activity> getMorePeopleAct() { return repository.findByMorePeople(true);}

    public List<Activity> getOutdoorAct() { return repository.findByOutdoor(true);}

    public List<Activity> getIndoorAct() { return repository.findByIndoor(true);}

    public List<Activity> getAllActivities() { return repository.findAll();}

    public List<Activity> getSummerAct() { return repository.findBySummer(true);}

    public List<Activity> getWinterAct() { return repository.findByWinter(true);}

    public List<Activity> getInCarAct() { return repository.findByInCar(true);}

    public List<Activity> getEducationalAct() { return repository.findByEducational(true);}

    public List<Activity> getArtAct() { return  repository.findByArt(true);}

    public List<Activity> getMotionAct() { return repository.findByMotion(true);}

    public List<Activity> getFavouriteAct() { return repository.findByFavourite(true);}

}
