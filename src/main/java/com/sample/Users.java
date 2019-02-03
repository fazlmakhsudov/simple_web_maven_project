package com.sample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Users {
    private static Map<Integer, User> database = new HashMap<>();
    private static int ids = 1;

    public static Map<Integer, User> getDatabase() {
        return database;
    }

    public static boolean addUser(String name, String password, String email, Date date) {

        User newUser = new User(ids, name, password, email, date);
        if (database.containsKey(ids)) return false;
        database.put(ids, newUser);
        ids++;
        return true;
    }


    public static User getUserByName(String name) {
        for (User user : database.values()) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserByEmail(String email) {
        for (User user : database.values()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserById(int id) {
        if (database.containsKey(id)) {
            return database.get(id);
        }
        return null;
    }
}
