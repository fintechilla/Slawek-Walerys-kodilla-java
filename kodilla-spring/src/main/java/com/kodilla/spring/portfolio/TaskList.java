package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks = new ArrayList<>();

    public List<String> getTasks() {
        return tasks;
    }
    public  void add(String task){
        tasks.add(task);
    }
}
