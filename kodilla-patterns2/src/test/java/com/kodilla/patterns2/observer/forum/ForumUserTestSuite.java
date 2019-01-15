package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void testUpdate(){
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser forumUser1 = new ForumUser("John Smith");
        ForumUser forumUser2 = new ForumUser("Ivone Escobar");
        ForumUser forumUser3 = new ForumUser("Jessie Pinkman");
        javaHelpForum.registerObserver(forumUser1);
        javaToolsForum.registerObserver(forumUser2);
        javaHelpForum.registerObserver(forumUser3);
        javaToolsForum.registerObserver(forumUser3);
        //When
        javaHelpForum.addPost("Hi everyone! Could you help me with for loop?");
        javaHelpForum.addPost("Better try to use while loop in this case.");
        javaToolsForum.addPost("Help pls, my MySql db doesn't want to work :(");
        javaHelpForum.addPost("Why whilee? Is it better?");
        javaToolsForum.addPost("When I try to log in I got 'credentials' message.");
        //Then
        assertEquals(3, forumUser1.getUpdateCount());
        assertEquals(2, forumUser2.getUpdateCount());
        assertEquals(5, forumUser3.getUpdateCount());

    }
}
