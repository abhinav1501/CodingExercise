package com.mckinsey.retailsystem.discountmanagement.util;

import java.util.List;

public class SumTotalDiscountStrategy implements DiscountStrategy {

	@Override
	public Double getFinalDiscount(List<Double> applicableDiscounts) {
		if (applicableDiscounts == null || applicableDiscounts.isEmpty()) {
			return null;
		}
		Double finalDiscount = 0d;
		for (Double appDiscount : applicableDiscounts) {
			finalDiscount = finalDiscount + appDiscount;
		}
		
		return finalDiscount;
	}
	
}