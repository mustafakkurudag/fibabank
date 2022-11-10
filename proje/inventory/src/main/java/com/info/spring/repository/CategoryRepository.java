package com.info.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.info.spring.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	@Query("SELECT c.categoryName FROM Category c")
	List<String> getCategories();
}
