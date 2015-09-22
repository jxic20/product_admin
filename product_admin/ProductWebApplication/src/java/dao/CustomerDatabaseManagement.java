/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.JdbcConnection;
import domain.Customer;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Jvic
 */
public class CustomerDatabaseManagement{
    String database_URL = "jdbc:h2:tcp://localhost/project;IFEXISTS=TRUE";

    public CustomerDatabaseManagement() {
    }
    public CustomerDatabaseManagement(String dt) {//to be continued
    }
    
   
    public void add(Customer ctr){
            String sql = "merge into Customer (customer_id, name, email, address, credit_card, password)"
                    + "values (?,?,?,?,?,?)";
            try(
                Connection dbCon= JdbcConnection.getConnection(database_URL); 
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ){
            System.out.println("yerk");
            stmt.setString(1, ctr.getUsername());
            stmt.setString(2, ctr.getName());
            stmt.setString(3, ctr.getEmail());
            stmt.setString(4, ctr.getAddress());
            stmt.setInt(5, ctr.getCredit_card());
            stmt.setString(6, ctr.getPassword());

            stmt.executeUpdate();
            }catch (SQLException ex){
                throw new RuntimeException(ex);

            }
    }
    
    public Customer get(String username, String password){
        
            String sql = "select * from customer where customer_id = ? and password = ?";
            try(
                Connection dbCon= JdbcConnection.getConnection(database_URL); 
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ){
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    String id = rs.getString("customer_id");
                    String name = rs.getString("name");
                    String desc = rs.getString("email");
                    String category = rs.getString("address");
                    Integer price = rs.getInt("credit_card");
                    String stock = rs.getString("password");
                    
                    Customer p = new Customer();
                    
                    p.username = id;
                    p.name = name;
                    p.email = desc;
                    p.address = category;
                    p.credit_card = price;
                    p.password = stock;
                    
                   return p; 
                }
                
                return  null;
            }catch (SQLException ex){
                throw new RuntimeException(ex);

            }
        
    }
    
}

    
    
    
    

