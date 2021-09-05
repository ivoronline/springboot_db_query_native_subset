package com.ivoronline.springboot_db_query_native_subset.runners;

import com.ivoronline.springboot_db_query_native_subset.entities.Person;
import com.ivoronline.springboot_db_query_native_subset.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoadPersons implements CommandLineRunner {

  @Autowired PersonRepository personRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    //CREATE PERSON
    Person  person      = new Person();
            person.name = "John";
            person.age  = 20;

    //SAVE PERSON
    personRepository.save(person);

  }

}

