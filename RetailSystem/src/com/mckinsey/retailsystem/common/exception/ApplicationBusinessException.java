package com.mckinsey.retailsystem.common.exception;

public class ApplicationBusinessException extends Exception {
	
	private static final long serialVersionUID = 5288706470094340886L;

	public ApplicationBusinessException() {
		super();
	}

	public ApplicationBusinessException(String errorDesc) {
		super(errorDesc);
	}
	
	public ApplicationBusinessException(Throwable th) {
		super(th);
	}
	
	public ApplicationBusinessException(String errorDesc, Throwable th) {
		super(errorDesc, th);
	}
	
}