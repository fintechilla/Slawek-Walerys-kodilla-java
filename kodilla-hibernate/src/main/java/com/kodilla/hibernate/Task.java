package com.kodilla.hibernate;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.taskList.TaskList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "Task.retrieveLongTasks",
                query = "from Task where duration > 10"),
        @NamedQuery(name = "Task.retrieveShortTasks",
                query = "from Task where duration <= 10")
})
@NamedNativeQuery(name = "Task.retrieveTasksWithEnoughTime",
        query = "select * from tasks where datediff(date_add(created, interval duration day), now()) > 5",
        resultClass = Task.class)
@Entity
@Table(name = "Tasks")
public class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private TaskList taskList;

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    public Task() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASK_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn(name = "TASKLISTS_ID")
    public TaskList getTaskList() {
        return taskList;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}
