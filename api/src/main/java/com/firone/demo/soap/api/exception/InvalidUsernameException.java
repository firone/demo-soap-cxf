package com.firone.demo.soap.api.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.ws.WebFault;

@Data
@EqualsAndHashCode(callSuper = true)
@WebFault(name = "DuplicateDirectoryReferenceIdException")
public class InvalidUsernameException extends Exception {

    private String username;
    private String validationRegex;

    public InvalidUsernameException(String message) {
        super(message);
    }

    public InvalidUsernameException(String message, String invalidUsername, String validationRegex) {
        super(message);
        this.username = invalidUsername;
        this.validationRegex = validationRegex;
    }
}
