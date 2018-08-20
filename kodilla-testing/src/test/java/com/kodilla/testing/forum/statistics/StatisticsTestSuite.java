package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {
    private  static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests finished");
    }

    @Before
    public void beforeEveryTest(){
        testCounter ++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test //Test 1 - basic data
    public void testForumStatistics(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        //HashMap<Integer, Double>temperaturesMap = new HashMap<>();

        //StatisticsProcessing stats = new StatisticsProcessing(statisticsMock);
        List<String>listOfNames = new LinkedList<>();
        listOfNames.add("Adam");
        listOfNames.add("Ben");
        listOfNames.add("Cecilia");
        listOfNames.add("Danny");

        int postsCount = 5;
        int commentsCount = 25;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(25);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(1.25, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(6.25,stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(1,stats.getAvgCommentsPerPost(),0.01);

        //Add 10 tests, combinations
    }
    @Test //Test 2 - numner of Posts = 0
    public void testNoPosts0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
        listOfNames.add("Adam");
        listOfNames.add("Ben");
        listOfNames.add("Cecilia");
        listOfNames.add("Danny");

        int postsCount = 0;
        int commentsCount = 25;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(25);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(1.25, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(6.25,stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(1,stats.getAvgCommentsPerPost(),0.01);

        //Add 10 tests, combinations
    }

}
