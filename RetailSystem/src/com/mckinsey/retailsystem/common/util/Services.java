package com.mckinsey.retailsystem.common.util;

public enum Services {
	
	BILL_MGMT("billMgmtService"), 
	CUSTOMER_MGMT("customerMgmtService"),
	DISCOUNT_MGMT("discountMgmtService"),
	INVENTORY_MGMT("inventoryMgmtService");
	
	private final String name;
	
	Services (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}

}
