package com.sample;

import java.util.Date;

public class User {
    private String name;
    private  String password;
    private String gmail;
    private String id;
    private Date date;

    public User(String id, String name, String password, String gmail, Date date) {
        this.name = name;
        this.password = password;
        this.gmail = gmail;
        this.id = id;
        this.date = date;
    }
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "<br><h3>ID: "+id+"<br>Name: "+name+"<br> Gmail: "+gmail+
                "<br>Date of registration: "+date.toString()+"</h3>";
    }
}
