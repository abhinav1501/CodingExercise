package com.mckinsey.retailsystem.customermanagement.domain;

public final class Customer implements Cloneable {
	
	private final CustomerTypes  customerType;
	private final String	name;
	
	public Customer(CustomerTypes customerType) {
		this.customerType = customerType;
		this.name = null;
	}
	
	public Customer(CustomerTypes customerType, String name) {
		this.customerType = customerType;
		this.name = name;
	}
	public CustomerTypes getCustomerType() {
		return customerType;
	}
	public String getName() {
		return name;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}