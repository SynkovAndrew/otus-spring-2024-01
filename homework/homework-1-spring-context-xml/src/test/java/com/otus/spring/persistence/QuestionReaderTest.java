package com.otus.spring.persistence;

import com.otus.spring.configuration.ConfigurationProperties;
import com.otus.spring.domain.Answer;
import com.otus.spring.domain.Question;
import com.otus.spring.domain.ReadingException;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QuestionReaderTest {
    private final QuestionEntityMapper questionEntityMapper = new QuestionEntityMapper();

    @Test
    void readQuestions() {
        var questionFileNameProvider = new ConfigurationProperties("questions.csv");
        var questionReader = new QuestionCsvReader(questionFileNameProvider, questionEntityMapper);
        var questions = questionReader.readAll();

        assertThat(questions)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(
                        Stream.of(
                                new Question("Are you ...?", Answer.allValues()),
                                new Question("Do you ...?", Answer.allValues()),
                                new Question("Do you like ...?", Answer.allValues()),
                                new Question("Have you been to ...?", Answer.allValues()),
                                new Question("Are you interested in ...?", Answer.allValues())
                        ).collect(Collectors.toList())
                );
    }

    @Test
    void failedToReadQuestionsCauseFileNotFound() {
        var questionFileNameProvider = new ConfigurationProperties("file3.csv");
        var questionReader = new QuestionCsvReader(questionFileNameProvider, questionEntityMapper);

        assertThatThrownBy(questionReader::readAll)
                .isInstanceOf(ReadingException.class);
    }
}
