
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end_controller;

import entity.Customer;
import entity.Orders;
import entity.Warehouse;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.OrderProductFacadeLocal;
import sessionbean.OrdersFacadeLocal;

/**
 *
 * @author VuNK
 */
public class CheckOut extends HttpServlet {

    @EJB
    private OrderProductFacadeLocal orderProductFacade;
    @EJB
    private OrdersFacadeLocal ordersFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        try {
            HttpSession session = request.getSession();
            Orders shoppingCartItem = new Orders();
            String user = null;
            Customer customer = null;
            Warehouse warehouse = null;
            Orders order = new Orders();

            if (session != null) {
                shoppingCartItem = (Orders) session.getAttribute("ShoppingCart");
                customer = (Customer) session.getAttribute("Customer");
            }

            if (user == null) {
                rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

            //Insert Order to DB
            Date currentDate = new Date();

            //Inser Order
            if (shoppingCartItem != null) {
                //Set data to Order
                order.setOrderIdentifier("");
                order.setOrderAddress("");
                order.setOrderDate(currentDate);
                order.setOrderStatus("NEW");
                order.setOrderNote("");
                order.setCId(customer);
                order.setWId(warehouse);
                order.setOrderProductCollection(shoppingCartItem.getOrderProductCollection());
                ordersFacade.AddOrder(order);
            }
        } catch (Exception e) {
            rd = request.getRequestDispatcher("404.jsp");
            rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
