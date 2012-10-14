package com.mckinsey.retailsystem.common.exception;


public class DataAccessException extends Exception {
	
	private static final long serialVersionUID = 4889105069088120431L;

	public DataAccessException() {
		super();
	}

	public DataAccessException(String errorDesc) {
		super(errorDesc);
	}
	
	public DataAccessException(Throwable th) {
		super(th);
	}
	
	public DataAccessException(String errorDesc, Throwable th) {
		super(errorDesc, th);
	}
}
