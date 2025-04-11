package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.factory.PaymentGatewayClientFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PaymentGatewayClientFactoryBean.class)
public class FactoryConfiguration {

}
