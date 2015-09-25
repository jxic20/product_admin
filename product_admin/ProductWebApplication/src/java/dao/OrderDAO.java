/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Order;
import dao.JdbcConnection;
import domain.OrderItem;
import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Jvic
 */
public class OrderDAO {

    String database_URL = "jdbc:h2:tcp://localhost/project;IFEXISTS=TRUE";

    public OrderDAO() {
    }

    public void add(Order ord, List<OrderItem> ordList) {
        String sql = "insert into order_sale (c_id, order_date) values (?, ?)";
        String sql2 = "insert into order_item (p_id, sale_id, quantity_purchased,purchase_price) values (?, ?,?,?)";
        String sql3 = "update product set stock_quantity = ? where product_id = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(database_URL);) {
            PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            Timestamp timestamp = new Timestamp(ord.getOrder_date().getTime());

            stmt.setString(1, ord.getC_id());
            stmt.setTimestamp(2, timestamp);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            Integer id = null;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new RuntimeException("Problem getting generated ID");
            }
            PreparedStatement stmt2 = dbCon.prepareStatement(sql2);
            PreparedStatement stmt3 = dbCon.prepareStatement(sql3);

            for (OrderItem ordItem : ordList) {
                stmt2.setInt(1, ordItem.getP_id());
                stmt2.setInt(2, id);
                stmt2.setInt(3, ordItem.getQuantity_purchased());
                stmt2.setDouble(4, ordItem.getPurchase_price());
                stmt2.addBatch();
            }
            stmt2.executeBatch();

            ProductCollectionsInterface pdtDAO = new ProductsDatabaseManagement();
            Collection<Product> pdtList = pdtDAO.get();

            for (OrderItem ordItem : ordList) {
                Product pdt = pdtDAO.search_by_ID(ordItem.getP_id());
                if(pdt.getStock_quantity() != 0){
                    stmt3.setInt(1, pdt.getStock_quantity() - ordItem.getQuantity_purchased());
                    stmt3.setInt(2,ordItem.getP_id());
                    stmt3.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
    }

}
