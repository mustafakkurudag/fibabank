package com.info.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.spring.entity.Category;
import com.info.spring.entity.Product;
import com.info.spring.repository.CategoryRepository;
import com.info.spring.repository.ProductRepository;

@RestController
@RequestMapping("/inventory")
public class CategoryController {
	
	private CategoryRepository categoryRepository;
	
	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@GetMapping("/category/all")
	public List<Category> getCategories() {
		Iterable<Category> categoriesIterable = categoryRepository.findAll();
		List<Category> categoryList = new ArrayList<>();
		categoriesIterable.forEach(categoryList::add);
		
		return categoryList;
	}
	
}
