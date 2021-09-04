package com.ivoronline.springboot_db_query_native_subset.controllers;

import com.ivoronline.springboot_db_query_native_subset.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired PersonRepository personRepository;

  //================================================================
  // RETURN SCALAR
  //================================================================
  // 20
  @RequestMapping("ReturnScalar")
  Integer returnScalar() {
    Integer age = personRepository.returnScalar();
    return  age;
  }

  //================================================================
  // RETURN STRING
  //================================================================
  // John,20
  @RequestMapping("ReturnString")
  String returnString() {
    String nameAge = personRepository.returnString();
    return nameAge;
  }

  //================================================================
  // RETURN OBJECT ARRAY
  //================================================================
  // ["John",20]
  @RequestMapping("ReturnObjectArray")
  Object returnObjectArray() {
    Object[] properties = (Object[]) personRepository.returnObjectArray();
    String   name       = (String)   properties[0];
    Integer  age        = (Integer)  properties[1];
    System.out.println(name + ", " + age);
    return properties;
  }

  //================================================================
  // RETURN JSON RECORD
  //================================================================
  // {"name":"John","age":20}
  @RequestMapping("ReturnJSONRecord")
  String returnJSONRecord() {
    String json = personRepository.returnJSONRecord();
    return json;
  }

  //================================================================
  // RETURN JSON ARRAY
  //================================================================
  // [{"name":"John","age":20}, {"name":"John","age":21}]
  @RequestMapping("ReturnSONArray")
  String returnSONArray() {
    String json = personRepository.returnSONArray();
    return json;
  }

}


