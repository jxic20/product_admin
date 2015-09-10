<%-- 
    Document   : ProductView
    Created on : Sep 11, 2015, 3:55:22 AM
    Author     : Jvic
--%>

<%@page import="dao.*" import="domain.*" import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Viewer</title>
    </head>
    <body>
        
        <% ProductCollectionsInterface pdtDAO = new ProductsDatabaseManagement();
            //Product pt = new Product();
            //pt.setProduct_ID(123);
            //pt.setName("roan");
            //pdtDAO.add(pt);

        %>
        <% Collection<Product> pdtList = pdtDAO.get();%>
        <h1>Products</h1>
        <label>Categories</label>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
            <% for (Product pdt : pdtList){%>
            <tr>
                <td><%= pdt.getProduct_ID()%></td>
                <td><%= pdt.getName()%></td>
            </tr>
            
            <% } %>
            
        </table>
        
    </body>
</html>
