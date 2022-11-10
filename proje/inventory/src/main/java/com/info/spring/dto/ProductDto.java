package com.info.spring.dto;

public class ProductDto {
	
	private long productId;
	private String productName;
	private double salesPrice;
	private String category;
	
	public ProductDto() {}

	public ProductDto(long productId, String productName, double salesPrice, String category) {
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.category = category;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
