package com.mckinsey.retailsystem.customermanagement.domain;

public enum CustomerTypes {
	
	EMPLOYEE("employee"), 
	AFFILIATE("affiliate"),
	LOYAL_CUSTOMER("loyal"),
	ANYONE("anyone");
	
	private final String type;
	CustomerTypes (String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return this.type;
	}

}
