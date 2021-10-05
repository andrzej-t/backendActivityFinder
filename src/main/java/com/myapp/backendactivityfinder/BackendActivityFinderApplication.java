package com.myapp.backendactivityfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BackendActivityFinderApplication extends SpringBootServletInitializer {
//public class BackendActivityFinderApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackendActivityFinderApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(BackendActivityFinderApplication.class);
//    }
}
