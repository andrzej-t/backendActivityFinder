package com.myapp.backendactivityfinder.service;

import com.myapp.backendactivityfinder.domain.Activity;
import com.myapp.backendactivityfinder.domain.ActivityDto;
import com.myapp.backendactivityfinder.domain.Filters;
import com.myapp.backendactivityfinder.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    @Autowired
    Filters filters;

    private final ActivityRepository repository;

    public Activity saveActivity(final Activity activity) {
        return repository.save(activity);
    }

    public Optional<Activity> findById(Long id) {
        return repository.findById(id);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
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

    public List<Activity> getAllActivities() { return repository.findAll();}

    public List<Activity> getNameAct() { return repository.findByName(null);}

    public List<Activity> getMinTimeAct() { return repository.findByMinTime(null);}

    public List<Activity> getMaxTimeAct() { return repository.findByMaxTime(null);}

    public List<Activity> getOnePersonAct() {
        filters.setOneFilter(true);
        filters.setTwoFilter(false);
        filters.setMoreFilter(false);

        return filterResults();
    }

    public List<Activity> getTwoPeopleAct() {
        filters.setOneFilter(false);
        filters.setTwoFilter(true);
        filters.setMoreFilter(false);

        return filterResults();
    }

    public List<Activity> getMorePeopleAct() {
        filters.setOneFilter(false);
        filters.setTwoFilter(false);
        filters.setMoreFilter(true);

        return filterResults();
    }

    public List<Activity> getOutdoorAct() {
        filters.setOutFilter(true);
        filters.setInFilter(false);

        return filterResults();
    }

    public List<Activity> getIndoorAct() {
        filters.setOutFilter(false);
        filters.setInFilter(true);

        return filterResults();
    }

    public List<Activity> getSummerAct() {
        filters.setSummerFilter(true);
        filters.setWinterFilter(false);

        return filterResults();
    }

    public List<Activity> getWinterAct() {
        filters.setSummerFilter(false);
        filters.setWinterFilter(true);

        return filterResults();
    }

    public List<Activity> getInCarAct() {
        filters.setArtFilter(false);
        filters.setEduFilter(false);
        filters.setMotFilter(false);
        filters.setCarFilter(true);

        return filterResults();
    }

    public List<Activity> getEducationalAct() {
        filters.setArtFilter(false);
        filters.setEduFilter(true);
        filters.setMotFilter(false);
        filters.setCarFilter(false);

        return filterResults();
    }

    public List<Activity> getArtAct() {
        filters.setArtFilter(true);
        filters.setEduFilter(false);
        filters.setMotFilter(false);
        filters.setCarFilter(false);

        return filterResults();
    }

    public List<Activity> getMotionAct() {
        filters.setArtFilter(false);
        filters.setEduFilter(false);
        filters.setMotFilter(true);
        filters.setCarFilter(false);

        return filterResults();
    }

    public List<Activity> filterResults() {
        return getAllActivities().stream()
                .filter(activity -> filters.isArtFilter() ? activity.getArt() : true)
                .filter(activity -> filters.isEduFilter() ? activity.getEducational() : true)
                .filter(activity -> filters.isMotFilter() ? activity.getMotion() : true)
                .filter(activity -> filters.isCarFilter() ? activity.getInCar() : true)
                .filter(activity -> filters.isOneFilter() ? activity.getOnePerson() : true)
                .filter(activity -> filters.isTwoFilter() ? activity.getTwoPeople() : true)
                .filter(activity -> filters.isMoreFilter() ? activity.getMorePeople() : true)
                .filter(activity -> filters.isOutFilter() ? activity.getOutdoor() : true)
                .filter(activity -> filters.isInFilter() ? activity.getIndoor() : true)
                .filter(activity -> filters.isSummerFilter() ? activity.getSummer() : true)
                .filter(activity -> filters.isWinterFilter() ? activity.getWinter() : true)
                .collect(Collectors.toList());
    }

    public void clearFilters() {
        filters.setArtFilter(false);
        filters.setEduFilter(false);
        filters.setMotFilter(false);
        filters.setCarFilter(false);
        filters.setOneFilter(false);
        filters.setTwoFilter(false);
        filters.setMoreFilter(false);
        filters.setOutFilter(false);
        filters.setInFilter(false);
        filters.setSummerFilter(false);
        filters.setWinterFilter(false);
    }

    public List<Activity> getNewestAct() {
        List<Activity> all = repository.findAll();
        List<Activity> newest = new ArrayList<>();

        newest.add(all.get(all.size()-1));
        newest.add(all.get(all.size()-2));
        newest.add(all.get(all.size()-3));
        newest.add(all.get(all.size()-4));
        newest.add(all.get(all.size()-5));

        return newest;
    }

    public List<Activity> getRandomAct() {
        Random random = new Random();
        List<Activity> randomList = new ArrayList<>();
        randomList.add(getAllActivities().get(random.nextInt(getAllActivities().size())));
        return randomList;
    }
}