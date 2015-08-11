/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Jvic
 */
public class Products_database_management implements Product_data{
    String database_URL = "jdbc:h2:tcp://localhost/project;IFEXISTS=TRUE";

    public Products_database_management() {
    }
    public Products_database_management(String dt) {//to be continued
    }
    
    @Override
    public void add(Product pdt){
            String sql = "merge into PRODUCT (product_id, name, description, category, price, stock_quantity)"
                    + "values (?,?,?,?,?,?)";
            try(
                Connection dbCon= JdbcConnection.getConnection(database_URL); 
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ){
            stmt.setInt(1, pdt.getProduct_ID());
            stmt.setString(2, pdt.getName());
            stmt.setString(3, pdt.getDescription());
            stmt.setString(4, pdt.getCategory());
            stmt.setDouble(5, pdt.getPrice());
            stmt.setInt(6, pdt.getStock_quantity());

            stmt.executeUpdate();
            }catch (SQLException ex){
                throw new RuntimeException(ex);

            }
    }
    
    @Override
    public Collection<Product> get(){
        
            String sql = "select * from PRODUCT order by product_id";
            try(
                Connection dbCon= JdbcConnection.getConnection(database_URL); 
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ){
                ResultSet rs = stmt.executeQuery();
                Collection<Product> products = new TreeSet();
                while(rs.next()){
                    Integer id = rs.getInt("product_id");
                    String name = rs.getString("name");
                    String desc = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer stock = rs.getInt("stock_quantity");
                    
                    Product p = new Product();
                    
                    p.product_ID = id;
                    p.name = name;
                    p.description = desc;
                    p.category = category;
                    p.price = price;
                    p.stock_quantity = stock;
                    
                    products.add(p);
                    
                    
                }
                
                return products;
            }catch (SQLException ex){
                throw new RuntimeException(ex);

            }
        
    }
    @Override
    public Collection<String> getCategories(){
        
            String sql = "select category from PRODUCT order by product_id";
            try(
                Connection dbCon= JdbcConnection.getConnection(database_URL); 
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ){
                
                ResultSet rs = stmt.executeQuery();
                Collection<String> categories = new TreeSet();
                while(rs.next()){
                    
                    
                    categories.add(rs.getString("category"));
                    
                    
                }
                
                return categories;
            }catch (SQLException ex){
                throw new RuntimeException(ex);

            }
        
    }
    

    @Override
    public Set<Product> getCatSet(String cat) {
                    String sql = "select * from PRODUCT where category = ?";
            try(
                Connection dbCon= JdbcConnection.getConnection(database_URL); 
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ){
                stmt.setString(1,cat);
                ResultSet rs = stmt.executeQuery();
                Collection<Product> categoryP = new TreeSet();
                while(rs.next()){
                    
                   Integer id = rs.getInt("product_id");
                   String name = rs.getString("name");
                    String desc = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer stock = rs.getInt("stock_quantity");
                    
                    Product p = new Product();
                    
                    p.product_ID = id;
                    p.name = name;
                    p.description = desc;
                    p.category = category;
                    p.price = price;
                    p.stock_quantity = stock;
                    
                    categoryP.add(p);
                    
                    
                }
                
                return (Set<Product>) categoryP;
            }catch (SQLException ex){
                throw new RuntimeException(ex);

            }
    }

    @Override
    public void delete(Product pdt) {
                            String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
            try(
                Connection dbCon= JdbcConnection.getConnection(database_URL); 
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ){
                stmt.setInt(1,pdt.getProduct_ID());
                                int rs = stmt.executeUpdate();
            }catch (SQLException ex){
                throw new RuntimeException(ex);

            }
    }

    @Override
    public Product search_by_ID(Integer id) {
          
                    String sql = "select * from PRODUCT where product_id = ?";
            try(
                Connection dbCon= JdbcConnection.getConnection(database_URL); 
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ){
                stmt.setInt(1,id);
                ResultSet rs = stmt.executeQuery();
                Product p = new Product();
                if (rs.next()){
                    
                   Integer pid = rs.getInt("product_id");
                   String name = rs.getString("name");
                    String desc = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer stock = rs.getInt("stock_quantity");
                    
                    p.product_ID = pid;
                    p.name = name;
                    p.description = desc;
                    p.category = category;
                    p.price = price;
                    p.stock_quantity = stock;
                    
     return p;
                }else{
                    return null;}
                
               
            }catch (SQLException ex){
                throw new RuntimeException(ex);

            }
    }
    
    
    
    
    
}

    
    
    
    

