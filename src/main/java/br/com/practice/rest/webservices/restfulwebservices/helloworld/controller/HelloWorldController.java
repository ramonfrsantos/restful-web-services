package br.com.practice.rest.webservices.restfulwebservices.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.practice.rest.webservices.restfulwebservices.helloworld.model.HelloWorldBean;

// Controller
@RestController
public class HelloWorldController {

  @Autowired
  private MessageSource messageSource;

  // GET parameters
  // URI - /hello-world
  // method - "Hello World"
  // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
  @GetMapping(path = "/hello-world")
  public String helloWorld() {
    return "Hello World!";
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello World!");
  }

  @GetMapping(path = "/hello-world/path-variable/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("Hello World, %s!", name));
  }

  // recebe no header um locale (ex = en) e retorna a mensagem de acordo com o
  // message.properties
  @GetMapping(path = "/hello-world-internationalized")
  public String helloWorldInternationalized(
  // @RequestHeader(name="Accept-Language", required=false) Locale locale
  ) {
    return messageSource.getMessage("good.morning.message", null, "Default Message",
        // locale
        LocaleContextHolder.getLocale());
  }

}