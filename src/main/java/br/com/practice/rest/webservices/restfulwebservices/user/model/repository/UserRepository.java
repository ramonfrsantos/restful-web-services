package br.com.practice.rest.webservices.restfulwebservices.user.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.practice.rest.webservices.restfulwebservices.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  
}