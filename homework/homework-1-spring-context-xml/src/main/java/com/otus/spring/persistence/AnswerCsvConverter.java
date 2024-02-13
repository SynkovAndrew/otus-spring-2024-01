package com.otus.spring.persistence;

import com.opencsv.bean.AbstractCsvConverter;
import com.otus.spring.domain.Answer;

public class AnswerCsvConverter extends AbstractCsvConverter {

    @Override
    public Object convertToRead(String value) {
        return Answer.valueOf(value);
    }
}
