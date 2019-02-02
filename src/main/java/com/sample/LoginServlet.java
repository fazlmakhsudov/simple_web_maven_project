package com.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
            name = "login",
            urlPatterns = "/user/login"
    )
    public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseService.initialize();
        req.setAttribute("needLoginForm", "yes");
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = DatabaseService.getUserByAnyInfo(name);
        if(user==null){
            req.setAttribute("needLoginForm", "yes");
            req.setAttribute("loginAnswer","<h2>User with such name is absence, type correctly or register at first!</h2><bt>");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        boolean flag =DatabaseService.login(name,password);
        if(flag){
            req.setAttribute("loginAnswer","<h2>Loginned successfully!</h2><bt>");
        } else{
            req.setAttribute("loginAnswer","<h2>Loginned failed! Password is wrong</h2><bt>");
        }
         req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }
}

