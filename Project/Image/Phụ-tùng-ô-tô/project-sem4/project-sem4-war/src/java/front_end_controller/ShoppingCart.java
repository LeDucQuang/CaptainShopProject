/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end_controller;

import entity.OrderProduct;
import entity.Orders;
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
public class ShoppingCart extends HttpServlet {

    @EJB
    private OrdersFacadeLocal ordersFacade;
    @EJB
    private OrderProductFacadeLocal orderProductFacade;

    @EJB
    private ProductFacadeLocal productFacade;

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
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd;
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        try {
            String prodId = request.getParameter("proId");
            Orders listCart = new Orders();
            List<OrderProduct> listCartItem = new ArrayList<>();
            if (session != null) {
                listCart = (Orders) session.getAttribute("ShoppingCart");
            }

            if (listCart != null) {
                listCartItem = (List<OrderProduct>) listCart.getOrderProductCollection();
//                for (OrderProduct cartItem : listCartItem) {
//                    OrderProduct orderProduct = orderProductFacade.getProduct(cartItem.getQuantity(), cartItem.getPId());
//                    
//                }
//                        listCart.add(new Orders(listCartItem));
            }

            if (action != null && !action.isEmpty() && action.equals("delete")) {
                for (OrderProduct orderProduct : listCartItem) {
                    if (orderProduct.getPId().getPId() == Integer.parseInt(prodId)) {
                        if (orderProduct.getQuantity() > 1) {
                            orderProduct.setQuantity(-1);
                        } else {
                            listCartItem.remove(orderProduct);
                        }
                    }
                }
            }

            if (listCartItem == null || listCartItem.size() <= 0) {
                rd = request.getRequestDispatcher("Home");
                rd.forward(request, response);
                return;
            }

            //Total Price
            double totalPrice = 0;
            for (OrderProduct item : listCartItem) {
                totalPrice += item.getPId().getProductPrice() * item.getQuantity();
            }

            request.setAttribute("Total", totalPrice);
            request.setAttribute("listShoppingCartItem", listCartItem);
            rd = request.getRequestDispatcher("checkout.jsp");
            rd.forward(request, response);

            return;

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
