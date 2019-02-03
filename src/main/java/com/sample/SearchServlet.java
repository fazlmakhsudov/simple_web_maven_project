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
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        User user =null;
        if(id!=null){
           user = DatabaseService.getUserByID(id);
        }
        if (user != null) {
            req.setAttribute("searchAnswer", "<h2>" + user + "</h2><br>");
            req.getRequestDispatcher("/search.jsp").forward(req, resp);
            return;
        }
        if(email!=null){
            user = DatabaseService.getUserByEmail(email);
        }
        if (user != null) {
            req.setAttribute("searchAnswer", "<h2>" + user + "</h2><br>");
            req.getRequestDispatcher("/search.jsp").forward(req, resp);
            return;
        }
    }


}

