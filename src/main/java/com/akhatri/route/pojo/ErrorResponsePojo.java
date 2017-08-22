package com.akhatri.route.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ErrorResponsePojo {

	private short errorCode;
	private String errorMessage;
	
	public ErrorResponsePojo(short code, String message) {
		errorCode = code;
		errorMessage = message;
	}
	
	public short getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}