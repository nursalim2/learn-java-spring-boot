package com.nursalim.spring.boot.data.jpa;


import com.nursalim.spring.boot.data.jpa.entity.Category;
import com.nursalim.spring.boot.data.jpa.entity.Product;
import com.nursalim.spring.boot.data.jpa.model.ProductPrice;
import com.nursalim.spring.boot.data.jpa.model.SimpleProduct;
import com.nursalim.spring.boot.data.jpa.repository.CategoryRepository;
import static org.junit.jupiter.api.Assertions.*;

import com.nursalim.spring.boot.data.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.support.TransactionOperations;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    @Test
    void createProduct() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        {
            Product product = new Product();
            product.setName("Nokia 115");
            product.setCategory(category);
            product.setPrice(1_500_000L);
            productRepository.save(product);
        }

        {
            Product product = new Product();
            product.setName("Samsung SGH 124");
            product.setCategory(category);
            product.setPrice(3_000_000L);
            productRepository.save(product);
        }
    }

    @Test
    void findProducts() {
        List<Product> products = productRepository.findAllByCategory_Name("Handphone Jadul");

        assertEquals(2, products.size());
        assertEquals("Nokia 115", products.get(0).getName());
        assertEquals("Samsung SGH 124", products.get(1).getName());
    }

    @Test
    void findProductsSort() {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        List<Product> products = productRepository.findAllByCategory_Name("Handphone Jadul", sort);

        assertEquals(2, products.size());
        assertEquals("Samsung SGH 124", products.get(0).getName());
        assertEquals("Nokia 115", products.get(1).getName());

    }

    @Test
    void findProductsWithPageable() {
        // Page 0
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")));

//        List<Product> products = productRepository.findAllByCategory_Name("Handphone Jadul", pageable);
//        assertEquals(1, products.size());
//        assertEquals("Samsung SGH 124", products.get(0).getName());

        Page<Product> products = productRepository.findAllByCategory_Name("Handphone Jadul", pageable);
        assertEquals(1, products.getContent().size());
        assertEquals(0, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());

        pageable = PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")));
//        products = productRepository.findAllByCategory_Name("Handphone Jadul", pageable);
        products = productRepository.findAllByCategory_Name("Handphone Jadul", pageable);
//
//        assertEquals(1, products.size());
//        assertEquals("Nokia 115", products.get(0).getName());

        assertEquals(1, products.getContent().size());
        assertEquals(1, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());
    }

    @Test
    void testCount() {
        Long count = productRepository.count();
        assertEquals(2, count);

        count = productRepository.countByCategory_Name("Handphone Jadul");
        assertEquals(2, count);

    }

    @Test
    void testExists() {
        boolean isExists = productRepository.existsByName("Nokia 115");
        assertTrue(isExists);

        isExists = productRepository.existsByName("Nokia Mbuh");
        assertFalse(isExists);
    }

    @Test
    void testDelete() {
//        transactionOperations.executeWithoutResult(transactionStatus -> {
//            Category category = categoryRepository.findById(1L).orElse(null);
//            assertNotNull(category);
//
//            Product product = new Product();
//            product.setName("Samsung Galaxy 11");
//            product.setPrice(12_000_000L);
//            product.setCategory(category);
//            productRepository.save(product);
//
//            int delete = productRepository.deleteByName("Samsung Galaxy 11");
//            assertEquals(1, delete);
//
//            delete = productRepository.deleteByName("Samsung Galaxy 11");
//            assertEquals(0, delete);
//
//        });


            Category category = categoryRepository.findById(1L).orElse(null);
            assertNotNull(category);

            Product product = new Product();
            product.setName("Samsung Galaxy 11");
            product.setPrice(12_000_000L);
            product.setCategory(category);
            productRepository.save(product);  // transaksi 1

            int delete = productRepository.deleteByName("Samsung Galaxy 11"); // transaksi 2
            assertEquals(1, delete);

            delete = productRepository.deleteByName("Samsung Galaxy 11"); // transaksi 3
            assertEquals(0, delete);

    }

    @Test
    void searchProduct() {
        List<Product> products = productRepository.searchProductUsingName("Nokia 115");
        assertEquals(1, products.size());
        assertEquals("Nokia 115", products.getFirst().getName());

    }

    @Test
    void searchProductPaging() {
        Pageable pageable = PageRequest.of(0, 1);

        List<Product> products = productRepository.searchProductUsingName("Nokia 115", pageable);
        assertEquals(1, products.size());
        assertEquals("Nokia 115", products.getFirst().getName());

    }

    @Test
    void searchProductQuery() {
        List<Product> products = productRepository.searchProduct("%Nokia 115%");
        assertEquals(1, products.size());
        assertEquals("Nokia 115", products.getFirst().getName());

        products = productRepository.searchProduct("%GADGET%");
        assertEquals(2, products.size());
        assertEquals("Nokia 115", products.getFirst().getName());

    }

    @Test
    void searchProductQueryPaging() {
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")));

        List<Product> products = productRepository.searchProduct("%Nokia 115%", pageable);
        assertEquals(1, products.size());
        assertEquals("Nokia 115", products.getFirst().getName());

        products = productRepository.searchProduct("%GADGET%", pageable);
        assertEquals(1, products.size());
        assertEquals("Samsung SGH 124", products.getFirst().getName());

    }

    @Test
    void searchProductQueryCount() {
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")));

        Page<Product> products = productRepository.searchProductCount("%Nokia 115%", pageable);
        assertEquals(1, products.getContent().size());
        assertEquals(1, products.getTotalPages());
        assertEquals(0, products.getNumber());

        assertEquals("Nokia 115", products.getContent().getFirst().getName());

    }

    @Test
    void testModifying() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            int total = productRepository.deleteProductUsingName("Wrong name");
            assertEquals(0, total);

            total = productRepository.updateProductPriceToZero(4L);
            assertEquals(1, total);

            Product product = productRepository.findById(4L).orElse(null);
            assertNotNull(product);
            assertEquals(0, product.getPrice());

        });
    }

    @Test
    void testStream() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            Category category = categoryRepository.findById(1L).orElse(null);
            assertNotNull(category);

            Stream<Product> productStream = productRepository.streamAllByCategory(category);
            productStream.forEach(product -> System.out.println(product.getId() + " " + product.getName()));
        });
    }

    @Test
    void testSlice() {
        Pageable firstPage = PageRequest.of(0, 1);

        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        Slice<Product> slice = productRepository.findAllByCategory(category, firstPage);
        // do with content

        while (slice.hasNext()) {
            slice = productRepository.findAllByCategory(category, slice.nextPageable());

            // do with content
        }
    }

    @Test
    void testLock1() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            try {
                var product = productRepository.findFirstByIdEquals(4L).orElse(null);
                assertNotNull(product);

                product.setPrice(4000_000L);
                Thread.sleep(20_000L);

                productRepository.save(product);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
    }

    @Test
    void testLock2() {
        var product = productRepository.findFirstByIdEquals(4L).orElse(null);
        assertNotNull(product);

        product.setPrice(10_000_000L);
        productRepository.save(product);
    }

    @Test
    void testSpecification() {
        Specification<Product> specification = (root, criteria, builder) -> {
            return criteria.where(
                    builder.or(
                            builder.equal(root.get("name"), "Nokia 115"),
                            builder.equal(root.get("name"), "Samsung SGH 124")
                    )
            ).getRestriction();
        };

        List<Product> products = productRepository.findAll(specification);
        assertEquals(2, products.size());
    };

    @Test
    void testProjection() {
        List<SimpleProduct> simpleProducts = productRepository.findAllByNameLike("%Nokia%", SimpleProduct.class);
        assertEquals(1, simpleProducts.size());

        List<ProductPrice> productPrices = productRepository.findAllByNameLike("%Nokia%", ProductPrice.class);
        assertEquals(1, productPrices.size());
    }

}
