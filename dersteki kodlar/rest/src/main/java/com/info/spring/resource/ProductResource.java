package com.info.spring.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.info.spring.Product;
import com.info.spring.service.ProductService;

@RestController
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	/*@GetMapping("/api/product")
	public Product getProduct() {
		Product product = new Product(301, "Cep Telefonu", 1450);
		
		return product;
	}*/

	@GetMapping("/api/product/{id}")
	public Product getProduct(@PathVariable("id") long productId) {
		Product product = productService.find(productId);
		
		return product;
	}
	
	@GetMapping("/api/products")
	public List<Product> getProducts() {
		/*List<Product> productList = new ArrayList<>();
		
		productList.add(new Product(301, "Cep Telefonu", 1450));
		productList.add(new Product(302, "Dizüstü bilgisayar", 6575));
		productList.add(new Product(303, "Masaüstü bilgisayar", 3490));
		*/
		
		List<Product> productList = productService.findAll();
		
		return productList;
	}
	
	
	@PostMapping("/api/product")
	public Product postProduct(@RequestBody Product product) {
		productService.createProduct(product);
	
		return product;
	}
	
	@PutMapping("/api/product")
	public void putProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
	
	@DeleteMapping("/api/product/{id}")
	public void deleteProduct(@PathVariable("id") long productId) {
		productService.deleteProduct(productId);
	}
}
