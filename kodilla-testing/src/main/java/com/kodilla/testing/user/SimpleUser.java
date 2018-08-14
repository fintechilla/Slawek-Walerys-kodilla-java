package com.kodilla.testing.user;

public class SimpleUser {
    private String username;
    private String realName;

    public SimpleUser(String username, String realName){
        this.username = username;
        this.realName = realName;
    }
    public String getUsername(){
        return this.username;
    }
    public String getRealName(){
        return this.realName;
    }
}
