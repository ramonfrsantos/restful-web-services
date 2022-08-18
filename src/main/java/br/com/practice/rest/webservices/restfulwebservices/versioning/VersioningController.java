package br.com.practice.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

  // URI PARAM ===============================================
  
  @GetMapping("/v1/person")
  public PersonV1 personV1(){
    return new PersonV1("Bob Silva");
  }
  
  @GetMapping("/v2/person")
  public PersonV2 personV2(){
    return new PersonV2(new Name("Bob", "Silva"));
  }

  // REQUEST PARAM ===========================================
  
  @GetMapping(value="/person/param", params="version1")
  public PersonV1 paramV1(){
    return new PersonV1("Bob Silva");
  }
  
  @GetMapping(value="/person/param", params="version2")
  public PersonV2 paramV2(){
    return new PersonV2(new Name("Bob", "Silva"));
  }

  // HEADER PARAM ============================================
  
  @GetMapping(value="/person/header", headers="X-API-VERSION=1")
  public PersonV1 headerV1(){
    return new PersonV1("Bob Silva");
  }
  
  @GetMapping(value="/person/header", headers="X-API-VERSION=2")
  public PersonV2 headerV2(){
    return new PersonV2(new Name("Bob", "Silva"));
  }

  // PRODUCES (Accept Header) ================================
  
  @GetMapping(value="/person/produces", produces="application/mycompany.app-v1+json")
  public PersonV1 producesV1(){
    return new PersonV1("Bob Silva");
  }
  
  @GetMapping(value="/person/produces", produces="application/mycompany.app-v2+json")
  public PersonV2 producesV2(){
    return new PersonV2(new Name("Bob", "Silva"));
  }

}
