/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end_controller;

import entity.OrderProduct;
import entity.Orders;
import entity.Product;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.OrderProductFacadeLocal;
import sessionbean.OrdersFacadeLocal;
import sessionbean.ProductFacadeLocal;

/**
 *
 * @author Cgc_Shyn
 */
public class Carts extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;

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
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
        String action = request.getParameter("action");
        if (action == null) {
            action = "index";
        }
        try {
            List<OrderProduct> listProductOrder;
            HttpSession session = request.getSession();

            if (action.equals("index")) {
                listProductOrder = orderProductFacade.findAll();
                request.setAttribute("ListProductOrder", listProductOrder);
                rd = request.getRequestDispatcher("checkout.jsp");
                rd.forward(request, response);
            } else if (action.equals("addtocart")) {
              Orders  orders = (Orders) session.getAttribute("ShoppingCart");
                int productId = Integer.parseInt(request.getParameter("proId"));
                Product product = productFacade.findById(productId);
                if (orders == null) {
                  orders = new Orders();
                  session.setAttribute("ShoppingCart", orders);
                } 
                
            }
        } catch (Exception e) {
            e.printStackTrace();
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
