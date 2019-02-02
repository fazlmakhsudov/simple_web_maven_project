package com.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
            name = "login",
            urlPatterns = "/user/login"
    )
    public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseService.initialize();
        Map<String, String[]> reqParameters = new HashMap<String, String[]>(req.getParameterMap());
        if(reqParameters.isEmpty()){
            req.setAttribute("needLoginForm", "yes");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        if(!reqParameters.containsKey("id")){
           req.setAttribute("loginAnswer","<h2>Id absence at parameters!</h2><bt>");
            req.setAttribute("needLoginForm", "yes");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        String nameId = reqParameters.get("id")[0];
        User user = DatabaseService.getUserByAnyInfo(nameId);
        if(user==null){
            req.setAttribute("loginAnswer","<h2>User with such id is absence, type correctly or register at first!</h2><bt>");
            req.setAttribute("needLoginForm", "yes");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        String password ="";
        if(reqParameters.containsKey("password")){
            password=reqParameters.get("password")[0];
        }
        boolean flag = DatabaseService.login(user.getName(),password);
        if(flag){
            req.setAttribute("loginAnswer","<h2>Loginned successfully!</h2><bt>");
            req.setAttribute("needLoginForm", "no");
        } else{
            req.setAttribute("loginAnswer","<h2>Loginned failed! Wrong password</h2><bt>");
            req.setAttribute("needLoginForm", "yes");
        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        PrintWriter pr = resp.getWriter();
        StringBuilder sb = new StringBuilder();
        User user = DatabaseService.getUserByAnyInfo(name);
        if(user==null){
            req.setAttribute("loginAnswer","<h2>User with such name is absence, type correctly or register at first!</h2><bt>");
            req.setAttribute("needLoginForm", "yes");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        boolean flag =DatabaseService.login(name,password);
        if(flag){
            req.setAttribute("loginAnswer","<h2>Loginned successfully!</h2><bt>");
            req.setAttribute("needLoginForm", "no");
        } else{
            req.setAttribute("loginAnswer","<h2>Loginned failed! Wrong password</h2><bt>");
            req.setAttribute("needLoginForm", "yes");
        }
         req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }
}

