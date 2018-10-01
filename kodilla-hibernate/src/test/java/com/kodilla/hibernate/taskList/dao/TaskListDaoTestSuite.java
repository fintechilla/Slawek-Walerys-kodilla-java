package com.kodilla.hibernate.taskList.dao;

import com.kodilla.hibernate.taskList.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    public static final String DESCRIPTION = "Test List of Tasks: Learn Hibernate ";
    public static final String NAME = " HIBERNATE";
    @Test
    public void testFindByListName(){
        //Given
        TaskList taskList = new TaskList(NAME, DESCRIPTION);
        taskListDao.save(taskList);
        //When
        List<TaskList> taskListsFound = taskListDao.findByListName(NAME);
        int id = taskListsFound.get(0).getId();
        System.out.println("Id in found: " + id);
                //Then
        Assert.assertEquals(1,taskListsFound.size());
        Assert.assertEquals(true, taskListsFound.get(0).equals(taskList));
        //Clean up
        taskListDao.delete(taskList);
    }
}
