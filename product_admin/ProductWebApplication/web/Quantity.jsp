<%-- 
    Document   : Quantity
    Created on : Sep 24, 2015, 9:10:34 PM
    Author     : Jvic
--%>

<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quantity Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navbar.jspf" %>
        <%
          Product pdt = (Product) session.getAttribute("BuyProduct");
          String pdtName = pdt.getName();
        %>
        <form action="CartServlet" method="POST">
        <h2> How many of the item <%=pdtName%> would you like to purchase?<h2/>
            <input type="text" name="ProductQuantityToAdd">
            <input type="submit" name="addToCartButton" value="add to cart">
        </form>
    </body>
</html>
