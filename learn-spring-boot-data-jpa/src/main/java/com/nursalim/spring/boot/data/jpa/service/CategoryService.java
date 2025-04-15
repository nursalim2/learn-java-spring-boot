package com.nursalim.spring.boot.data.jpa.service;

import com.nursalim.spring.boot.data.jpa.entity.Category;
import com.nursalim.spring.boot.data.jpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionOperations;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Transactional(propagation = Propagation.MANDATORY)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setName("Category - " + i);
            categoryRepository.save(category);
        }

        throw new RuntimeException("Ups rollbacke please");
    }

    public void test() {
        create();
    }

    public void error() {
        throw new RuntimeException("Ups error, will rollback");
    }

    public void createCategory() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            for (int i = 1; i <= 5; i++) {
                Category category = new Category();
                category.setName("Category - " + i);
                categoryRepository.save(category);
            }
            error();
        });
    }

    public void manual() {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setTimeout(10);
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(definition);

        try {
            for (int i = 0; i < 5; i++) {
                Category category = new Category();
                category.setName("Category Manual - " + i);
                categoryRepository.save(category);
            }

            error();
            platformTransactionManager.commit(transactionStatus);
        } catch (Throwable throwable) {
            platformTransactionManager.rollback(transactionStatus);
            throw throwable;
        }

    }
}
