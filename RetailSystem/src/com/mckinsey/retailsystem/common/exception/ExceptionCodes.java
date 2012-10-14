package com.mckinsey.retailsystem.common.exception;

public enum ExceptionCodes {
	
	BILL_INCOMPLETE("APP_EXCEPTION_INCOMPLETE_BILL"),
	BILL_WITHOUT_CUSTOMER("APP_EXCEPTION_CUSTOMERLESS_BILL"), 
	BILL_WITHOUT_ITEMS("APP_EXCEPTION_ITEMLESS_BILL"),
	SERVICE_NOT_FOUND("SERVICE_NOT_FOUND_EXCEPTION"),
	FACTORY_NOT_FOUND("FACTORY_NOT_FOUND_EXCEPTION"),
	UNKNOWN_EXCEPTION("UNKNOWN_EXCEPTION");
	
	private final String type;
	
	ExceptionCodes (String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}

}
