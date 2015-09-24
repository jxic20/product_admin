<%-- 
    Document   : Login
    Created on : Sep 11, 2015, 1:41:28 PM
    Author     : Jvic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navbar.jspf" %>
        <h1>Log In</h1>
        <p>Please log in to continue</p>
        <form method="POST" action="LoginServlet">
            <label for="logName">User Name</label>
            <input type="text" name="logName">
            
            <br>
            
            <label for="logPass">Password</label>
            <input type="password" name="logPass">
            
            <br>
            
            <input type="submit" name="logSubmit" value="Login">
            
            <br>
            
            <p>If you don't have an account then you can <a href='http://localhost:8080/shop/NewCustomer.jsp'>create one</a>.</p>
            
        </form>
    </body>
</html>
