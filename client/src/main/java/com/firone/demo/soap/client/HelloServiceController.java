package com.firone.demo.soap.client;

import com.firone.demo.soap.api.dto.HelloResponse;
import com.firone.demo.soap.api.exception.InvalidUsernameException;
import com.firone.demo.soap.api.service.HelloServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloServiceController {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceController.class);

    @Autowired
    private HelloServiceApi helloServiceApi;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(@RequestParam("username") String username) throws InvalidUsernameException {
        HelloResponse helloResponse = helloServiceApi.sayHello(username);
        return helloResponse.getMessage() + " with date " + helloResponse.getDate();
    }

    @ResponseBody
    @ExceptionHandler(InvalidUsernameException.class)
    public String invalidUserNameExceptionHandler(InvalidUsernameException e) {

        String errorMessage = String.format("The user name [%s] don't match regex %s", e.getUsername(), e.getValidationRegex());
        logger.info(errorMessage, e);
        return errorMessage;
    }
}
