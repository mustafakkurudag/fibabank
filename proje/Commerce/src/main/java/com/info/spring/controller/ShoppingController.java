package com.info.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.info.spring.client.shopping.CartClient;
import com.info.spring.dto.CartDto;
import com.info.spring.dto.CartProductDto;

@Controller
@RequestMapping("/commerce/shopping")
public class ShoppingController {
	
	private CartClient cartClient;
	
	public ShoppingController(CartClient cartClient) {
		this.cartClient = cartClient;
	}
	
	@GetMapping("/cart/create")
	public String createCart(@ModelAttribute CartDto cartDto, Model model) {
		long cartId = cartClient.createCart();
		model.addAttribute("cartId", cartId);
		
		return "cart";
	}
	
	@PostMapping("/cart/add")
	public String addProductToCart(@ModelAttribute CartProductDto cartProductDto, Model model) {
		cartProductDto = cartClient.addProductToCart();
		model.addAttribute("cartProduct", cartProductDto);
		
		return "cart";
	}
	
	@PutMapping("/checkout/{cartId}")
	public String checkout(@PathVariable("cartId") long cartId, Model model) {
		cartClient.checkout(cartId);
		
		return "cart";
	}
	
	@DeleteMapping("/cart/remove/{cartId}/{productId}")
	public String removeProductInCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		cartClient.deleteProductInCart(cartId, productId);
		
		return "cart";
	}
}
