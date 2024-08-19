package com.ivoronline.repository;

import com.ivoronline.entity.Utility;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtilityRepository extends CrudRepository<Utility, Integer> {

  //=======================================================================================
  // RETURN SCALAR
  //=======================================================================================
  // 20
  @Query(value = "SELECT AGE FROM PERSON WHERE NAME = 'Bill' AND AGE = 30", nativeQuery = true)
  Integer returnScalar();

  //=======================================================================================
  // RETURN STRING
  //=======================================================================================
  // John,20
  @Query(value = "SELECT NAME, AGE FROM PERSON WHERE NAME = 'Bill' AND AGE = 30", nativeQuery = true)
  String returnString();

}
