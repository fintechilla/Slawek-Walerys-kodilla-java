package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTestSuite {
    @Autowired
    private TaskDao taskDao;
    public static final String DESCRIPTION = "Test: Learn Hibernate";
    @Test
    public void testTaskDaoSave(){
        //Given
        Task task = new Task(DESCRIPTION, 7);
        //When
        taskDao.save(task);
        //Then
        int id = task.getId();
        Task readTask = taskDao.findOne(id);
        Assert.assertEquals(id, readTask.getId());
        //Clean up
        taskDao.delete(id);
    }
    @Test
    public void testTaskDaoFindByDuration(){
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();
        //When
        List<Task>taskList = taskDao.findByDuration(7);
        //Then
        Assert.assertEquals(1, taskList.size());
        //Cleanup
         taskDao.delete(task);
    }
//    @Test
//    public void testTaskDaoSaveWithFinancialDetails(){
//        //Given
//        Task task   =  new Task(DESCRIPTION, 30);
//        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));
//        //When
//        taskDao.save(task);
//        int id = task.getId();
//        //Then
//        Assert.assertNotEquals(0, id);
//    }
}
