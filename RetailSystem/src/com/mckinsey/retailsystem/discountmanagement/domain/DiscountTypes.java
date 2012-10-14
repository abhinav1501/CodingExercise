package com.mckinsey.retailsystem.discountmanagement.domain;

public enum DiscountTypes {
	
	ITEMIZED_ABSOLUTE("itemized_absolute"),
	ITEMIZED_PERCENTAGE("itemized_percentage"),
	TOTAL_ABSOULTE("total_absolute"),
	TOTAL_PERCENTAGE("total_percentage");
	
	private final String type;
	
	DiscountTypes (String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return this.type;
	}

}
