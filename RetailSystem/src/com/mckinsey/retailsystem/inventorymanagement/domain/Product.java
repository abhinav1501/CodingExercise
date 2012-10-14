package com.mckinsey.retailsystem.inventorymanagement.domain;

public class Product implements Cloneable {
	
	private final  long productId;
	private final  ProductTypes  productType;
	private final  long productCategoryId;
	private double price;
	
	public Product(
		long productId,
		ProductTypes productType,
		long productCategoryId,
		Double price
	) {
		this.productId = productId;
		this.productType = productType;
		this.productCategoryId = productCategoryId;
		this.price = price;
	}

	public long getProductId() {
		return productId;
	}

	public ProductTypes getProductType() {
		return productType;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public long getProductCategoryId() {
		return productCategoryId;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
