package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.service.MerchantServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MerchantServiceImpl.class})
public class InheritanceConfiguration {
}
