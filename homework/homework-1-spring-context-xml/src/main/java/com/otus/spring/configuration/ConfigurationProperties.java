package com.otus.spring.configuration;

public record ConfigurationProperties(String fileName) implements QuestionFileNameProvider {

    @Override
    public String getFileName() {
        return fileName;
    }
}
