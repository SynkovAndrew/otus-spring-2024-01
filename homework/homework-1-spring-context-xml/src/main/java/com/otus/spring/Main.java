package com.otus.spring;

import com.otus.spring.bootstrap.Application;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("spring-context.xml");
        var application = context.getBean(Application.class);
        application.start();
    }
}
