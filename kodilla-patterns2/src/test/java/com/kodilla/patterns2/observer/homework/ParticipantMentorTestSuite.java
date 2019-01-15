package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParticipantMentorTestSuite {
    @Test
    public void testUpdate(){
        //Given
        Participant participant1= new ParticipantOne();
        Participant participant2 = new ParticipantTwo();
        Mentor mentor1 = new Mentor("Pawel Pluta");
        Mentor mentor2= new Mentor("Ivone Escobar");
        Mentor mentor3 = new Mentor("Jessie Pinkman");
        participant1.registerObserver(mentor1);
        participant2.registerObserver(mentor2);
        participant1.registerObserver(mentor3);
        participant2.registerObserver(mentor3);
        //When
        participant1.addPost("Hi everyone! Could you help me with for loop?");
        participant1.addPost("Better try to use while loop in this case.");
        participant2.addPost("Help pls, my MySql db doesn't want to work :(");
        participant1.addPost("Why whilee? Is it better?");
        participant2.addPost("When I try to log in I got 'credentials' message.");
        //Then
        assertEquals(3, mentor1.getUpdateCount());
        assertEquals(2, mentor2.getUpdateCount());
        assertEquals(5, mentor3.getUpdateCount());

    }
}
