package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWordController {
    @GetMapping(path = "/hello-word")
    public String helloWorld(){
        return "Hello World";
    }
    @GetMapping(path = "/hello-word-bean")
    public HelloWordBean helloWorldBean(){
        return new HelloWordBean("Hello World");
    }
    @GetMapping(path = "/hello-word-variable/{name}")
    public HelloWordBean helloWorldVariable(@PathVariable String name){
        return new HelloWordBean("Hello World " + name);
    }
}
