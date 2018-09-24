package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    public Board(String name) {
        this.name = name;
    }
    public void addTaskList(TaskList taskList){
        taskLists.add(taskList);
    }
    public boolean removeTaskList(TaskList taskList){
        return taskLists.remove(taskList);
    }

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{" +
                "taskLists=" + taskLists +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (!getTaskLists().equals(board.getTaskLists())) return false;
        return getName().equals(board.getName());
    }

    @Override
    public int hashCode() {
        int result = getTaskLists().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
