package com.otus.spring.service;

import com.otus.spring.domain.Person;

public interface PersonService {

    Person getByName(String name);
}