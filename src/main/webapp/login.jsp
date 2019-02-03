<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Login page
</h1>
<%
Object loginForm= request.getAttribute("needLoginForm");
if(loginForm==null || loginForm.equals("yes")){
    out.println("<form method=\"post\" action=\"login\"><br>");
    out.println("<h4>Name</h4> <input type=\"text\"  name=\"name\" value =\"*name*\" align=\"center\" size=\"15\">");
    out.println("<br><h4>Password</h4> <input type=\"password\"  name=\"password\"  align=\"center\">");
    out.println("<br><input type=\"submit\"></form>");
}
%>
<%
String answer = (String) request.getAttribute("loginAnswer");
if(answer!=null)
out.println(answer);
%>


