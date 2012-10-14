package com.mckinsey.retailsystem.discountmanagement.util;

public enum StrategyTypes {

	HIGHEST("highest"), 
	TOTAL_SUM("total");
	
	private final String type;
	StrategyTypes (String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return this.type;
	}
}
