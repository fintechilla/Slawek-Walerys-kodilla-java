package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testRead() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        System.out.println("Board size: " + board.getInProgressList().getTasks().size());
        TaskList toDo = (TaskList) context.getBean("toDo");
        TaskList inProgress = (TaskList) context.getBean("inProgress");
        TaskList done = (TaskList) context.getBean("done");
        //When & Then
        toDo.add("one");
        toDo.add("two");
        toDo.add("three");
        inProgress.add("four");
        inProgress.add("five");
        inProgress.add("six");
        done.add("seven");
        done.add("eight");
        done.add("nine");
//      Then
        Assert.assertEquals(0, board.getInProgressList().getTasks().size());
        Assert.assertEquals(3, inProgress.getTasks().size());
        Assert.assertEquals(3, toDo.getTasks().size());
        Assert.assertTrue(toDo.getTasks().contains("one"));
        Assert.assertTrue(toDo.getTasks().contains("two"));
        Assert.assertTrue(toDo.getTasks().contains("three"));
    }
}
