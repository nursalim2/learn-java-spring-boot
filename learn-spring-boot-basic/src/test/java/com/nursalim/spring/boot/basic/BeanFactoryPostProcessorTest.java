package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Foo;
import com.nursalim.spring.boot.basic.processor.FooBeanFactoryPostProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanFactoryPostProcessorTest {

    @Configuration
    @Import(FooBeanFactoryPostProcessor.class)
    public static class TestConfiguration {

    }

    @Test
    void testBeanFactoryPostProcessor() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorTest.TestConfiguration.class);
        context.registerShutdownHook();

        Foo bean = context.getBean(Foo.class);
    }
}
