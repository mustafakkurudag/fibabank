package com.info.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	private String customerName;
	private double totalAmount;
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartProduct> cartProducts;
	private int cartStatus;
	
	public Cart() {}

	public Cart(long cartId, String customerName, double totalAmount, int cartStatus) {
		this.cartId = cartId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.cartStatus = cartStatus;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public int getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(int cartStatus) {
		this.cartStatus = cartStatus;
	}	
}
