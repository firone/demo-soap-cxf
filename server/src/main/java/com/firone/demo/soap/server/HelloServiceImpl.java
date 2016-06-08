package com.firone.demo.soap.server;

import com.firone.demo.soap.api.dto.HelloResponse;
import com.firone.demo.soap.api.exception.InvalidUsernameException;
import com.firone.demo.soap.api.service.HelloServiceApi;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("helloServiceImpl")
public class HelloServiceImpl implements HelloServiceApi {

    private String validationRegex = "[a-zA-Z0-9]+";

    @Override
    public HelloResponse sayHello(String username) throws InvalidUsernameException {

        if (!username.matches(validationRegex)) {
            throw new InvalidUsernameException("Given username is not valid.", username, validationRegex);
        }

        return new HelloResponse("Hello " + username, new Date());
    }
}
