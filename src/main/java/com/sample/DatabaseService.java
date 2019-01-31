package com.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseService {
    public void initialize(){
        Users users = new Users();
        if(!users.getDatabase().isEmpty()){
            return ;
        }
       Date inputDate = new SimpleDateFormat("dd/MM/yyyy").getDateInstance().getCalendar().getTime();

        Users.addUser("Rustam","1234", "Rustam@gmail.com", inputDate);
        Users.addUser("Ilhom","1234", "*@gmail.com", inputDate);
        Users.addUser("Shirin","1234", "*@gmail.com", inputDate);
        Users.addUser("Karim","1234", "*@gmail.com", inputDate);
       }
    public boolean login (String name, String password){
        if(name==null||!Users.checkUser(name)){
            return false;
        }
        User user = Users.getUser(name);
        if(user.getPassword().equals(password)){
            return true;
        } else return false;
    }
    public boolean register (String name, String password, String gmail, Date date){
        if(Users.checkUser(name)){
            return false;
        }
        boolean flag= Users.addUser(name,password,gmail, date);

        if(flag) return true;
        return false;
    }
    public User getUserByAnyInfo(String param){
        String [] params = param.split("!:!");
        for(String par : params){
            if(par==null||par.trim().equals("")) continue;
            System.out.println("first condition");
            if(par.trim().equals("*name*")||par.trim().equals("**@gmail.com")) continue;
            System.out.println("second condition");
            if (Users.checkUser(par.trim())){
                return Users.getUser(par);
            }
        }
        return null;
    }
}
