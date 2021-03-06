/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Jvic
 */
import java.sql.Connection;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;

public class JdbcConnection {

    private static final String username = "sa"; // H2 default 
    private static final String password = ""; // H2 default 
    private static JdbcConnectionPool pool; public static Connection getConnection(String url) {
        if (pool == null) {
            pool = JdbcConnectionPool.create(url, username, password);
        }
        try {
            return pool.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

