package br.com.practice.rest.webservices.restfulwebservices.user.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.practice.rest.webservices.restfulwebservices.user.model.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
  
}