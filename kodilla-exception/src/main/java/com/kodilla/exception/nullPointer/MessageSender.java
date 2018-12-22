package com.kodilla.exception.nullPointer;

public class MessageSender {
    public void messageSendTo(User user, String message) throws MessageNotSentException {
        if(user != null) {
            System.out.println("Sending a message " + message + " to " + user.getName());
        } else {
            throw new MessageNotSentException("Object user was null");
        }
    }
}
