package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.repository.ProductRepository;
import com.nursalim.spring.boot.basic.scope.ScanConfiguration;
import com.nursalim.spring.boot.basic.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    @Test
    void testComponent() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        context.registerShutdownHook();

        ProductService productService1 = context.getBean(ProductService.class);
        ProductService productService2 = (ProductService) context.getBean("productService");

        Assertions.assertNotNull(productService1);
        Assertions.assertNotNull(productService2);

    }

    @Test
    void testConstructorDI() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        context.registerShutdownHook();

        ProductService productService = context.getBean(ProductService.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Assertions.assertSame(productRepository, productService.getProductRepository());


    }
}
