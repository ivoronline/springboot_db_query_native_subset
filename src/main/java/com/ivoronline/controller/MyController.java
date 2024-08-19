package com.ivoronline.controller;

import com.ivoronline.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired UtilityRepository utilityRepository;

  //================================================================
  // RETURN SCALAR
  //================================================================
  // 20
  @RequestMapping("ReturnScalar")
  Integer returnScalar() {
    Integer age = utilityRepository.returnScalar();
    return  age;
  }

  //================================================================
  // RETURN STRING
  //================================================================
  // John,20
  @RequestMapping("ReturnString")
  String returnString() {
    String nameAge = utilityRepository.returnString();
    return nameAge;
  }

}


