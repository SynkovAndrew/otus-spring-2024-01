package com.otus.spring.dao;

import com.otus.spring.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
