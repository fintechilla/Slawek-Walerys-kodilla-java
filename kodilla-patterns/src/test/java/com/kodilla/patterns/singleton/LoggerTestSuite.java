package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    private static Logger logger ;
    @Test
    public void testLastLog(){
        //Given
        logger.getInstance().log("first");
        logger.getInstance().log("second");
        //When
        String logName = logger.getInstance().getLastLog();
        System.out.println("Last log: " + logName);
        //Then
        Assert.assertEquals("second", logName);
    }
}
