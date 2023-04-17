package com.issuetracker.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IssueTrackerPro {

    public static void main(String[] args) {
        SpringApplication.run(IssueTrackerPro.class, args);
    }

}
