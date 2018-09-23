package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User john = new Millenials("John");
        User mary = new YGeneration("Mary");
        User eryn = new ZGeneration("Eryn");
        //When and Then
        Assert.assertEquals("[SnapchatPublisher]", john.sharePost());
        Assert.assertEquals("[FacebookPublisher]", mary.sharePost());
        Assert.assertEquals("[TwitterPublisher]", eryn.sharePost());
    }
    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User john = new Millenials("John");
        User mary = new YGeneration("Mary");
        User eryn = new ZGeneration("Eryn");
        //When
        john.setSocialPublisher(new FacebookPublisher());
        //Then
        Assert.assertEquals("[FacebookPublisher]", john.sharePost());
        Assert.assertEquals("[FacebookPublisher]", mary.sharePost());
        Assert.assertEquals("[TwitterPublisher]", eryn.sharePost());
    }
}
