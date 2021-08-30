package com.ivoronline.springboot_db_query_native_subset.controllers;

import com.ivoronline.springboot_db_query_native_subset.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired PersonRepository personRepository;

  //================================================================
  // RETURN SINGLE PROPERTY
  //================================================================
  // 20
  @RequestMapping("ReturnSingleProperty")
  Integer returnSingleProperty() {
    Integer age = personRepository.returnSingleProperty();
    return  age;
  }

  //================================================================
  // RETURN SOME PROPERTIES AS STRING
  //================================================================
  // John,20
  @RequestMapping("ReturnSomePropertiesAsString")
  String returnSomePropertiesAsString() {
    String nameAge = personRepository.returnSomePropertiesAsString();
    return nameAge;
  }

  //================================================================
  // RETURN SOME PROPERTIES AS OBJECT ARRAY
  //================================================================
  // ["John",20]
  @RequestMapping("ReturnSomePropertiesAsObjectArray")
  Object returnSomePropertiesAsObjectArray() {
    Object[] properties = (Object[]) personRepository.returnSomePropertiesAsObjectArray();
    String   name       = (String)   properties[0];
    Integer  age        = (Integer)  properties[1];
    System.out.println(name + ", " + age);
    return properties;
  }

  //================================================================
  // RETURN SOME PROPERTIES AS SINGLE JSON RECORD
  //================================================================
  // {"name":"John","age":20}
  @RequestMapping("ReturnsOMEPropertiesAsSingleJSONRecord")
  String returnsOMEPropertiesAsSingleJSONRecord() {
    String json = personRepository.returnSomePropertiesAsSingleJSONRecord();
    return json;
  }

  //================================================================
  // RETURN SOME PROPERTIES AS JSON ARRAY
  //================================================================
  // [{"name":"John","age":20}, {"name":"John","age":21}]
  @RequestMapping("ReturnSomePropertiesAsJSONArray")
  String returnSomePropertiesAsJSON() {
    String json = personRepository.returnSomePropertiesAsJSONArray();
    return json;
  }

  //================================================================
  // RETURN ALL PROPERTIES AS SINGLE JSON RECORD
  //================================================================
  @RequestMapping("ReturnAllPropertiesAsSingleJSONRecord")
  String returnAllPropertiesAsSingleJSONRecord() {
    String json = personRepository.returnAllPropertiesAsSingleJSONRecord();
    return json;
  }

  //================================================================
  // RETURN ALL PROPERTIES AS JSON ARRAY
  //================================================================
  @RequestMapping("ReturnAllPropertiesAsJSONArray")
  String returnAllPropertiesAsJSON() {
    String json = personRepository.returnAllPropertiesAsJSONArray();
    return json;
  }

}


