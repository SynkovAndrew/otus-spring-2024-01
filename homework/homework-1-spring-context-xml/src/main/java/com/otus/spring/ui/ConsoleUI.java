package com.otus.spring.ui;

import com.otus.spring.domain.QuestionReader;

public class ConsoleUI {
    private final QuestionReader questionReader;

    public ConsoleUI(QuestionReader questionReader) {
        this.questionReader = questionReader;
    }

    public void run() {
        questionReader.readAll()
                .forEach(question -> System.out.println(question.value()));
    }
}
