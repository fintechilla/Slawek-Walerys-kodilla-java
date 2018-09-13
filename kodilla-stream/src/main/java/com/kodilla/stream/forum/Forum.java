package com.kodilla.stream.forumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
//    private List<ForumUser> forumUserList;

    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(Integer numberOfForumUsers) {

        for(int i = 0; i < numberOfForumUsers; i++){
            char gender;
            if(i % 2 == 0){
                gender = 'F';
            } else {
                gender = 'M';
            }
        forumUserList.add(new ForumUser(1 + i, "J" + i, gender, LocalDate.of(1960 + i * 5, 01, 1 + i), i));
        }
    }

    public List<ForumUser> getForumUserList() {
        return new ArrayList<> (forumUserList);
    }
}
