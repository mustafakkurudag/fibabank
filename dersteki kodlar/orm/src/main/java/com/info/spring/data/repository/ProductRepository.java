package com.info.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.info.spring.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	@Query("SELECT p FROM Product as p WHERE p.salesPrice >= :minPrice")
	List<Product> findAllBySalesPriceMin(@Param("minPrice") double minPrice);
}
