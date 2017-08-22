package com.akhatri.demo.bootstrap;

import org.restlet.Component;
import org.restlet.ext.spring.SpringServerServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "com.akhatri")
public class StartRestServicesApplication {

    private static final String CAMEL_URL_MAPPING = "/services/*";

    public static void main(String[] args) {
        SpringApplication.run(StartRestServicesApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        SpringServerServlet serverServlet = new SpringServerServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(serverServlet, CAMEL_URL_MAPPING);

        Map<String, String> params = new HashMap<String, String>();
        params.put("org.restlet.component", "restletComponent");
        registration.setInitParameters(params);
        return registration;
    }

    @Bean
    public Component restletComponent() {
        return new Component();
    }

}
