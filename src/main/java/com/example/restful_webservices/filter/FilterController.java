package com.example.restful_webservices.filter;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @RequestMapping("/getStudent")
    public MappingJacksonValue getStudent(){
        Student student = new Student("satish","gon",24);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("first_name","last_name");
        FilterProvider filters= new SimpleFilterProvider().addFilter("studentName",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(student);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @RequestMapping("/getAll")
    public MappingJacksonValue getAll(){
        List<Student> student1 =  Arrays.asList(new Student("arjun" , "palle",23),
                new Student("gun", "gunnam", 26),
                new Student("raj", "gonda", 26));

        MappingJacksonValue mapping = new MappingJacksonValue(student1);
        SimpleBeanPropertyFilter filters = SimpleBeanPropertyFilter.filterOutAllExcept("age");
        FilterProvider filter = new SimpleFilterProvider().addFilter("studentName",filters);
        mapping.setFilters(filter);
        return mapping;
    }
}
