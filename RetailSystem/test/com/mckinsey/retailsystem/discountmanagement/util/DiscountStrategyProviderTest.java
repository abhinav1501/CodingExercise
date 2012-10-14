package com.mckinsey.retailsystem.discountmanagement.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiscountStrategyProviderTest {

	@Test
	public void testGetHighestDiscountStrategy1() {
		DiscountStrategy strategy = DiscountStrategyProvider.getDiscountStrategy(null);
		assertTrue(strategy instanceof HighestDiscountStrategy);
	}
	
	@Test
	public void testGetHighestDiscountStrategy2() {
		DiscountStrategy strategy = DiscountStrategyProvider.getDiscountStrategy(StrategyTypes.HIGHEST);
		assertTrue(strategy instanceof HighestDiscountStrategy);
	}
	
	@Test
	public void testGetSumTotalDiscountStrategy() {
		DiscountStrategy strategy = DiscountStrategyProvider.getDiscountStrategy(StrategyTypes.TOTAL_SUM);
		assertTrue(strategy instanceof SumTotalDiscountStrategy);
	}
	

}
