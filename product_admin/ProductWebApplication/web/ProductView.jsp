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
        <%@include file="/WEB-INF/jspf/navbar.jspf" %>
        
        <% ProductCollectionsInterface pdtDAO = new ProductsDatabaseManagement();
            //Product pt = new Product();
            //pt.setProduct_ID(123);
            //pt.setName("roan");
            //pdtDAO.add(pt);

        %>
        <% 
            
            Collection<Product> pdtList = pdtDAO.get();
        
        %>
        <h1>Products</h1>
        <label>Categories</label> 
        <form action="ProductServlet" method="GET">
            <% 
                for (Product pdt : pdtList){
                    String msg = "<input type='submit' name='"+pdt.getCategory()+"Button' + value='"+pdt.getCategory()+"' onclick='submit'>";
                    %>
                    <%=msg%>
                    <%
                }
                
                    String all = "";
                    String category = (String)session.getAttribute("productCategory");
                    if(category != null){
                        all = "<input type='submit' name='allButton' value='all' onclick='submit'>";
                    }
            %>
            
            <%=all%>
     
        </form>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Category</th>
                <th>Price</th>
            </tr>
            <% 
                
                    String tr = "<tr>";
                    String trr = "</tr>";
                    String td = "<td>";
                    String tdd = "</td>";
                    String dat;
                if(category == null || category.equals("all")){
    
                for (Product pdt : pdtList){
                                dat = tr + td + pdt.getProduct_ID() + tdd + td + pdt.getName() + tdd + td + pdt.getDescription() + tdd + td + pdt.getCategory()
                                        + tdd + td + pdt.getPrice() + tdd + trr;
            %>
            <%= dat %>
            <%       
            }
            
                }else{
                    
                     for (Product pdt : pdtList){
                         if(pdt.getCategory().equals(category)){
                             dat = tr + td + pdt.getProduct_ID() + tdd + td + pdt.getName() + tdd + td + pdt.getDescription() + tdd + td + pdt.getCategory()
                                        + tdd + td + pdt.getPrice() + tdd + trr;
                             %>
            <%= dat %>                                                                           
                             <%
                         }
                     }
                } 
                    
                
            %>
            
        </table>
        
    </body>
</html>
