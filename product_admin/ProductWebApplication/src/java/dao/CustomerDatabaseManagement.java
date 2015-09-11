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
    
}

    
    
    
    

