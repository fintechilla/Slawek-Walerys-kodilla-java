package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;
import static java.util.stream.Collectors.toList;

public class BoardTestSuite {
    public Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                now().minusDays(20),
                now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                now().minusDays(20),
                now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                now().minusDays(20),
                now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                now().minusDays(10),
                now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                now(),
                now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                now().minusDays(15),
                now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }
    @Test //Test Module 7.6 - Average length of Tasks - using direct averaging
    public void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();
        //When
        List<TaskList> inProgressionTasks = new ArrayList<>();
        inProgressionTasks.add(new TaskList("In progress"));
//        inProgressionTasks.add(new TaskList("To do"));
        LocalDate now = now();
        Double result = project.getTaskLists().stream()
                .filter(inProgressionTasks::contains)
                .flatMap(t -> t.getTasks().stream())
                .map(t -> t.getCreated())
                .map(s -> Period.between(s, LocalDate.now()).getDays())
                .collect(Collectors.averagingInt(Integer::shortValue))
                ;
        //Then
        Assert.assertEquals(10.0, result, 0.1);
    }
    @Test //Test Module 7.6 - Average length of Tasks - using averaging counting values and number of tasks separately
    public void testAddTaskListAverageWorkingOnTaskSeparately() {
        //Given
        Board project = prepareTestData();
        //When
        List<TaskList> inProgressionTasksSep = new ArrayList<>();
        inProgressionTasksSep.add(new TaskList("In progress"));
        inProgressionTasksSep.add(new TaskList("To do"));
        LocalDate now = now();
        Integer sum = project.getTaskLists().stream()
                .filter(inProgressionTasksSep::contains)
                .flatMap(t -> t.getTasks().stream())
                .map(t -> t.getCreated())
                .map(s -> Period.between(s, LocalDate.now()).getDays())
                .collect(Collectors.summingInt(Integer::shortValue))
                ;
        long count = project.getTaskLists().stream()
                .filter(inProgressionTasksSep::contains)
                .flatMap(t -> t.getTasks().stream())
                .map(t -> t.getCreated())
                .map(s -> Period.between(s, LocalDate.now()).getDays())
                .count()
                ;
        double average = sum / count;

        //Then
        Assert.assertEquals(70, sum, 1);
        Assert.assertEquals(5, count, 0.1);
        Assert.assertEquals(14.0, average, 0.1);
    }
    @Test //Test 0
    public void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }

    @Test //Test 1
    public void testAddTaskListFindUsersTasks() {
        //Given
        Board project = prepareTestData();
        User user = new User("developer1", "John Smith");
        //When
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());
        //Then
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test //Test 2
    public void testAddTaskListFindOutDatedTasks() {
        //Given
        Board project = prepareTestData();
        //When
        List<TaskList> notDoneTasks = new ArrayList<>();
        notDoneTasks.add(new TaskList("To do"));
        notDoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(notDoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(now()))
                .collect(toList());
        //Then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test //Test - 3
    public void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();
        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(t -> t.getTasks().stream())
                .map(t -> t.getCreated())
                .filter(d -> d.compareTo(now().minusDays(10)) <= 0)
                .count();
        //Then
        Assert.assertEquals(2, longTasks);
    }


}



