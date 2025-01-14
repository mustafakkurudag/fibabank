package com.info.spring.controller;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.info.spring.dto.CartProductDto;
import com.info.spring.entity.Cart;
import com.info.spring.entity.CartProduct;
import com.info.spring.repository.CartProductRepository;
import com.info.spring.repository.CartRepository;

@RestController
@RequestMapping(value = "/shopping", method = RequestMethod.GET)
public class CartController {
	
	private CartRepository cartRepository;
	private CartProductRepository cartProductRepository;
	
	public CartController(CartRepository cartRepository, CartProductRepository cartProductRepository) {
		this.cartRepository = cartRepository;
		this.cartProductRepository = cartProductRepository;
	}
	
	@GetMapping("/cart/create")
	public long createCart() {
		Cart cart = new Cart(
				0, "Ali Can", 0, 0);
		cartRepository.save(cart);
		
		return cart.getCartId();
	}
	
	@Transactional
	@PostMapping("/cart/add")
	public CartProductDto addProductToCart() {

		boolean isProductExists = false;

		CartProductDto cartProductDto = new CartProductDto(
				0, 2, 1, 2, 0);
		cartProductDto.setCartId(5);
		cartProductDto.setSalesPrice(cartProductRepository.findSalesPriceByProductId(cartProductDto.getProductId()));
		cartProductDto.setLineAmount(cartProductDto.getSalesPrice() * cartProductDto.getSalesQuantity());		
		
		CartProduct cartProduct = new CartProduct(
				cartProductDto.getCartProductId(), cartProductDto.getProductId(),
				cartProductDto.getSalesQuantity(), cartProductDto.getSalesPrice(),
				cartProductDto.getLineAmount());
		
		Optional<Cart> optional = cartRepository.findById(cartProductDto.getCartId());
		
		if(optional.isPresent()) {
			for(CartProduct cp : optional.get().getCartProducts()) {
				if(cp.getProductId() == cartProductDto.getProductId()) {
					isProductExists = true;
					cartProductRepository.updateSalesQuantityByCartProductId(cp.getCartProductId());
					break;
				}
			}
			
			optional.get().setTotalAmount(optional.get().getTotalAmount() + cartProductDto.getLineAmount());
			cartProduct.setCart(optional.get());
			
			if(!isProductExists)
				cartProductRepository.save(cartProduct);
		} 
		
		return cartProductDto;
	}
	
	@PutMapping("/checkout/{cartId}")
	public void checkout(@PathVariable("cartId") long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
	
		if(optional.isPresent()) {
			optional.get().setCartStatus(1);
		}
		
		cartRepository.save(optional.get());
	}
	
	@DeleteMapping("/cart/remove/{cartId}/{productId}")
	public void removeProductInCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		
		Optional<Cart> optional = cartRepository.findById(cartId);
		boolean isProductExists = false;
		
		if(optional.isPresent()) {			
			for(CartProduct cp : optional.get().getCartProducts()) {
				if(cp.getProductId() == productId) {
					double productSalesPrice = cartProductRepository.findSalesPriceByProductId(productId);
					System.out.println("Silinecek ürünün fiyatı: " + productSalesPrice);
					optional.get().setTotalAmount(optional.get().getTotalAmount() - productSalesPrice);
					if(optional.get().getTotalAmount() <= 0) {
						cartRepository.deleteById(cartId);
					}
					cp.setSalesQuantity(cp.getSalesQuantity() - 1);
					System.out.println(productId + " ID'li üründen Sepette kalan ürün adedi: " + cp.getSalesQuantity());
					if(cp.getSalesQuantity() <= 0) {
						cartProductRepository.deleteById(cp.getCartProductId());
					} 
					isProductExists = true;
					cartProductRepository.save(cp);
					break;
				}
			}
			
			if(!isProductExists) {
				System.out.println(productId + " ID'li ürün sepette bulunamadı!");
			} else {
				cartRepository.save(optional.get());
			}
		} else {
			System.out.println(cartId + " ID'li sepet bulunamadı!");
		}
	}
}
