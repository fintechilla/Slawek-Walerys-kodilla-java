package com.kodilla.stream;

import com.kodilla.stream.forum.Forum;
import com.kodilla.stream.forum.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain7_3 {
    public static void main(String[] args){
        //ForumUser forumUser1 = new ForumUser(1, "John", 'M', LocalDate.of(2001, 01, 01));
        List<ForumUser>forumUserList = new ArrayList<>();

        /* forumUserList.add(forumUser1); */
        Forum forum = new Forum(20);
        forumUserList = forum.getForumUserList();
        Map<Integer, ForumUser> theResultMapOfForumUserList = forumUserList.stream()
                .filter(s->s.getGender()=='M')
                .filter(s-> Period.between(s.getBirthDay(), LocalDate.now()).getYears() > 20)
                .filter(s->s.getPostsQuantity()>1)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        System.out.println("# elements: " + forumUserList.size());
        theResultMapOfForumUserList.entrySet().stream()
                .map(m->m.toString())
//                .map(entry -> "entry: " + entry.getKey()
//                        + " name: " + entry.getValue().getName()
//                        + ", gender: " + entry.getValue().getGender()
//                        + ", Date of birth: " + entry.getValue().getBirthDay()
//                        + ", postsQuantity: " + entry.getValue().getPostsQuantity())
                .forEach(System.out::println);
    }

}
