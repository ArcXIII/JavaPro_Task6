package org.arcsoft.repository;

import org.arcsoft.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            SELECT * FROM products where user_id = :userId
            """, nativeQuery = true)
    List<Product> findByUserId(@Param("userId") Long id);
}
