<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Login page
</h1>
 <form method="post" action="controller">
        <br>
        <h4>Name</h4> <input type="text"  name="name" value ="*name*" align="center" size="15">
        <br>
        <h4>Password</h4> <input type="password"  name="password" value ="password" align="center">
        <br>
         <input type="hidden" name="action" value="Login">
        <input type="submit">
 </form>

