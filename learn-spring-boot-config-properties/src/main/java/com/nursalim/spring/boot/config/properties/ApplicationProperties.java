package com.nursalim.spring.boot.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {
    private Date expiryDate;
    private Duration defaultTimeout;
    private String name;
    private Integer version;
    private Boolean productionMode;
    private DatabaseProperties database;
    private List<Role> defaultRoles;
    private Map<String, Role> roles;

    @Getter
    @Setter
    public static class DatabaseProperties {
        private String name;
        private String username;
        private String password;
        private String url;
        private List<String> whitelistTables;
        private Map<String, Integer> maxTableSize;
    }

    @Getter
    @Setter
    public static class Role {
        private String id;
        private String name;
    }
}
