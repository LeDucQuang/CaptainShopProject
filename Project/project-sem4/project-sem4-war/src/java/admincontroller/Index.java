/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import entity.Customer;
import entity.Orders;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.OrdersFacadeLocal;
import sessionbean.ProductFacadeLocal;
import sessionbean.UsersFacadeLocal;
import sessionbean.WarehouseFacadeLocal;

/**
 *
 * @author Khoi
 */
public class Index extends HttpServlet {

    @EJB
    private WarehouseFacadeLocal warehouseFacade;
    @EJB
    private ProductFacadeLocal productFacade;
    @EJB
    private OrdersFacadeLocal ordersFacade;
    @EJB
    private UsersFacadeLocal usersFacade;

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
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        HttpSession session = request.getSession();
        if (session == null) {
            rd.forward(request, response);
            return;
        }

        Users user1 = (Users) session.getAttribute("User");

        if (user1 == null) {
            rd.forward(request, response);
            return;
        }

        if (user1.getUId() == null) {
            rd.forward(request, response);
            return;
        }

        try {

            int ordersCount = ordersFacade.count();
            int wareHousesCount = warehouseFacade.count();
            int productsCount = productFacade.count();
            int userCount = usersFacade.count();
            List<Orders> ordersList = ordersFacade.findLimit(5);
            List<Customer> customerList = new ArrayList<Customer>();

            // Add 5 recent customer from orders list
            for (Orders order : ordersList) {
                customerList.add(order.getCId());
            }

            // Set atrtribute to request  to index.jsp page
            request.setAttribute("ordersCount", ordersCount);
            request.setAttribute("wareHousesCount", wareHousesCount);
            request.setAttribute("productsCount", productsCount);
            request.setAttribute("usersCount", userCount);
            request.setAttribute("ordersList", ordersList);
            request.setAttribute("customerList", customerList);
            rd.forward(request, response);
        } catch (Exception ex) {
            rd = request.getRequestDispatcher("404.jsp");
            rd.forward(request, response);
        };
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
