package com.emaratech.assignment.util;

public enum ErrorMessages {
	NUMBER_WITH_THIS_ID_NOT_FOUND("Number with this Id not found ");
	
	

	private String errorMessage;

	ErrorMessages(String errorMessage)
	{
		this.errorMessage = errorMessage;    
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
