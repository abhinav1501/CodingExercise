package com.mckinsey.retailsystem.discountmanagement.util;

import java.util.List;

public interface DiscountStrategy {
	
	public Double getFinalDiscount(List<Double>  applicableDiscounts);

}
