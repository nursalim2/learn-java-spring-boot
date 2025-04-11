package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeanFactoryTest {
    @Test
    void testBeanFactory() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);

        ObjectProvider<Foo> beanProvider = context.getBeanProvider(Foo.class);
        List<Foo> fooList = beanProvider.stream().toList();

        System.out.println(fooList);

        Map<String, Foo> beansOfType = context.getBeansOfType(Foo.class);
        beansOfType.forEach((s, foo) -> System.out.println(s + " : " + foo));




    }
}
