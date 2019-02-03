<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Search page
</h1>
<%
Object searchForm= request.getAttribute("needSearchForm");
if(searchForm!=null){
    out.println("<form method=\"post\" action=\"search\"><br>");
    out.println("<h4>Name</h4> <input type=\"text\"  name=\"name\" value =\"\" align=\"center\" size=\"15\">");
    out.println("<br><h4>Email</h4> <input type=\"text\"  name=\"email\" value =\"\" align=\"center\">");
    out.println("<br><input type=\"submit\"></form>");
}
%>
<%
String answer = (String) request.getAttribute("searchAnswer");
if(answer!=null)
out.println(answer);
%>


