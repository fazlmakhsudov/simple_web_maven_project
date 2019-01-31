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
        pr.print(action+" "+name+"  "+password+"  "+gmail+"\n");
        DatabaseService service = new DatabaseService();
        service.initialize();
        if(action.equals("Login")){
            boolean flag =service.login(name,password);
            if(flag){
                pr.print("\nIt was successfully loginned. Welcome to our page");
            } else {
                pr.print("\nLogin failed. try again!");
              //  req.getRequestDispatcher("index.html").forward(req,resp);
            }
        }
        if(action.equals("Register")){
                boolean flag = service.register(name,password,gmail,inputDate);
            if(flag) {
                pr.print("\nIt was successfully registered. Congratulations!\n");
            }else{
                pr.print("\nRegister failed! Try again! \n");
                //req.getRequestDispatcher("index.html").forward(req,resp);
            }
        }
        //pr.print("crossed Register "+action.equals("Register")+"<br>");
        if(action.equals("Get user")){
            User user = service.getUserByAnyInfo(name+"!:!"+gmail);
            if(user!=null){
                pr.print("We found user:\n"+user.toString());
            }else{
                pr.print("\n<h3>Unfortunately no user with name: "+name+" or gmail: "+gmail+"\n");
            }
        }
    }
}
