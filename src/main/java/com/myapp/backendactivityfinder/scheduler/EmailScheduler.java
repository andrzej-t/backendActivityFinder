package com.myapp.backendactivityfinder.scheduler;

import com.myapp.backendactivityfinder.configuration.AdminConfig;
import com.myapp.backendactivityfinder.domain.Mail;
import com.myapp.backendactivityfinder.service.SimpleEmailService;
import com.myapp.backendactivityfinder.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "Activity Finder: statistic info";
    private final SimpleEmailService simpleEmailService;
    private final StatService statService;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long likesNumber = statService.getLikes();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "Currently " + likesNumber + " times was clicked thumbsUpButton",
                        "pareekshan@interia.pl"
                )
        );
    }
}
