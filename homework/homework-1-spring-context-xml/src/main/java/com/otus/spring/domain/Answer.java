package com.otus.spring.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Answer {
    YES, NO;

    public static Set<Answer> allValues() {
        return Arrays.stream(Answer.values()).collect(Collectors.toSet());
    }
}
