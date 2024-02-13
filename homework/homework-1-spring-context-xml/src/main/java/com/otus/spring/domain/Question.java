package com.otus.spring.domain;

import java.util.Set;

public record Question(String question, Set<Answer> answers) {
}
