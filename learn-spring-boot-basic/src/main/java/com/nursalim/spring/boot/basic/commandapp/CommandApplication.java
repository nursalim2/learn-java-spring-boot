package com.nursalim.spring.boot.basic.commandapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class CommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }

    @Slf4j
    @Component
    public static class LogCommandLineRunner implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            log.info("Run with args : {}", Arrays.toString(args));
        }
    }
}
