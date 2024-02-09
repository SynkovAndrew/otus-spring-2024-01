package com.otus.spring.dao;

import com.otus.spring.domain.Person;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
