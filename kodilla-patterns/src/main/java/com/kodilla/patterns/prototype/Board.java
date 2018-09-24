package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Set;

public final class Board extends Prototype {
    private String name;
    private Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board[ " + name + "]";
        for (TasksList list : lists) {
            s = s + "\n" + list.toString();
        }
        return s;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board) super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board) super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for (Task theTask : theList.getTasks()) {
                clonedList.getTasks().add(theTask);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }

    public void setName(String name) {
        this.name = name;
    }
}
