package com.kodilla.stream.forum2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ForumUser {
    private final String userName;
    private final String realName;
    private final String location;
    private final Set<ForumUser>friends =  new HashSet<>();


    public ForumUser(String userName, String realName, String location) {
        this.userName = userName;
        this.realName = realName;
        this.location = location;
    }
    public void addFriend(ForumUser forumUser){
        friends.add(forumUser);
    }
    public boolean removeFriend(ForumUser forumUser){
        return friends.remove(forumUser);
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        return getUserName() != null ? getUserName().equals(forumUser.getUserName()) : forumUser.getUserName() == null;
    }

    @Override
    public int hashCode() {
        return getUserName() != null ? getUserName().hashCode() : 0;
    }

    public Set<String>getLocationsOfFriends(){
        return friends.stream()
                .map(x->x.getLocation())
                .collect(Collectors.toSet());
    }
    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()
                .flatMap(user -> user.getFriends().stream())
                .filter(user -> user != this)
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }
    public List<String> getLocationsList(ForumUser forumUser){
        return forumUser.getFriends().stream().flatMap(x->x.getFriends().stream())
                .map(x->x.getLocation())
                .collect(Collectors.toList());
    }
}
