package com.akhatri.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.akhatri.constant.AppConstants;
import com.akhatri.route.pojo.APIResponsePojo;

@Component
public class RequestPostProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		APIResponsePojo responsePojo = (APIResponsePojo) in.getBody();
		if(AppConstants.ERROR_CODE == responsePojo.getStatus()) {
			in.setHeader(Exchange.HTTP_RESPONSE_CODE, AppConstants.ERROR_CODE);
		}
	}
	
}