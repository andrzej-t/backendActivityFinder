package com.myapp.backendactivityfinder.repository;

import com.myapp.backendactivityfinder.domain.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

    @Override
    List<Activity> findAll();

//    List<Activity> findByMinTime();
//
//    List<Activity> findByMaxTime();

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
