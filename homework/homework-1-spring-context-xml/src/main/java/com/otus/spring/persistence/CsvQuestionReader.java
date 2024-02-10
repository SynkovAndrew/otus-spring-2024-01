package com.otus.spring.persistence;

import com.otus.spring.domain.Question;
import com.otus.spring.domain.QuestionReader;
import com.otus.spring.domain.ReadingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CsvQuestionReader implements QuestionReader {
    private final String questionFilePath;

    public CsvQuestionReader(String questionFilePath) {
        this.questionFilePath = questionFilePath;
    }

    @Override
    public List<Question> readAll() {
        var resource = getResource(questionFilePath);
        try (var reader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))) {
            return reader.lines()
                    .map(Question::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new ReadingException("Error occurred during reading file " + questionFilePath, e);
        }
    }

    private InputStream getResource(String path) {
        return Optional.ofNullable(getClass().getClassLoader().getResourceAsStream(path))
                .orElseThrow(() -> new ReadingException("File " + questionFilePath + " is not found"));
    }
}
