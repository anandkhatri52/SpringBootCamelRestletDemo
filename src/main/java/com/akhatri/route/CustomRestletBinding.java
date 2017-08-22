package com.akhatri.route;

import org.apache.camel.Exchange;
import org.apache.camel.component.restlet.DefaultRestletBinding;
import org.apache.camel.util.URISupport;
import org.restlet.Request;
import org.restlet.Response;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;

@Component
public class CustomRestletBinding extends DefaultRestletBinding {

    public CustomRestletBinding() {
    }

    public void populateExchangeFromRestletRequest(Request request, Response response, Exchange exchange) throws Exception {
        super.populateExchangeFromRestletRequest(request, response, exchange);
        if(!request.isEntityAvailable()) {
            String queryString = (String)exchange.getIn().getHeader("CamelHttpQuery", String.class);
            Map params = URISupport.parseQuery(queryString);

            String param;
            String value;
            for(Iterator i$ = params.keySet().iterator(); i$.hasNext(); exchange.getIn().getHeaders().put(param, value)) {
                param = (String)i$.next();
                value = (String)params.get(param);
                if(value != null && value.length() > 0) {
                    value = URLDecoder.decode(value, "UTF-8");
                }
            }
        }

    }
}
