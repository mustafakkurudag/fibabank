package com.info.spring.client.inventory;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.info.spring.dto.CartProductDto;

@Controller
public class ProductClient {
	
	@ResponseBody
	public List<CartProductDto> getProducts() {
		String url = "http://localhost:8081/inventory/product/all";
		RestTemplate restTemplate = new RestTemplate();
		List<CartProductDto> cartProductDtos = restTemplate.getForObject(url, List.class);
		
		return cartProductDtos;
	}
	
	@ResponseBody
	public List<CartProductDto> getProductsByCategoryId(long categoryId) {
		String url = "http://localhost:8081/inventory/products/" + categoryId;
		RestTemplate restTemplate = new RestTemplate();
		List<CartProductDto> categoryProducts = restTemplate.getForObject(url, List.class);

		return categoryProducts;
	}
	
	public CartProductDto getProductById(long productId) {
		String url = "http://localhost:8081/inventory/product/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		CartProductDto cartProductDto = restTemplate.getForObject(url, CartProductDto.class);
				
		return cartProductDto;
	}
}
