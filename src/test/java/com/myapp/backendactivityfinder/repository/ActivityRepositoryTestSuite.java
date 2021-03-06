package com.myapp.backendactivityfinder.repository;

import com.myapp.backendactivityfinder.domain.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ActivityRepositoryTestSuite {

    @Autowired
    private ActivityRepository activityRepository;

    @Test
    public void testActivityRepositorySave() {

        //Given
        Activity activity = new Activity(null, "Edukacyjne nie", "Test2", 10, 120, true, true, true, true, true, true, true, true, false, false, false, true);

        //When
        activityRepository.save(activity);

        //Then
        Long id = activity.getId();
        Optional<Activity> findActivity = activityRepository.findById(id);
        assertTrue(findActivity.isPresent());

        //CleanUp
        activityRepository.deleteById(id);
    }
}
