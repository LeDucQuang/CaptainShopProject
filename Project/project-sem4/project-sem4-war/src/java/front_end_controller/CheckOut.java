/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end_controller;

import bussinessObject.ShoppingCartItem;
import entity.Category;
import entity.Customer;
import entity.OrderProduct;
import entity.Orders;
import entity.Product;
import entity.Warehouse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CategoryFacadeLocal;
import sessionbean.OrderProductFacadeLocal;
import sessionbean.OrdersFacadeLocal;
import sessionbean.WarehouseFacadeLocal;

/**
 *
 * @author VuNK
 */
public class CheckOut extends HttpServlet {

    @EJB
    private CategoryFacadeLocal categoryFacade;

    @EJB
    private WarehouseFacadeLocal warehouseFacade;

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
        RequestDispatcher rd = request.getRequestDispatcher("Home");
        String action = request.getParameter("action");
        if (action == null) {
            action = "index";
        }
        try {
            HttpSession session = request.getSession();
            Orders shoppingCartItem = new Orders();
            List<Category> categoryList = categoryFacade.findAll();
            request.setAttribute("categoryList", categoryList);

            Customer customer = null;
            if (session != null) {
                shoppingCartItem = (Orders) session.getAttribute("ShoppingCart");
                customer = (Customer) session.getAttribute("Customer");
            }
            if (action.equals("index")) {

                if (customer == null || customer.getCId() == null) {
                    response.sendRedirect(request.getContextPath() + "/web/Home?action=login");
                    return;
                }
                if(shoppingCartItem == null) {
                    response.sendRedirect(request.getContextPath() + "/web/Home?action=index");
                    return;
                }
                List<Warehouse> wareList;
                wareList = warehouseFacade.findAll();
                request.setAttribute("wareList", wareList);
                double total = shoppingCartItem.getOrdersFee();
                request.setAttribute("Total", total);
                rd = request.getRequestDispatcher("invoice.jsp");
                rd.forward(request, response);
            } else if (action.equals("checkPlace")) {
                Warehouse warehouse = null;
                Orders order = new Orders();

                Date currentDate = new Date();
                String address = request.getParameter("address");
                int ware = Integer.parseInt(request.getParameter("wareid"));
                warehouse = warehouseFacade.findById(ware);
                //Inser Order
                if (shoppingCartItem != null) {
                    //Set data to Order
                    order.setOrderIdentifier("");
                    order.setOrderAddress(address);
                    order.setOrderDate(currentDate);
                    order.setOrderStatus("In-process");
                    order.setOrderNote("");
                    order.setCId(customer);
                    order.setWId(warehouse);
                    Orders orderId = ordersFacade.createAndReturn(order);
                    for (OrderProduct orderProduct : shoppingCartItem.getOrderProductCollection()) {
                        orderProduct.setOId(orderId);
                        System.out.println(orderProduct.toString());
                        orderProductFacade.create(orderProduct);
                    }
                    response.sendRedirect(request.getContextPath() + "/web/Home?ation=index");
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
