package com.akhatri.services;

import com.akhatri.route.pojo.APIResponsePojo;
import com.akhatri.route.pojo.UserPojo;
import org.springframework.stereotype.Service;

@Service
public class UserDataService extends AbstractService {

    public APIResponsePojo getUsers() {
        String[] names = {"Tom", "Daniel"};
        return getResponse(names);
    }

    public APIResponsePojo getUsers1(String name) {
        System.out.println("name>>" + name);
        String[] names = {"Tom", "Daniel"};
        return getResponse(names);
    }

    public APIResponsePojo createUser(UserPojo userPojo) {
        APIResponsePojo responsePojo = null;
        if (userPojo.getUserName().endsWith("son")) {
            responsePojo = getErrorResponse("User already exist");
        } else {
            responsePojo = getResponse("User is created");
        }
        return responsePojo;
    }

}