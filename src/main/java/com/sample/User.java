package com.sample;

import java.util.Date;

public class User {
    private String name;
    private  String password;
    private String email;
    private String id;
    private Date date;

    public User(String id, String name, String password, String email, Date date) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.id = id;
        this.date = date;
    }
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "<br><h3>ID: "+id+"<br>Name: "+name+"<br> Email: "+ email +
                "<br>Date of registration: "+date.toString()+"</h3>";
    }
}
