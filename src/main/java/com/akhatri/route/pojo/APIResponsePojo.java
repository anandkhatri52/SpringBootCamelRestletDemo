package com.akhatri.route.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class APIResponsePojo {

	private short status;
	private Object data;
	private String message;
	private ErrorResponsePojo errorPojo;
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponsePojo getErrorPojo() {
		return errorPojo;
	}
	public void setErrorPojo(ErrorResponsePojo errorPojo) {
		this.errorPojo = errorPojo;
	}
}