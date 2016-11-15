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
import java.util.ArrayList;
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
 * @author VuNK
 */
public class AddToCart extends HttpServlet {

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
        String page = request.getParameter("page");

        Orders listCartItem;
        HttpSession session = request.getSession();
        List<OrderProduct> listOrderProducts = new ArrayList<>();
        Orders shoppingCart = (Orders) session.getAttribute("ShoppingCart");
        int productId = Integer.parseInt(request.getParameter("proId"));
        String productQuantity = request.getParameter("productQuantity");
        int quantity = 1;
        if (productQuantity != null && !productQuantity.isEmpty()) {
            quantity = Integer.parseInt(productQuantity);
        }
        Product product;
        OrderProduct orderProduct;
//        quantity = Integer.parseInt(request.getParameter("quantity"));

        if (shoppingCart == null) {
            //Create New Shopping Cart Session
            product = productFacade.findById(productId);
            orderProduct = orderProductFacade.getProduct(quantity, product);
            listOrderProducts.add(orderProduct);
            listCartItem = new Orders();
            listCartItem.setOrderProductCollection(listOrderProducts);
            session.setAttribute("ShoppingCart", listCartItem);
        } else {
            boolean flag = false;
            listCartItem = (Orders) session.getAttribute("ShoppingCart");
            listOrderProducts = (List<OrderProduct>) listCartItem.getOrderProductCollection();
            for (OrderProduct item2 : listOrderProducts) {
                if (item2.getPId().getPId() == productId) {
                    item2.setQuantity(quantity);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                product = productFacade.findById(productId);
                orderProduct = orderProductFacade.getProduct(quantity, product);
                listOrderProducts.add(orderProduct);
                listCartItem.setOrderProductCollection(listOrderProducts);
            }
            session.setAttribute("ShoppingCart", listCartItem);
        }

        //Count item in shopping cart
        int cartcount = 0;

        for (OrderProduct shoppingCart1 : listOrderProducts) {
            cartcount += shoppingCart1.getQuantity();
        }

        session.setAttribute("CartCount", cartcount);

        rd = request.getRequestDispatcher("Home");
        rd.forward(request, response);
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
