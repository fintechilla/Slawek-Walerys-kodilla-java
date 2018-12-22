package com.kodilla.exception.nullPointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args){
        User user = null;
        MessageSender messageSender = new MessageSender();
        try {
            messageSender.messageSendTo(user, "Hello");
        } catch (MessageNotSentException e) {
            System.out.println("We found a null point exception, message: ");
            //e.printStackTrace();
        }
            System.out.println("Processing other logic!");
    }
}
