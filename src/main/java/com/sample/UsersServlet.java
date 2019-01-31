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
        name = "usersservlet",
        urlPatterns = "/controller"
)
public class UsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gmail = req.getParameter("gmail");
        Date inputDate =null;
        PrintWriter pr = resp.getWriter();
        try {
            inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("date"));
        } catch (Exception e) {

        }
        DatabaseService service = new DatabaseService();
        service.initialize();
        StringBuilder sb = new StringBuilder();
        if(action.equals("Login")){
            boolean flag =service.login(name,password);
            if(flag){
                  sb.append("<h2>It was successfully loginned. Welcome to our page</h2>");
                  sb.append("<br>dear user "+name);
            } else {
                  sb.append("<h2>Login failed. try again!</h2>");
            }
        }
        if(action.equals("Register")){
                boolean flag = service.register(name,password,gmail,inputDate);
            if(flag) {
                 sb.append("<h2>It was successfully registered. Congratulations!</h2>");
                 sb.append("<br><b>Keep this information!</b>");
                 sb.append(service.getUserByAnyInfo(name));
            }else{
                sb.append("<h3>Register failed! Try again!<h3>");
                //req.getRequestDispatcher("index.html").forward(req,resp);
            }
        }
        //pr.print("crossed Register "+action.equals("Register")+"<br>");
        if(action.equals("Get user")){
            String id = req.getParameter("id");
            User user = service.getUserByAnyInfo(name+"!:!"+gmail+"!:!"+id);
            if(user!=null){
                sb.append("<h3>We have found user:<h3>"+user.toString());
            }else{
                sb.append("<h3>Unfortunately no user with name: "+name+" or gmail: "+gmail+"</h3><br>");
            }
        }
        sb.append("<br><br><i><a href=\"index.html\">Return to welcome page</a></i>");
        req.setAttribute("answer", sb.toString());
        req.getRequestDispatcher("result.jsp").forward(req,resp);

    }
}
