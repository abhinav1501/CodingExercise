package com.mckinsey.retailsystem.inventorymanagement.domain;

public enum ProductTypes {
	
	GROCERY("grocery"), 
	NON_GROCERY("nongrocery"), 
	ELECTRONICS("electronics"),
	OTHERS("others"),
	ANY("any");
	
	private final String type;
	
	ProductTypes (String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return this.type;
	}

}
