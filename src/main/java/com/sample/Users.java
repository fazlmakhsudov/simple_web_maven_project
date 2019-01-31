package com.sample;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Users {
    private static Map<String, User> database=new HashMap<String, User>();
    private static int ids = 0;

    public Map<String, User> getDatabase() {
        return database;
    }

    public static boolean addUser(String name, String password, String gmail, Date date){
        boolean flag =name==null||name.equals("")||name.equals("*name*")||password==null||password=="";
        if(flag) return false;
        if(gmail.equals("")||gmail==null||gmail.equals("*@gmail.com")) gmail= name+ids+"@gmail.com";
        if(date ==null||date.toString()=="") date = Calendar.getInstance().getTime();
        String key = ids+name+password+gmail;
        key = key.toLowerCase();
        User newUser = new User(ids,name,password,gmail,date);
        if(database.containsKey(key)) return false;
        database.put(key, newUser);
        ids++;
        return true;
    }
    public static boolean checkUser(String param){
        param=param.toLowerCase();
        for(String s : database.keySet()){
            if(s.indexOf(param)!=-1){
                return true;
            }
        }
        return false;
    }
    public static User getUser(String param){
        param=param.toLowerCase();
        for(String s : database.keySet()){
            if(s.indexOf(param)!=-1){
                return database.get(s);
            }
        }
        return null;
    }
}
