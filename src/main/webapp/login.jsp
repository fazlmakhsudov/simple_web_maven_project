<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Login page
</h1>
<%
String loginForm= (String) request.getAttribute("needLoginForm");
if(loginForm.equals("yes")){
StringBuilder sb =new StringBuilder();
    out.println("<form method=\"post\" action=\"login\"><br>");
    out.println("<h4>Name</h4> <input type=\"text\"  name=\"name\" value =\"*name*\" align=\"center\" size=\"15\">");
    out.println("<br><h4>Password</h4> <input type=\"password\"  name=\"password\" value =\"password\" align=\"center\">");
    out.println("<br><input type=\"submit\"></form>");
}
%>
<%
String answer = (String) request.getAttribute("loginAnswer");
if(answer!=null)
out.println(answer);
%>


