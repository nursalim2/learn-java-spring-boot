package com.nursalim.spring.boot.data.jpa;

import com.nursalim.spring.boot.data.jpa.entity.Category;
import com.nursalim.spring.boot.data.jpa.entity.Product;
import com.nursalim.spring.boot.data.jpa.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    public CategoryRepository categoryRepository;

    @Test
    void testCreate() {
        Category category = new Category();
        category.setName("Hand Phone");
        categoryRepository.save(category);

        Assertions.assertNotNull(category.getId());
    }

    @Test
    void testUpdate() {
        Category category = categoryRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(category);

        category.setName("Handphone Jadul");
        categoryRepository.save(category);

        category = categoryRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(category);
        Assertions.assertEquals("Handphone Jadul", category.getName());

    }

    @Test
    void testQuery() {
        Category category = categoryRepository.findFirstByNameEquals("Handphone Jadul").orElse(null);
        Assertions.assertNotNull(category);
        Assertions.assertEquals("Handphone Jadul", category.getName());

        List<Category> categories = categoryRepository.findAllByNameLike("Handphone Jadul");
        Assertions.assertEquals(1, categories.size());
        Assertions.assertEquals("Handphone Jadul", categories.get(0).getName());

    }

    @Test
    void testAudit() {
        Category category = new Category();
        category.setName("apa aja");
        categoryRepository.save(category);
    }

    @Test
    void testExample() {
        Category category = new Category();
        category.setName("GADGET MURAH");

        Example<Category> example = Example.of(category);
        List<Category> categories = categoryRepository.findAll(example);

        Assertions.assertEquals(1, categories.size());
    }

    @Test
    void testExampleMatcher() {
        Category category = new Category();
        category.setName("gadget murah");

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase();

        Example<Category> example = Example.of(category, matcher);
        List<Category> categories = categoryRepository.findAll(example);

        Assertions.assertEquals(1, categories.size());
    }
}
