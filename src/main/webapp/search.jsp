<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Search page
</h1>

<%
Object answer = request.getAttribute("searchAnswer");
if(answer!=null)
out.println((String) answer);
%>


