package com.otus.spring.bootstrap;

import com.otus.spring.domain.QuestionReader;
import com.otus.spring.service.IOService;
import lombok.RequiredArgsConstructor;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
public class Application {
    private final IOService ioService;
    private final QuestionReader questionReader;

    public void start() {
        ioService.printLine("Please answer to each question:");

        questionReader.readAll()
                .forEach(question ->
                        ioService.printFormattedLine(
                                "%s (%s)\n",
                                question.question(),
                                question.answers().stream()
                                        .map(Enum::name)
                                        .collect(joining(", "))
                        )
                );
    }
}
