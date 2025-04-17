package com.nursalim.spring.boot.data.jpa.repository;

import com.nursalim.spring.boot.data.jpa.entity.Category;
import com.nursalim.spring.boot.data.jpa.entity.Product;
import com.nursalim.spring.boot.data.jpa.model.ProductPrice;
import com.nursalim.spring.boot.data.jpa.model.SimpleProduct;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByCategory_Name(String name);

    List<Product> findAllByCategory_Name(String name, Sort sort);

//    List<Product> findAllByCategory_Name(String name, Pageable pageable);

    Page<Product> findAllByCategory_Name(String name, Pageable pageable);

    Long countByCategory_Name(String name);

    Boolean existsByName(String name);

    @Transactional
    int deleteByName(String name);

    List<Product> searchProductUsingName(@Param("name") String name);

    List<Product> searchProductUsingName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE :name OR p.category.name LIKE :name")
    List<Product> searchProduct(@Param("name") String name);

    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE :name OR p.category.name LIKE :name")
    List<Product> searchProduct(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE :name OR p.category.name LIKE :name",
            countQuery = "SELECT count(p) FROM Product p WHERE p.name LIKE :name OR p.category.name LIKE :name")
    Page<Product> searchProductCount(@Param("name") String name, Pageable pageable);

    @Modifying
    @Query(value = "delete from Product p where p.name = :name")
    int deleteProductUsingName(@Param("name") String name);

    @Modifying
    @Query(value = "update Product p set p.price = 0 where p.id = :id")
    int updateProductPriceToZero(@Param("id") Long id);

    Stream<Product> streamAllByCategory(Category category);

    Slice<Product> findAllByCategory(Category category, Pageable pageable);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Product> findFirstByIdEquals(Long id);

//    List<SimpleProduct> findAllByNameLike(String name);

    <T> List<T> findAllByNameLike(String name, Class<T> tClass);
}
