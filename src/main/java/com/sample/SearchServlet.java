package com.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
            name = "search",
            urlPatterns = "/user"
    )
    public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseService.initialize();
        req.getRequestDispatcher("/search.jsp").forward(req,resp);
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        User user = DatabaseService.getUserByName(name);
        if(user!=null){
            req.setAttribute("searchAnswer","<h2>"+user+"</h2><br>");
            req.getRequestDispatcher("/search.jsp").forward(req,resp);
            return;
        }
        user = DatabaseService.getUserByEmail(email);
        if(user!=null){
            req.setAttribute("searchAnswer","<h2>"+user+"</h2><br>");
            req.getRequestDispatcher("/search.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("needSearchForm","yes");
        req.getRequestDispatcher("/search.jsp").forward(req,resp);
    }
}

