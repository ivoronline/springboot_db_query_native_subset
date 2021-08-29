package com.ivoronline.springboot_db_query_native_subset.repositories;

import com.ivoronline.springboot_db_query_native_subset.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //=======================================================================================
  // RETURN SOME PROPERTIES AS STRING
  //=======================================================================================
  // John,20
  @Query(value = "SELECT name, age FROM PERSON WHERE NAME = 'John' AND AGE = 20", nativeQuery = true)
  String somePropertiesAsString();

  //=======================================================================================
  // RETURN SOME PROPERTIES AS JSON
  //=======================================================================================
  //RETURNS STRING: John,20
  @Query(
    value =
      "SELECT CAST(COALESCE(json_agg(row_to_json(rules_info)), CAST('[]' AS json)) AS varchar) " +
      "FROM   (SELECT name, age FROM PERSON WHERE NAME = 'John' AND AGE = 20) " +
      "AS     rules_info",
    nativeQuery = true
  )
  String somePropertiesAsJSON();

}
