package com.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(
            name = "registration",
            urlPatterns = "/user/registration"
    )
    public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseService.initialize();
        req.getRequestDispatcher("/registration.jsp").forward(req,resp);
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Date inputDate =null;
        PrintWriter pr = resp.getWriter();
        try {
            inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("date"));
        } catch (Exception e) {

        }
        User user = DatabaseService.getUserByName(name);
        if(user!=null){
            req.setAttribute("needRegistrationForm", "yes");
            req.setAttribute("registrationAnswer","<h2>Registration is failed. Login has already been occupied!</h2><bt>");
            req.getRequestDispatcher("/registration.jsp").forward(req,resp);
            return;
        }
        boolean flag =DatabaseService.register(name,password,email,inputDate);
        if(flag){
            req.setAttribute("registrationAnswer","<h2>Registration is successful!</h2><bt>");
        } else{
            req.setAttribute("needRegistrationForm", "yes");
            req.setAttribute("registrationAnswer","<h2>Registration failed! Fill form correctly</h2><bt>");
        }
         req.getRequestDispatcher("/registration.jsp").forward(req,resp);
    }
}

