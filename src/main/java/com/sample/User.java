package com.sample;

import java.util.Date;

public class User {
    private String name;
    private  String password;
    private String gmail;
    private int id;
    private Date date;

    public User(int id, String name, String password, String gmail, Date date) {
        this.name = name;
        this.password = password;
        this.gmail = gmail;
        this.id = id;
        this.date = date;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "\n ID "+id+"\nName: "+name+"\n Gmail: "+gmail+"\nDate of registration: "+date.toString()+"</h2>";
    }
}
