package com.mckinsey.retailsystem.discountmanagement.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class SumTotalDiscountStrategyTest {
	
	@Test
	public void testGetFinalDiscount() {
		SumTotalDiscountStrategy fixture = new SumTotalDiscountStrategy();
		List<Double>  discountsList = new ArrayList<Double>();
		discountsList.add(10d);
		discountsList.add(20d);
		discountsList.add(5d);
		discountsList.add(99d);
		double actual = fixture.getFinalDiscount(discountsList);
		assertEquals(134d, actual,0);
 	}


}
