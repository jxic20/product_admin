<%-- 
    Document   : ValidationFailPage
    Created on : Sep 24, 2015, 11:52:36 AM
    Author     : Jvic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page isErrorPage="true"%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation Fail Page</title>
    </head>
    <body>        
        <h1>Eeh-eeh you typed it wrong!</h1>       
        <p><%=request.getAttribute("javax.servlet.error.message")%></p>      
        <a href="javascript:history.back()">Back</a>   
    </body>   
</html>