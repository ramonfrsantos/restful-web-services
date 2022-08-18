package br.com.practice.rest.webservices.restfulwebservices.user.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.practice.rest.webservices.restfulwebservices.user.model.User;
import br.com.practice.rest.webservices.restfulwebservices.user.model.exception.UserNotFoundException;
import br.com.practice.rest.webservices.restfulwebservices.user.model.service.UserDaoService;

@RestController
public class UserController {
  
  @Autowired
  private UserDaoService service;
  
  // @Autowired
  // private FilteringService filter;
  
  // @GetMapping("/users-name")
  // public MappingJacksonValue retrieveAllUsersName() {
  //   List<User> users = service.findAll();
  //   String[] values = {"name"};

  //   return filter.retrieveData(values, users, "UserFilter");
  // }

  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
   return service.findAll();
  }
  
  @GetMapping("/users/{id}")
  public EntityModel<User> retrieveUser(@PathVariable int id) {
    User user = service.findOne(id);

    if(user==null){
      throw new UserNotFoundException("id - " + id);
    }

    EntityModel<User> model = EntityModel.of(user);

    WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
    model.add(linkToUsers.withRel("all-users"));

    return model;
  }
  
  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = service.save(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    User user = service.deleteById(id);

    if(user==null){
      throw new UserNotFoundException("id - " + id);
    }
  }
}
