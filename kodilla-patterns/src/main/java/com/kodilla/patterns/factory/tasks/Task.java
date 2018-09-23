package com.kodilla.patterns.factory.tasks;

public interface Task {
    void executeTask();// — wykonującą zadanie,
    String getTaskName();// — zwracającą nazwę zadania do wykonania,
    boolean isTaskExecuted();// — zwracającą true lub false, w zależności od tego, czy zadanie jest już wykonane.

}
