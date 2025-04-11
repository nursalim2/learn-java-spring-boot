package com.nursalim.spring.boot.config.profileenvironment;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootTest(classes = ProfileEnvironmentTest.TestApplication.class)
public class ProfileEnvironmentTest {
    @Autowired
    TestApplication.SampleProfile sampleProfile;

    @Test
    void testGetActiveProfiles() {
        System.out.println(Arrays.toString(sampleProfile.getProfiles()));
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleProfile implements EnvironmentAware {
            @Setter
            private Environment environment;

            public String[] getProfiles() {
                return environment.getActiveProfiles();
            }
        }
    }
}
