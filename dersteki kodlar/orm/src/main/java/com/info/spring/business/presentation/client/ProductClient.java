package com.info.spring.business.presentation.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.info.spring.business.dto.ProductDto;

@Controller
public class ProductClient {
	
	@GetMapping("/product/get")
	@ResponseBody
	public String getProduct() {
		long productId = 301;
		String url = "http://localhost:8080/api/product/" + productId;
		//Product product = new Product(productId, "Cep Telefonu", 1450);
		RestTemplate restTemplate = new RestTemplate();
		ProductDto product = restTemplate.getForObject(url, ProductDto.class);
		System.out.println("Ürün: " + product.getProductName());
		return "İşlem başarılı " + product.getProductName() + "  " + product.getSalesPrice();
	}
	
	@GetMapping("/product/post")
	@ResponseBody
	public String postProduct() {
		ProductDto productDto = new ProductDto(0, "Fritöz", 673);
		String url = "http://localhost:8080/api/product/";
		RestTemplate restTemplate = new RestTemplate();
		ProductDto result = restTemplate.postForObject(url, productDto, ProductDto.class);
		return "İşlem başarılı " + result.getProductId();
	}
	
	@GetMapping("/product/put")
	@ResponseBody
	public String putProduct() {
		ProductDto productDto = new ProductDto(302, "Tablet", 6300);
		String url = "http://localhost:8080/api/product/";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<ProductDto>(productDto), Void.class);
		return "güncelleme başarılı ";
	}
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		long productId = 302;
		String url = "http://localhost:8080/api/product/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "silme başarılı ";
	}
}
