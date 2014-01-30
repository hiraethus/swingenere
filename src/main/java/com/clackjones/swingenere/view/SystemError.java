package com.clackjones.swingenere.view;

public class SystemError {
	private String errorMessage;

	public static SystemError forException(Exception e) {
		SystemError sysError = new SystemError();
		sysError.setErrorMessage(e.getClass().getName());

		return sysError;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
