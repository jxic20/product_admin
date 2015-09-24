<%-- 
    Document   : NewCustomer
    Created on : Sep 8, 2015, 3:14:50 PM
    Author     : Jvic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Creation</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navbar.jspf" %>
        <h1>Create an Account</h1>
        <form method="POST" action="AccountServlet">
            <p>Account Details</p>
            
            <label for="UserCode">User Name</label>
            <input type="text" name="UserCode">
            <br>
            <label for="Name">Name</label>
            <input type="text" name="Name">
            <br>
            <label for="Email">Email</label>
            <input type="text" name="Email">
            <br>
            <label for="Address">Address</label>
            <input type="text" name="Address">
            <br>
            <label for="Credit">Credit Card</label>
            <input type="text" name="Credit">
            <br>
            <label for="Password">Password</label>
            <input type="text" name="Password">
            <br>
            <br>
            <input type="submit" name="CreateButton" value="Create Account">
            
        <form/>
        
    </body>
</html>
