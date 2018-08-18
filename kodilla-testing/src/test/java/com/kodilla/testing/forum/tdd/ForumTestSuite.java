package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

//Test suite for classes of Forum
public class ForumTestSuite {
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

    @After
    public void afterEveryTest(){
        System.out.println("End of test #" + testCounter);
    }

    @Test //Test1 - add a post, is no of posts increased by 1?
    public void testAddPost(){
        //Given
        //System.out.println("Test1 - add a post, is no of posts increased by 1?");
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

        //When
        forumUser.addPost("mrsmith", "Hello everyone, this is my first contribution here!");

        //Then
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test //Test 2 - add a comment, is number of comments increased by 1?
    public void testAddComment(){
        //Given
        System.out.println("Test 2 - add a comment, is no of comments increased by 1?");
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone" + "This is my first contribution here", "mrsmith");

        //When
        forumUser.addComment(thePost, "mrsmith", "Thank you for all good words");

        //Then
        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test //Test 3 - is post taken from class ForumUser the same as post which was inserted into the class
    public void testGetPost(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone" + "this is my first contribution here","mrsmith" );
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        ForumPost retrievedPost;
        retrievedPost = forumUser.getPost(0);

        //Then
        Assert.assertEquals(thePost,retrievedPost);
    }

    @Test //Test 4 - is a comment got from class ForumUser the same as the comment inserted
    public void testGetComment(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "Thank yor for all good words", "mrsmith");
        forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

        //When
        ForumComment retrievedComment = forumUser.getComment(0);

        //Then
        Assert.assertEquals(theComment, retrievedComment);
    }

    @Test //Test 5 - will remove a non-existing post give false
    public  void testRemovePostNotExisting(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone" + "this is my first contribution here!", "mrsmith");

        //When
        boolean result = forumUser.removePost(thePost);

        //Then
        Assert.assertFalse(result);
    }

    @Test //Test 6 - will remove a non-existing comment give false?
    public void testRemoveCommentNotExisting(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone" + "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "Thank yor for all good words", "mrsmith");

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assert.assertFalse(result);
    }

    @Test //Test 7 - verify whether choosing a post from a class was a success
    public void testRemovePost(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone" + "this is my first contribution here!", "mrsmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        boolean result = forumUser.removePost(thePost);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0,forumUser.getPostsQuantity());
    }

    @Test //Test 8 - verify whether removing a comment from a class was a success
    public void testRemoveComment(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone" + "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "Thank yor for all good words", "mrsmith");
        forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0,forumUser.getCommentsQuantity());
    }
}
