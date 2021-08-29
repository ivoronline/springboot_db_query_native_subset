package com.ivoronline.springboot_db_query_native_subset.controllers;

import com.ivoronline.springboot_db_query_native_subset.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired PersonRepository personRepository;

  //================================================================
  // SOME PROPERTIES AS STRING
  //================================================================
  @RequestMapping("SomePropertiesAsString")
  String somePropertiesAsString() {
    String string = personRepository.somePropertiesAsString();
    return string;
  }
  //================================================================
  // SOME PROPERTIES AS JSON
  //================================================================
  @RequestMapping("SomePropertiesAsJSON")
  String somePropertiesAsJSON() {
    String json = personRepository.somePropertiesAsJSON();
    return json;
  }

}


