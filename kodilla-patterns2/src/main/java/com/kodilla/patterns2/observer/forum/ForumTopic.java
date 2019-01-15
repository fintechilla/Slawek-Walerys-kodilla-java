package com.kodilla.patterns2.observer.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumTopic implements Observable{
    private final List<Observer> observers;
    private final List<String> messages;
    private final String name;

    public ForumTopic(String name) {
        this.observers = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.name = name;
    }
    public void addPost(String post){
        messages.add(post);
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer observer){
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer:observers){
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

//    @Override
//    public void removeObserver(Observer observer){
//        this.observers.remove(observer);
//    }

    public List<String> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }
}
