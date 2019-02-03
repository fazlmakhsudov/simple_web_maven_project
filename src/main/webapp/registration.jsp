 <%@ page import ="java.util.*" %>
 <!DOCTYPE html>
 <html>
 <body>
 <center>
 <h1>
     Registration page
 </h1>
 <%
 Object registrationForm= request.getAttribute("needRegistrationForm");
 if(registrationForm==null|| registrationForm.equals("yes")){
 StringBuilder sb =new StringBuilder();
     out.println("<form method=\"post\" action=\"registration\"><br>");
     out.println("<h4>Name</h4> <input type=\"text\"  name=\"name\" value =\"*name*\" align=\"center\" size=\"15\">");
     out.println("<br><h4>Password</h4> <input type=\"password\"  name=\"password\" value =\"password\" align=\"center\">");
     out.println("<br><h4>Email</h4> <input type=\"text\"  name=\"email\" value =\"*@email.com\">");
     out.println("<br><h4>Date</h4> <input type=\"date\"  name=\"date\">");
     out.println("<br><input type=\"submit\"></form>");
 }
 %>
 <%
 String answer = (String) request.getAttribute("registrationAnswer");
 if(answer!=null)
 out.println(answer);
 %>
