package com.info.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.info.spring.dto.ProductDto;
import com.info.spring.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE p.category.categoryId= :category_id")
	List<Product> findProductsByCategoryId(@Param("category_id") long category_id);
	
}
