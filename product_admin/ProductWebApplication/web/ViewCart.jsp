<%-- 
    Document   : ViewCart
    Created on : Sep 21, 2015, 2:29:44 PM
    Author     : Jvic
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navbar.jspf" %>
        <h1>Your Cart</h1>
        <form action="CheckoutServlet" method="POST">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>

                <%                List<OrderItem> ordList = (List<OrderItem>) session.getAttribute("Cart");
                    List<Product> itemList = (List<Product>) session.getAttribute("itemCart");
                    System.out.println(itemList);
                    String msg;
                    String tr = "<tr>";
                    String trr = "</tr>";
                    String td = "<td>";
                    String tdd = "</td>";
                    Double totes;
                    int i = 0;
                    int j;
                    for (; i < itemList.size(); i++) {
                        Product pdt = itemList.get(i);
                        OrderItem ord = ordList.get(i);
                        totes = pdt.getPrice() * ord.getQuantity_purchased();;
                        msg = tr + td + pdt.getName() + tdd + td + pdt.getPrice() + tdd + td + ord.getQuantity_purchased() + tdd + td + totes + tdd;

                %>
                <%=msg%>
                <%
                    }
                %>

            </table>
            <br>
            <input type="submit" name="CheckoutButton" value="Checkout">
        </form>
    </body>
</html>
