package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.PaymentGatewayClient;
import com.nursalim.spring.boot.basic.factory.PaymentGatewayClientFactoryBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {
    @Test
    void testFactoryBean() throws Exception {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
        context.registerShutdownHook();

        PaymentGatewayClient paymentGatewayClient = context.getBean(PaymentGatewayClient.class);
        Assertions.assertEquals("https://payment", paymentGatewayClient.getEndPoint());
        Assertions.assertEquals("PUBLIC", paymentGatewayClient.getPublicKey());
        Assertions.assertEquals("PRIVATE", paymentGatewayClient.getPrivateKey());

    }
}
