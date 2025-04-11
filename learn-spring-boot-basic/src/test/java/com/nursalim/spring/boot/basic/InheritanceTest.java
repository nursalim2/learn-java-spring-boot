package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.service.MerchantService;
import com.nursalim.spring.boot.basic.service.MerchantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InheritanceTest {
    @Test
    void testInheritance() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        context.registerShutdownHook();

        MerchantService merchantService = context.getBean(MerchantService.class);
        MerchantServiceImpl merchantServiceImpl = context.getBean(MerchantServiceImpl.class);

        Assertions.assertEquals(merchantService, merchantServiceImpl);

    }
}
