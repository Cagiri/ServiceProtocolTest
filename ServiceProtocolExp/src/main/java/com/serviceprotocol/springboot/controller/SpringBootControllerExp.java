package com.serviceprotocol.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootControllerExp {

	private static final String template = "Hello, %s!";
	
    @RequestMapping(value="/communication-service/{name}", method = RequestMethod.GET)
    public String communicationService(@PathVariable String name) {

    	return "{\"message\":\"" + String.format(template, name)+"\"}";
    }
}
