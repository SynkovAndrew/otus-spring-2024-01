package com.otus.spring.service;

import lombok.RequiredArgsConstructor;

import java.io.PrintStream;

@RequiredArgsConstructor
public class StreamIOService implements IOService {
    private final PrintStream printStream;

    @Override
    public void printLine(String line) {
        printStream.println(line);
    }

    @Override
    public void printFormattedLine(String line, Object... args) {
        printStream.printf(line, args);
    }
}
