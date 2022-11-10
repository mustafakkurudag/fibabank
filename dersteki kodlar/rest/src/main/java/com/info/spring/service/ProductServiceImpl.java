package com.info.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.info.spring.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product find(long productId) {
		Product product = new Product(productId, "Telefon", 4545);
		
		System.out.println("servis çalıştı");
		
		return product;
	}

	@Override
	public List<Product> findAll() {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(301, "Cep telefonu", 1450));
		productList.add(new Product(302, "Dizüstü bilgisayar", 2450));
		productList.add(new Product(303, "Televizyon", 2150));
		
		return productList;
	}

	@Override
	public void createProduct(Product product) {
		product.setProductId(301);
		
		System.out.println("Ürün eklendi: " + product.getProductId() + " " + product.getProductName() + 
				" " + product.getSalesPrice());
	}

	@Override
	public void updateProduct(Product product) {
		System.out.println("Ürün güncellendi" + product.getProductId() + " " + product.getProductName() + 
				" " + product.getSalesPrice());
	}

	@Override
	public void deleteProduct(long productId) {
		System.out.println("Ürün silindi " + productId);
	}

}
