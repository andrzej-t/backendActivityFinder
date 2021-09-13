package com.myapp.backendactivityfinder.service;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import com.myapp.backendactivityfinder.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final ActivityRepository repository;

    public Activity saveActivity(final Activity activity) {
        return repository.save(activity);
    }

    public Optional<Activity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Optional<Activity> update(ActivityDto activity) {
        Optional<Activity> byId = repository.findById(activity.getId());

        byId.get().setName(activity.getName());
        byId.get().setDescription(activity.getDescription());
        byId.get().setMinTime(activity.getMinTime());
        byId.get().setMaxTime(activity.getMaxTime());
        byId.get().setOnePerson(activity.getOnePerson());
        byId.get().setTwoPeople(activity.getTwoPeople());
        byId.get().setMorePeople(activity.getMorePeople());
        byId.get().setOutdoor(activity.getOutdoor());
        byId.get().setIndoor(activity.getIndoor());
        byId.get().setSummer(activity.getSummer());
        byId.get().setWinter(activity.getWinter());
        byId.get().setInCar(activity.getInCar());
        byId.get().setEducational(activity.getEducational());
        byId.get().setArt(activity.getArt());
        byId.get().setMotion(activity.getMotion());
        byId.get().setFavourite(activity.getFavourite());

        return byId;
    }

    public void deleteActivities() {
        repository.deleteAll();
    }

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