 <%@ page import ="java.util.*" %>
 <!DOCTYPE html>
 <html>
 <body>
 <center>
 <h1>
     Registration page
 </h1>
 <%
 String loginForm= (String) request.getAttribute("needRegistrationForm");
 if(loginForm!=null){
 StringBuilder sb =new StringBuilder();
     out.println("<form method=\"post\" action=\"registration\"><br>");
     out.println("<h4>Name</h4> <input type=\"text\"  name=\"name\" value =\"*name*\" align=\"center\" size=\"15\">");
     out.println("<br><h4>Password</h4> <input type=\"password\"  name=\"password\" value =\"password\" align=\"center\">");
     out.println("<br><h4>Gmail</h4> <input type=\"text\"  name=\"gmail\" value =\"*@gmail.com\">");
     out.println("<br><h4>Date</h4> <input type=\"date\"  name=\"date\">");
     out.println("<br><input type=\"submit\"></form>");
 }
 %>
 <%
 String answer = (String) request.getAttribute("registrationAnswer");
 if(answer!=null)
 out.println(answer);
 %>