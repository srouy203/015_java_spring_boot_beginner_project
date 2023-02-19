package com.testing.cms.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {

    @RequestMapping(value = "/hello")
    public String HelloWorld () {
        return "Hello World";
    }
}
