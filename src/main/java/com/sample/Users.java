package com.sample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Users {
    private static Map<String, User> database = new HashMap<String, User>();
    private static int ids = 0;

    public static Map<String, User> getDatabase() {
        return database;
    }

    public static boolean addUser(String name, String password, String email, Date date) {
        String key = name + ids;
        key = key.toLowerCase();
        User newUser = new User(name + ids, name, password, email, date);
        if (database.containsKey(key)) return false;
        database.put(key, newUser);
        ids++;
        return true;
    }

    public static boolean checkUser(String param) {
        param = param.toLowerCase();
        for (String s : database.keySet()) {
            if (s.indexOf(param) != -1) {
                return true;
            }
        }
        return false;
    }

    public static User getUserByName(String name) {
        name = name.toLowerCase();
        for (String s : database.keySet()) {
            if (s.indexOf(name) != -1) {
                return database.get(s);
            }
        }
        return null;
    }

    public static User getUserByEmail(String email) {
        email = email.toLowerCase();
        for (String name : database.keySet()) {
            if (database.get(name).getEmail().indexOf(email) != -1) {
                return database.get(name);
            }
        }
        return null;
    }
}
