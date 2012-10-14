package com.mckinsey.retailsystem.discountmanagement.util;

public final class DiscountStrategyProvider {
	
	private static StrategyTypes discountDefaultStrategy = StrategyTypes.HIGHEST;  // should be picked from configuration file
	
	public static DiscountStrategy getDiscountStrategy(StrategyTypes strategyType) {
		StrategyTypes  strategy = null;
		if (strategyType == null) {
			strategy = discountDefaultStrategy;
		} else {
			strategy = strategyType;
		}
		if (StrategyTypes.HIGHEST.getType().equals(strategy.getType())) {
			return new HighestDiscountStrategy();
		}
		return new SumTotalDiscountStrategy();
	}
	
}
