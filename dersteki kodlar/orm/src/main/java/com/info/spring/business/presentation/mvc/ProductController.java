package com.info.spring.business.presentation.mvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.spring.data.entity.Product;
import com.info.spring.data.repository.ProductRepository;

@Controller
@RequestMapping("/inventory")
public class ProductController {
	
	//@Autowired - eski yöntem. yeni yöntem: alttaki productRepository'i constructor'a eklemek
	private ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/product/insert")
	@ResponseBody
	public String insertProduct() {
		Product product = new Product(0, "Cep Telefonu", 1430);
		productRepository.save(product);
		return "Sokuldu: " + product.getProductId();
	}
	
	@GetMapping("/product/find")
	@ResponseBody
	public String findProduct() {
		long productId = 6;
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product product = optional.get();
			System.out.println(product.getProductId() + " - " + product.getProductName() + " - " + product.getSalesPrice());
			
			return "Ürün bulundu: " + product.getProductName();
		}
		
		return "Bulunamadı..!";
	}
	
	@GetMapping("/product/list")
	@ResponseBody
	public String listProducts() {
		Iterable<Product> products = productRepository.findAll();
		int count = 0;
		
		for(Product product: products) {
			System.out.println(product.getProductId() + " - " + product.getProductName() + " - " + product.getSalesPrice());
			count++;
		}
		
		return "Ürün sayısı = " + count; //productRepository.count();
	}
	
	@GetMapping("/product/expensive")
	@ResponseBody
	public String listExpensiveProducts() {
		double salesPrice = 3000;
		Iterable<Product> products = productRepository.findAllBySalesPriceMin(salesPrice);
		int count = 0;
		
		for(Product product: products) {
			System.out.println(product.getProductId() + " - " + product.getProductName() + " - " + product.getSalesPrice());
			count++;
		}
		
		return "Ürün sayısı = " + count; //productRepository.count();
	}
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		long productId = 11;
		
		if(!productRepository.existsById(productId)) {
			return "Bulunamadı: " + productId;
		}
		
		productRepository.deleteById(productId);
		
		return "Silindi: " + productId;
	}
}
