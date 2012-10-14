package com.mckinsey.retailsystem.discountmanagement.domain;

import com.mckinsey.retailsystem.customermanagement.domain.CustomerTypes;
import com.mckinsey.retailsystem.inventorymanagement.domain.ProductTypes;

public final class Discount {
	
	private final CustomerTypes  discountCustomerType;
	private final ProductTypes	 discountProductType;
	private final DiscountTypes  discountType;
	private final Integer discountValue;
	private final Integer absoluteDiscountChunkSize;
	
	public Discount(
		CustomerTypes discountCustomerType,
		ProductTypes discountProductType, 
		DiscountTypes discountType,
		Integer discountValue, 
		Integer absoluteDiscountChunkSize
	) {
		this.discountCustomerType = discountCustomerType;
		this.discountProductType = discountProductType;
		this.discountType = discountType;
		this.discountValue = discountValue;
		this.absoluteDiscountChunkSize = absoluteDiscountChunkSize;
	}
	public CustomerTypes getDiscountCustomerType() {
		return discountCustomerType;
	}
	public ProductTypes getDiscountProductType() {
		return discountProductType;
	}
	public DiscountTypes getDiscountType() {
		return discountType;
	}
	public Integer getDiscountValue() {
		return discountValue;
	}
	public Integer getAbsoluteDiscountChunkSize() {
		return absoluteDiscountChunkSize;
	}
	
}