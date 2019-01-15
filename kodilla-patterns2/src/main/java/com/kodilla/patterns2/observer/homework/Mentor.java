package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer{
    private final String userName;
    private int updateCount;

    public Mentor(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Participant participant) {
        System.out.println(userName + ": New messages in topic " + participant.getName()
                + "\n" + " (total:: " + participant.getMessages().size() + " messages)");
        updateCount++;
    }
    public int getUpdateCount(){
        return updateCount;
    }

}
