package com.firone.demo.soap.api.service;

import com.firone.demo.soap.api.dto.HelloResponse;
import com.firone.demo.soap.api.exception.InvalidUsernameException;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloServiceApi {

    HelloResponse sayHello(@WebParam(name = "username") String username) throws InvalidUsernameException;
}
