package com.akhatri.route;

import com.akhatri.processor.RequestPostProcessor;
import com.akhatri.route.pojo.UserPojo;
import com.akhatri.services.UserDataService;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceRoute extends SpringRouteBuilder {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private RequestPostProcessor requestPostProcessor;


    @Override
    public void configure() throws Exception {
        /* User Name list Route */
        from("restlet:/v1/user?restletMethods=GET")
                .routeId("com.usernamelist")
                .streamCaching()
                .removeHeaders("CamelHttp*", "CamelHttpMethod")
                .bean(userDataService, "getUsers()")
                .process(requestPostProcessor)
                .marshal().json(JsonLibrary.Jackson);


        from("restlet:/v1/user1?restletMethods=GET&restletBinding=#customRestletBinding")
                .routeId("com.usernamelist1")
                .streamCaching()
                .removeHeaders("CamelHttp*", "CamelHttpMethod")
                .bean(userDataService, "getUsers1(${header.name})")
                .process(requestPostProcessor)
                .marshal().json(JsonLibrary.Jackson);
		
		/* User Create Route */
        from("restlet:/v1/user?restletMethods=POST")
                .routeId("com.createuser")
                .streamCaching()
                .removeHeaders("CamelHttp*", "CamelHttpMethod")
                .unmarshal().json(JsonLibrary.Jackson, UserPojo.class)
                .bean(userDataService, "createUser(${body})")
                .process(requestPostProcessor)
                .marshal().json(JsonLibrary.Jackson);
    }

}