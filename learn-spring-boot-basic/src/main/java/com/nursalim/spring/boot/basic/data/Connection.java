package com.nursalim.spring.boot.basic.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class Connection implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Connection ready to set");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Connection closed");
    }
}
