/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import dao.OrderDAO;
import dao.ProductCollectionsInterface;
import dao.ProductsDatabaseManagement;
import domain.Customer;
import domain.Order;
import domain.OrderItem;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Jvic
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws org.apache.commons.mail.EmailException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmailException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        OrderDAO ordao = new OrderDAO();
        ProductCollectionsInterface pdtDAO = new ProductsDatabaseManagement();
        Customer cst = (Customer) session.getAttribute("customerLoggedIn");
        List<OrderItem> ordList = (List<OrderItem>) session.getAttribute("Cart");
        java.util.Date date = new java.util.Date();
        if (cst == null) {
            response.sendRedirect("Login.jsp");
        } else {
            Order ord = (Order) session.getAttribute("Order");
            ord.setC_id(cst.getUsername());
            ord.setOrder_date(date);

            Email email = new SimpleEmail();
            email.setHostName("localhost");
            email.setSmtpPort(25);
            email.setFrom("user@gmail.com");
            email.setSubject("OrderReceipt");
            Double totes =0.0;
            String msg = "This is a receipt mail for\n\n";
            for(OrderItem orditem : ordList){  
                msg += pdtDAO.search_by_ID(orditem.getP_id()).getName()+ "  quantity: " + orditem.quantity_purchased + "  price: " + orditem.purchase_price +"\n";
                totes += orditem.getPurchase_price();
            }
            email.setMsg(msg + "\n Total Price: " + totes);
            email.addTo(cst.getEmail());
            email.send();

            ordao.add(ord, ordList);

            session.setAttribute("Cart", null);
            session.setAttribute("itemCart", null);
            session.setAttribute("Order", null);

            response.sendRedirect("Thanks.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (EmailException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (EmailException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
