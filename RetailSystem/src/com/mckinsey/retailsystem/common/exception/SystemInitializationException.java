package com.mckinsey.retailsystem.common.exception;

public class SystemInitializationException extends Exception {
	
	private static final long serialVersionUID = 5403369840874585544L;

	public SystemInitializationException() {
		super();
	}

	public SystemInitializationException(String errorDesc) {
		super(errorDesc);
	}
	
	public SystemInitializationException(Throwable th) {
		super(th);
	}
	
	public SystemInitializationException(String errorDesc, Throwable th) {
		super(errorDesc, th);
	}
}