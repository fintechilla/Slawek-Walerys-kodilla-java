package com.kodilla.testing.forum.statistics;

public class StatisticsProcessing {
    //private Statistics statistics;
    private int usersCount;
    private double postsCount;
    private double commentsCount;
    private double avgPostsCount;
    private double avgCommentsCount;
    private double avgCommentsPerPost;


//    public StatisticsProcessing(Statistics statistics) {
//        this.statistics = statistics;
//    }

//    public List<String> usersNames(){  //list of users names
//
//        List<String>listOfNames = null;
//        for(String userName:statistics.usersNames()){
//            listOfNames.add(userName);
//        }
//        return listOfNames;
//    }

//    public int postsCount(){    //total quantity of forum posts
//        int postsQuantity = statistics.postsCount();
//        return postsQuantity;
//    }
//
//    public int commentsCount(){ //total quantity of forum comments
//        int commentsQuantity = statistics.commentsCount();
//        return commentsQuantity;
//    }
    public void calculateAdvStatistics(Statistics statistics){
        //calculate no of users
        this.usersCount = statistics.usersNames().size();
        //other
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        //Averages, test for division by 0
        if (usersCount != 0){
            this.avgPostsCount = postsCount/usersCount;
            this.avgCommentsCount = commentsCount/usersCount;
        }

        if(postsCount != 0){
            this.avgCommentsPerPost = commentsCount/postsCount;
        }

    }
    public void showStatistics(){
        System.out.println("Showing stats...");
        System.out.println("avgPostsCount: " + this.avgPostsCount);
        System.out.println("avgCommentsCount: " + this.avgCommentsCount);
        System.out.println("avgCommentsPerPost: " + this.avgCommentsPerPost);
        System.out.println("End of stats...");
    }

    public int getUsersCount() {
        return usersCount;
    }

    public double getPostsCount() {
        return postsCount;
    }

    public double getCommentsCount() {
        return commentsCount;
    }

    public double getAvgPostsCount() {
        return avgPostsCount;
    }

    public double getAvgCommentsCount() {
        return avgCommentsCount;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
