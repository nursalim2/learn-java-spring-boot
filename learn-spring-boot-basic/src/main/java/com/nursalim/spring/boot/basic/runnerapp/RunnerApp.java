package com.nursalim.spring.boot.basic.runnerapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class RunnerApp {

    public static void main(String[] args) {
        SpringApplication.run(RunnerApp.class, args);
    }

    @Slf4j
    @Component
    public static class SimpleRunner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {
            List<String> profiles = args.getOptionValues("profiles");
            log.info("profiles : {}", profiles);

        }
    }
}
