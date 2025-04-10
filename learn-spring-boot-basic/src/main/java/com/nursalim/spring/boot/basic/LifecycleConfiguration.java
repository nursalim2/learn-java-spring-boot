package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Connection;
import com.nursalim.spring.boot.basic.data.Server;
import org.springframework.context.annotation.Bean;

public class LifecycleConfiguration {
    @Bean
    public Connection connection() {
        return new Connection();
    }

    @Bean
//    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server server() {
        return new Server();
    }
}
