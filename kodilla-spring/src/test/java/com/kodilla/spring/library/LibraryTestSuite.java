package com.kodilla.spring.library;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class LibraryTestSuite {

    @Test
    public void saveToDb() {
        //Given
        ApplicationContext context =  new AnnotationConfigApplicationContext("com.kodilla.spring");
        Library library = context.getBean(Library.class);
        //When
        library.saveToDb();
        //Then
        //do nothing
    }

    @Test
    public void loadFromDb() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Library library  = context.getBean(Library.class);
        //When
        library.loadFromDb();
        //Then

    }
    @Test
    public void testContext(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        //When and Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}