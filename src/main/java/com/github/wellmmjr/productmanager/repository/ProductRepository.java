package com.github.wellmmjr.productmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.wellmmjr.productmanager.data.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Modifying
	@Query("UPDATE Product p SET p.enabled = false WHERE p.id = :id")
	void disableProducts(@Param("id") Long id);
	
	@Query("SELECT p FROM Product p WHERE p.product_name LIKE LOWER ( CONCAT ( :productName,'%' ) )")
	Page<Product> findProductByName(@Param("productName") String firstName, Pageable pageable);
	
	
}
