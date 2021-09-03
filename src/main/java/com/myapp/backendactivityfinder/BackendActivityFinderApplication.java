package com.myapp.backendactivityfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class BackendActivityFinderApplication extends SpringBootServletInitializer {
//public class BackendActivityFinderApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackendActivityFinderApplication.class, args);
    }

}
