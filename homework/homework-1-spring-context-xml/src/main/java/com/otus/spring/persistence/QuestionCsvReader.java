package com.otus.spring.persistence;

import com.opencsv.bean.CsvToBeanBuilder;
import com.otus.spring.configuration.QuestionFileNameProvider;
import com.otus.spring.domain.Question;
import com.otus.spring.domain.QuestionReader;
import com.otus.spring.domain.ReadingException;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class QuestionCsvReader implements QuestionReader {
    private final QuestionFileNameProvider provider;
    private final EntityMapper<Question, QuestionEntity> questionMapper;

    @Override
    public List<Question> readAll() {
        try (var reader = new BufferedReader(new InputStreamReader(getResource(provider.getFileName())))) {
            return new CsvToBeanBuilder<QuestionEntity>(reader)
                    .withType(QuestionEntity.class)
                    .build()
                    .parse()
                    .stream()
                    .map(questionMapper::toDomain)
                    .toList();
        } catch (IOException e) {
            throw new ReadingException("Error occurred during reading file " + provider.getFileName(), e);
        }
    }

    private InputStream getResource(String path) {
        return Optional.ofNullable(getClass().getClassLoader().getResourceAsStream(path))
                .orElseThrow(() -> new ReadingException("File " + provider.getFileName() + " is not found"));
    }
}
