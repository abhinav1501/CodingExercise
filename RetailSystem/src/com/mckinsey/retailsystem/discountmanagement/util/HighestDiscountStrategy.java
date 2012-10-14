package com.mckinsey.retailsystem.discountmanagement.util;

import java.util.List;

public class HighestDiscountStrategy implements DiscountStrategy {

	@Override
	public Double getFinalDiscount(List<Double> applicableDiscounts) {
		if (applicableDiscounts == null || applicableDiscounts.isEmpty()) {
			return null;
		}
		Double finalDiscount = 0d;
		for (Double appDiscount : applicableDiscounts) {
			if (finalDiscount < appDiscount) {
				finalDiscount = appDiscount;
			}
		}
		
		return finalDiscount;
	}

}
