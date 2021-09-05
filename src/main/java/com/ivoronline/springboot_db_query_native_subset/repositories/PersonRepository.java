package com.ivoronline.springboot_db_query_native_subset.repositories;

import com.ivoronline.springboot_db_query_native_subset.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //=======================================================================================
  // RETURN SCALAR
  //=======================================================================================
  // 20
  @Query(nativeQuery = true, value = "SELECT age FROM PERSON WHERE NAME = 'John' AND AGE = 20")
  Integer returnScalar();

  //=======================================================================================
  // RETURN STRING
  //=======================================================================================
  // John,20
  @Query(nativeQuery = true, value = "SELECT name, age FROM PERSON WHERE NAME = 'John' AND AGE = 20")
  String returnString();

}
