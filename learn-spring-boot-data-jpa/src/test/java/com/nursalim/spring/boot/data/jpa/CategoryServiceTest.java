package com.nursalim.spring.boot.data.jpa;

import com.nursalim.spring.boot.data.jpa.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    void testSuccess() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            categoryService.create();
        });

        categoryService.create();
    }

    @Test
    void testFailed() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            categoryService.test();
        });
    }

    @Test
    void testProgrammatic() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            categoryService.createCategory();
        });
    }
}
