package com.bequite.rathind.datingapp;

public class UserDetails {
    private String username;
    private String city_name;
    private String avatar;

    public String getUsername(){return username;}
    public String getCityname(){return city_name;}
    public String getAvatar(){return avatar;}


    public UserDetails(String username, String city_name, String avatar){
        this.username= username;
        this.city_name=city_name;
        this.avatar= avatar;
    }
}
