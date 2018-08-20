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
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(1.25, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(6.25,stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(5,stats.getAvgCommentsPerPost(),0.01);

        //Add 10 tests, combinations
    }
    @Test //Test 2 - number of Posts = 0
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
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(0, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(6.25,stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(0,stats.getAvgCommentsPerPost(),0.01);

        //Add 10 tests, combinations
    }

    @Test //Test 3 - number of Posts = 1000
    public void testPosts1000(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
        listOfNames.add("Adam");
        listOfNames.add("Ben");
        listOfNames.add("Cecilia");
        listOfNames.add("Danny");

        int postsCount = 1000;
        int commentsCount = 25;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(250, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(6.25,stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(.025,stats.getAvgCommentsPerPost(),0.01);

    }
    @Test //Test 4 - number of Comments = 0
    public void testComments0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
        listOfNames.add("Adam");
        listOfNames.add("Ben");
        listOfNames.add("Cecilia");
        listOfNames.add("Danny");

        int postsCount = 1000;
        int commentsCount = 0;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(250, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(0,stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(0,stats.getAvgCommentsPerPost(),0.01);

    }
    @Test //Test 5 - number of Comments == number of Posts
    public void testCommentsEqualsPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
        listOfNames.add("Adam");
        listOfNames.add("Ben");
        listOfNames.add("Cecilia");
        listOfNames.add("Danny");

        int postsCount = 1000;
        int commentsCount = 1000;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(250, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(250,stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(1.0,stats.getAvgCommentsPerPost(),0.01);

    }
    @Test //Test 6 - number of Comments <= number of Posts
    public void testCommentsLTPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
        listOfNames.add("Adam");
        listOfNames.add("Ben");
        listOfNames.add("Cecilia");
        listOfNames.add("Danny");

        int postsCount = 1000;
        int commentsCount = 500;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(250, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(125, stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(0.5, stats.getAvgCommentsPerPost(),0.01);
    }
    @Test //Test 7 - number of Comments >=number of Posts
    public void testCommentsGTPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
        listOfNames.add("Adam");
        listOfNames.add("Ben");
        listOfNames.add("Cecilia");
        listOfNames.add("Danny");

        int postsCount = 1000;
        int commentsCount = 2000;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(250, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(500, stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(2, stats.getAvgCommentsPerPost(),0.01);
    }
    @Test //Test 8 - number of forumUsers = 0
    public void testUsers0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
//        listOfNames.add("Adam");
//        listOfNames.add("Ben");
//        listOfNames.add("Cecilia");
//        listOfNames.add("Danny");

        int postsCount = 1000;
        int commentsCount = 2000;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(0, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(0, stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(2, stats.getAvgCommentsPerPost(),0.01);
    }
    @Test //Test 9 - number of forumUsers = 100
    public void testUsers100(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
        for(int i = 0; i < 100; i++){
            listOfNames.add("a" + i);
        }
//        listOfNames.add("Adam");
//        listOfNames.add("Ben");
//        listOfNames.add("Cecilia");
//        listOfNames.add("Danny");

        int postsCount = 1000;
        int commentsCount = 2000;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(10, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(20, stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(2, stats.getAvgCommentsPerPost(),0.01);
    }
    @Test //Test 10 - number of forumUsers = 100
    public void testUsers0Posts0Comments0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String>listOfNames = new LinkedList<>();
//        for(int i = 0; i < 100; i++){
//            listOfNames.add("a" + i);
//        }
//        listOfNames.add("Adam");
//        listOfNames.add("Ben");
//        listOfNames.add("Cecilia");
//        listOfNames.add("Danny");

        int postsCount = 0;
        int commentsCount = 0;

        StatisticsProcessing stats = new StatisticsProcessing();

        //When
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOfNames);
        stats.calculateAdvStatistics(statisticsMock);

        //Then add 3 Asserts
        Assert.assertEquals(0, stats.getAvgPostsCount(), .01);
        Assert.assertEquals(0, stats.getAvgCommentsCount(), 0.01);
        Assert.assertEquals(0, stats.getAvgCommentsPerPost(),0.01);
    }
}
