package com.info.spring.business.service;

import java.util.List;

import com.info.spring.business.dto.ProductDto;

public interface ProductService {
	long create(ProductDto productDto);

	void update(ProductDto productDto);
	
	ProductDto find(long productId);
	
	List<ProductDto> findAll();
	
	void delete(long productId);
}
