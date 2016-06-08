package com.firone.demo.soap.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ComponentScan("com.firone.demo.soap")
@ImportResource("classpath:soap-client.xml")
public class SoapServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapServerApplication.class, args);
    }
}
