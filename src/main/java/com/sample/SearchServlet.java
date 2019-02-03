package com.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(
        name = "search",
        urlPatterns = "/user"
)
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseService.initialize();
        HashMap<String, String[]> params = new HashMap<>(req.getParameterMap());
        if (params.containsKey("id")) {
            String id_ = params.get("id")[0];
            int id = Integer.parseInt(id_);
            User user = DatabaseService.getUserById(id);
            System.out.println(user+"**Id **"+id);
            if (user != null) {
                req.setAttribute("searchAnswer", "<h2>" + user + "</h2><br>");
                req.getRequestDispatcher("/search.jsp").forward(req, resp);
                return;
            }
        }
        if (params.containsKey("email")) {
            String email = params.get("email")[0];
            User user = DatabaseService.getUserByEmail(email);
            System.out.println(user+"***"+email);
            if (user != null) {
                req.setAttribute("searchAnswer", "<h2>" + user + "</h2><br>");
                req.getRequestDispatcher("/search.jsp").forward(req, resp);
                return;
            }
        }


    }


}

