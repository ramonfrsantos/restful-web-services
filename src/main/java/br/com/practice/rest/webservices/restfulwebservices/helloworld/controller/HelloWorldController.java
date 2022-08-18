package br.com.practice.rest.webservices.restfulwebservices.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.practice.rest.webservices.restfulwebservices.helloworld.model.HelloWorldBean;

// Controller
@RestController
public class HelloWorldController {
  
  // GET parameters
  // URI - /hello-world
  // method - "Hello World"
  // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
  @GetMapping(path = "/hello-world")
  public String helloWorld(){
    return "Hello World!";
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean(){
    return new HelloWorldBean("Hello World!");
  }

}