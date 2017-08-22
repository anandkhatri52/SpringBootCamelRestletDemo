package com.akhatri.services;

import com.akhatri.constant.AppConstants;
import com.akhatri.route.pojo.APIResponsePojo;
import com.akhatri.route.pojo.ErrorResponsePojo;

public abstract class AbstractResponseService {
	
	protected APIResponsePojo getResponse(String message) {
		APIResponsePojo pojo = getResponsePojo();
		pojo.setMessage(message);
		return pojo;
	}
	
	protected APIResponsePojo getResponse(Object data) {
		APIResponsePojo pojo = getResponsePojo();
		pojo.setData(data);
		return pojo;
	}
	
	protected APIResponsePojo getErrorResponse(String errorMessage) {
		APIResponsePojo pojo = getErrorResponsePojo();
		ErrorResponsePojo errorPojo = new ErrorResponsePojo(pojo.getStatus(), errorMessage);
		pojo.setErrorPojo(errorPojo);
		return pojo;
	}
	
	private APIResponsePojo getResponsePojo() {
		APIResponsePojo pojo = new APIResponsePojo();
		pojo.setStatus(AppConstants.SUCCESS_CODE);
		return pojo;
	}
	
	private APIResponsePojo getErrorResponsePojo() {
		APIResponsePojo pojo = new APIResponsePojo();
		pojo.setStatus(AppConstants.ERROR_CODE);
		return pojo;
	}

}
