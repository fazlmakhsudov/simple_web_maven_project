package com.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseService {
    public static void initialize(){
        if(!Users.getDatabase().isEmpty()){
            return ;
        }
       Date inputDate = new SimpleDateFormat("dd/MM/yyyy").getDateInstance().getCalendar().getTime();

        Users.addUser("Rustam","1234", "Rustam@gmail.com", inputDate);
        Users.addUser("Ilhom","1234", "*@gmail.com", inputDate);
        Users.addUser("Shirin","1234", "*@gmail.com", inputDate);
        Users.addUser("Karim","1234", "*@gmail.com", inputDate);
       }
    public static boolean login (String name, String password){
        if(name==null||!Users.checkUser(name)){
            return false;
        }
        User user = Users.getUser(name);
        if(password!=null&&user.getPassword().equals(password)){
            return true;
        } else return false;
    }
    public static boolean register (String name, String password, String gmail, Date date){
        if(Users.checkUser(name)){
            return false;
        }
        boolean flag= Users.addUser(name,password,gmail, date);

        if(flag) return true;
        return false;
    }
    public static User getUserByAnyInfo(String param){
        String [] params = param.split("!:!");
        for(String par : params){
            if(par==null||par.trim().equals("")) continue;
            if(par.trim().equals("*name*")||par.trim().equals("**@gmail.com")) continue;
            if (Users.checkUser(par.trim())){
                return Users.getUser(par);
            }
        }
        return null;
    }
}
