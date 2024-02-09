package com.otus.spring;

import com.otus.spring.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        final var context = new ClassPathXmlApplicationContext("spring-context.xml");
        final var personService = context.getBean(PersonService.class);
        final var ivan = personService.getByName("Ivan");
        System.out.println(ivan);
    }
}
