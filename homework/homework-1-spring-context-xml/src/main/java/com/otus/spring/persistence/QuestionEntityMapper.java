package com.otus.spring.persistence;

import com.otus.spring.domain.Question;

public class QuestionEntityMapper implements EntityMapper<Question, QuestionEntity> {

    @Override
    public Question toDomain(QuestionEntity entity) {
        return new Question(entity.getQuestion(), entity.getAnswers());
    }

    @Override
    public QuestionEntity toEntity(Question persistenceEntity) {
        return new QuestionEntity(persistenceEntity.question(), persistenceEntity.answers());
    }
}
