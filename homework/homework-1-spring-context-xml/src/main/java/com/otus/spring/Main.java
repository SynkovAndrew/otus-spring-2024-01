package com.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-context.xml");
    }
}
