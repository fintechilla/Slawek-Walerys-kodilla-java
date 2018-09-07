package com.kodilla.stream.forumUser;

import java.time.LocalDate;

public class ForumUser {
    private final int id;
    private final String name;
    private final char gender;
    private final LocalDate birthDay;
    private int postsQuantity = 0;

    public ForumUser(final int id, final String name, final char gender,
                     final LocalDate birthDay, int postsQuantity) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.postsQuantity = postsQuantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

}
