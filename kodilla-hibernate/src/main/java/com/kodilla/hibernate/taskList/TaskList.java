package com.kodilla.hibernate.taskList;

import com.kodilla.hibernate.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TASKLISTS")
public class TaskList {
    private int id;
    private String listName;
    private String description;
    private List<Task> tasks = new ArrayList<>();

    public TaskList(String listName, String description) {
        this.id = id;
        this.listName = listName;
        this.description = description;
    }

    public TaskList() {
    }
    @Id
    @GeneratedValue
    @Column(name="ID", unique = true)
    @NotNull
    public int getId() {
        return id;
    }
    @Column(name="LISTNAME")
    public String getListName() {
        return listName;
    }
    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    private void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskList taskList = (TaskList) o;

        if (getListName() != null ? !getListName().equals(taskList.getListName()) : taskList.getListName() != null)
            return false;
        return getDescription() != null ? getDescription().equals(taskList.getDescription()) : taskList.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getListName() != null ? getListName().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
