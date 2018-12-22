package com.kodilla.exception.nullPointer;

public class MessageNotSentException extends Exception {
    public MessageNotSentException(final String message) {
        super(message);
    }
}
