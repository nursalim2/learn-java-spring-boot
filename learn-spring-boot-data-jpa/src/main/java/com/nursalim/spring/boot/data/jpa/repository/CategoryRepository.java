package com.nursalim.spring.boot.data.jpa.repository;

import com.nursalim.spring.boot.data.jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findFirstByNameEquals(String name);

    List<Category> findAllByNameLike(String name);
}
