package br.com.practice.rest.webservices.restfulwebservices.user.model.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

  @Id
  @GeneratedValue
  private Integer id;
  private String description;

  // não retorna as informações de User se não chamá-lo diretamente
  @ManyToOne(fetch=FetchType.LAZY)
  @JsonIgnore
  private User user;
  
  public Post(Integer id, String description, User user) {
    this.id = id;
    this.description = description;
    this.user = user;
  }

  protected Post() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  @Override
  public String toString() {
    return "Post [description=" + description + ", id=" + id + "]";
  }
  
}
