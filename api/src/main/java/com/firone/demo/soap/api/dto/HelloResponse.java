package com.firone.demo.soap.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HelloResponse {

    private String message;
    private Date date;

    public HelloResponse() {
    }

    public HelloResponse(String helloMessage, Date helloDate) {
        this.message = helloMessage;
        this.date = helloDate;
    }
}
