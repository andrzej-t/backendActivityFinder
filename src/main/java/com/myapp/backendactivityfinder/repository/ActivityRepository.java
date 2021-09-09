package com.myapp.backendactivityfinder.repository;

import com.myapp.backendactivityfinder.domain.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

    @Override
    List<Activity> findAll();

    Optional<Activity> findById(Long id);

    List<Activity> findByName(String name);

    List<Activity> findByMinTime(Integer integer);

    List<Activity> findByMaxTime(Integer integer);

    List<Activity> findByOnePerson(Boolean onePerson);

    List<Activity> findByTwoPeople(Boolean twoPeople);

    List<Activity> findByMorePeople(Boolean morePeople);

    List<Activity> findByOutdoor(Boolean outdoor);

    List<Activity> findByIndoor(Boolean indoor);

    List<Activity> findBySummer(Boolean summer);

    List<Activity> findByWinter(Boolean winter);

    List<Activity> findByInCar(Boolean inCar);

    List<Activity> findByEducational(Boolean educational);

    List<Activity> findByArt(Boolean art);

    List<Activity> findByMotion(Boolean motion);

    List<Activity> findByFavourite(Boolean favourite);
}