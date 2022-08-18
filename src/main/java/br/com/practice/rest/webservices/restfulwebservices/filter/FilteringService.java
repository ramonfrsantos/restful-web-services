package br.com.practice.rest.webservices.restfulwebservices.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringService {
  
  public MappingJacksonValue retrieveData(String[] values, Object object, String filterType){
   
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(values);
    FilterProvider filters = new SimpleFilterProvider().addFilter(filterType, filter);

    MappingJacksonValue mapping = new MappingJacksonValue(object);

    mapping.setFilters(filters);

    return mapping;
  }
}
