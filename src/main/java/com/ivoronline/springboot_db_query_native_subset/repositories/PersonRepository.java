package com.ivoronline.springboot_db_query_native_subset.repositories;

import com.ivoronline.springboot_db_query_native_subset.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //=======================================================================================
  // RETURN SINGLE PROPERTY
  //=======================================================================================
  // 20
  @Query(value = "SELECT age FROM PERSON WHERE NAME = 'John' AND AGE = 20", nativeQuery = true)
  Integer returnSingleProperty();

  //=======================================================================================
  // RETURN SOME PROPERTIES AS STRING
  //=======================================================================================
  // John,20
  @Query(value = "SELECT name, age FROM PERSON WHERE NAME = 'John' AND AGE = 20", nativeQuery = true)
  String returnSomePropertiesAsString();

  //=======================================================================================
  // RETURN SOME PROPERTIES AS OBJECT ARRAY
  //=======================================================================================
  // ["John",20]
  @Query(value = "SELECT name, age FROM PERSON WHERE NAME = 'John' AND AGE = 20", nativeQuery = true)
  Object returnSomePropertiesAsObjectArray();

  //=======================================================================================
  // RETURN SOME PROPERTIES AS SINGLE JSON RECORD
  //=======================================================================================
  // {"name":"John","age":20}
  @Query(
    value =
      "SELECT CAST(row_to_json(EXPRESSION) AS VARCHAR) " +
      "FROM (SELECT name, age FROM PERSON WHERE NAME = 'John' AND AGE = 20) AS EXPRESSION",
    nativeQuery = true
  )
  String returnSomePropertiesAsSingleJSONRecord();

  //=======================================================================================
  // RETURN SOME PROPERTIES AS JSON ARRAY
  //=======================================================================================
  // [{"name":"John","age":20}, {"name":"John","age":21}] Returns String that looks like JSON Array
  // []                                                   Returns [] if no Records are found
  @Query(
    value =
      "SELECT CAST(COALESCE(json_agg(EXPRESSION), '[]') AS varchar) " +
      "FROM   (SELECT name, age FROM PERSON WHERE NAME = 'John') AS EXPRESSION",
    nativeQuery = true
  )
  String returnSomePropertiesAsJSONArray();

  //=======================================================================================
  // RETURN ALL PROPERTIES AS SINGLE JSON RECORD
  //=======================================================================================
  // {"name":"John","age":20}
  @Query(
    value =
      "SELECT CAST(row_to_json(EXPRESSION) AS VARCHAR)" +
      "FROM PERSON AS EXPRESSION WHERE NAME = 'John' AND AGE = 20",
    nativeQuery = true
  )
  String returnAllPropertiesAsSingleJSONRecord();

  //=======================================================================================
  // RETURN ALL PROPERTIES AS JSON ARRAY
  //=======================================================================================
  // Rreturns String that contains JSON Array: [{"name":"John","age":20}, {"name":"John","age":21}]
  // Returns [] if no Records are found:       []
  @Query(
    value =
      "SELECT CAST(COALESCE(json_agg(EXPRESSION), '[]') AS VARCHAR)" +
      "FROM PERSON AS EXPRESSION WHERE name = 'John'",
    nativeQuery = true
  )
  String returnAllPropertiesAsJSONArray();

}
