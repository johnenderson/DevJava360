package com.issuetracker.engine.exception;

public class InvalidNumberException extends Exception {
    private static final String MESSAGE = "O número escolhido é inválido! Digite um número entre 1 e 2.";

    public InvalidNumberException() {
        super(MESSAGE);
    }
}
