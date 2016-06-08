package com.firone.demo.soap.server;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@SpringBootApplication
@Configuration
@ComponentScan("com.firone.demo.soap")
public class SoapServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapServerApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(HelloServiceImpl helloService) {
        EndpointImpl endpoint = new EndpointImpl(springBus(), helloService);
        endpoint.publish("/HelloService");
        endpoint.setWsdlLocation("HelloService.wsdl");
        return endpoint;
    }
}
