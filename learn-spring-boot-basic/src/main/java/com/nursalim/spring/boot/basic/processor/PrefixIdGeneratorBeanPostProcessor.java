package com.nursalim.spring.boot.basic.processor;

import com.nursalim.spring.boot.basic.aware.IdAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

@Slf4j
public class PrefixIdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Prefix Id Generator processor for bean {}", beanName);
        if (bean instanceof IdAware) {
            log.info("Prefix Set id generator for bean {}", beanName);
            IdAware idAware = (IdAware) bean;
            idAware.setId("NUR-" + idAware.getId());
        }
        return bean;
    }
}
