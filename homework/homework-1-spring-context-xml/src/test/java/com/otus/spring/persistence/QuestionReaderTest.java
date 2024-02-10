package com.otus.spring.persistence;

import com.otus.spring.domain.Question;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QuestionReaderTest {

    @Test
    void readQuestions() {
        var questionReader = new CsvQuestionReader("questions.csv");
        var questions = questionReader.readAll();

        assertThat(questions)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(
                        Stream.of(
                                new Question("Are you ...?"),
                                new Question("Do you ...?"),
                                new Question("Do you like ...?"),
                                new Question("Have you been to ...?"),
                                new Question("Are you interested in ...?")
                        ).collect(Collectors.toList())
                );
    }

    @Test
    void failedToReadQuestionsCauseFileNotFound() {
        var questionReader = new CsvQuestionReader("file3.csv");

        assertThatThrownBy(questionReader::readAll)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
