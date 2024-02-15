package com.otus.spring.persistence;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.otus.spring.domain.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity {
    @CsvBindByPosition(position = 0)
    private String question;

    @CsvBindAndSplitByPosition(
            position = 1,
            collectionType = HashSet.class,
            elementType = Answer.class,
            converter = AnswerCsvConverter.class,
            splitOn = "\\|"
    )
    private Set<Answer> answers;
}