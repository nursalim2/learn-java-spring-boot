package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.configuration.FooConfiguration;
import com.nursalim.spring.boot.basic.data.MultiFoo;
import com.nursalim.spring.boot.basic.repository.CategoryRepository;
import com.nursalim.spring.boot.basic.repository.CustomerRepository;
import com.nursalim.spring.boot.basic.repository.ProductRepository;
import com.nursalim.spring.boot.basic.scope.ScanConfiguration;
import com.nursalim.spring.boot.basic.service.CategoryService;
import com.nursalim.spring.boot.basic.service.CustomerService;
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

    @Test
    void testSetterDI() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        context.registerShutdownHook();

        CategoryService categoryService = context.getBean(CategoryService.class);
        Assertions.assertNotNull(categoryService.getCategoryRepository());

        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
    }

    @Test
    void testFieldDI() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        context.registerShutdownHook();

        CustomerService customerService = context.getBean(CustomerService.class);
        Assertions.assertNotNull(customerService.getNormalCustomerRepository());

        CustomerRepository normalCustomerRepository = context.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = context.getBean("premiumCustomerRepository", CustomerRepository.class);

        Assertions.assertSame(normalCustomerRepository, customerService.getNormalCustomerRepository());
        Assertions.assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
    }

    @Test
    void testObjectProvider() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        MultiFoo multiFoo = context.getBean(MultiFoo.class);

        Assertions.assertEquals(3, multiFoo.getFoos().size());
    }
}
