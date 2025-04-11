package com.nursalim.spring.boot.basic.factory;

import com.nursalim.spring.boot.basic.data.PaymentGatewayClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient> {
    @Override
    public PaymentGatewayClient getObject() throws Exception {
        PaymentGatewayClient paymentGatewayClient = new PaymentGatewayClient();
        paymentGatewayClient.setEndPoint("https://payment");
        paymentGatewayClient.setPublicKey("PUBLIC");
        paymentGatewayClient.setPrivateKey("PRIVATE");
        return paymentGatewayClient;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
