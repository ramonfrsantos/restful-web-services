package br.com.practice.rest.webservices.restfulwebservices.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
  
  @GetMapping("/filtering")
  public MappingJacksonValue retrieveSomeBean(){
    SomeBean someBean = new SomeBean("value1", "value2", "value3");

    String[] values ={"field1", "field3"};

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(values);

    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

    MappingJacksonValue mapping = new MappingJacksonValue(someBean);

    mapping.setFilters(filters);

    return mapping;
  }
}
