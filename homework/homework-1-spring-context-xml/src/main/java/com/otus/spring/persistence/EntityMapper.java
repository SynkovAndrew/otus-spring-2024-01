package com.otus.spring.persistence;

public interface EntityMapper <D, E> {

    D toDomain(E persistenceEntity);

    E toEntity(D persistenceEntity);
}
