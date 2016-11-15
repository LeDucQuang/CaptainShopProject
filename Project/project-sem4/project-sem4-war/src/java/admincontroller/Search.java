/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CustomerFacadeLocal;
import sessionbean.OrdersFacadeLocal;
import sessionbean.ProductFacadeLocal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khoi
 */
public class Search extends HttpServlet {

    @EJB
    private OrdersFacadeLocal ordersFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;

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
        RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
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
            String action = request.getParameter("action");

            if (action == null) {
                action = "index";
            }

            switch (action) {

                case "search": {
                    String searchType = request.getParameter("search-type");

                    if (searchType == null) {
                        throw new Exception();
                    } else {
                        switch (searchType) {
                            case "products": {
                                String idStr = request.getParameter("id");
                                String priceStr = request.getParameter("price");
                                String name = request.getParameter("name");
                                List<entity.Product> productList = productFacade.findAll();
                                List<entity.Product> searchProduct = new ArrayList<entity.Product>();

                                try {

                                    if (productList != null) {
                                        for (entity.Product product : productList) {
                                            boolean checkAdd = true;

                                            if (idStr != null && !idStr.trim().equals("")) {
                                                if (product.getPId() == Integer.parseInt(idStr)) {
                                                    searchProduct.add(product);
                                                    checkAdd = false;
                                                }
                                            }

                                            if (checkAdd && priceStr != null && !priceStr.trim().equals("")) {
                                                if (product.getProductPrice() == Double.parseDouble(priceStr)) {
                                                    searchProduct.add(product);
                                                    checkAdd = false;
                                                }
                                            }
                                            if (checkAdd && name != null && !name.trim().equals("")) {
                                                if (product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                                                    searchProduct.add(product);
                                                    checkAdd = false;
                                                }
                                            }
                                        }
                                    }
                                } catch (NumberFormatException ex) {
                                    searchProduct = null;
                                    request.setAttribute("error_msg", "id and quantity must be numberic");
                                }

                                request.setAttribute("productList", searchProduct);
                            }
                            break;

                            case "customers": {
                                String idStr = request.getParameter("id");
                                String name = request.getParameter("name");
                                List<entity.Customer> userList = customerFacade.findAll();
                                List<entity.Customer> searchUser = new ArrayList<entity.Customer>();

                                try {
                                    if (userList != null) {
                                        for (entity.Customer user : userList) {
                                            boolean checkAdd = true;
                                            if (idStr != null && !idStr.trim().equals("")) {
                                                if (user.getCId() == Integer.parseInt(idStr)) {
                                                    searchUser.add(user);
                                                    checkAdd = false;
                                                }
                                            }

                                            if (name != null && !name.trim().equals("")) {
                                                if (user.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                                                    searchUser.add(user);
                                                    checkAdd = false;
                                                }
                                            }
                                        }
                                    }

                                } catch (NumberFormatException ex) {
                                    searchUser = null;
                                    request.setAttribute("error_msg", "id must be numberic");
                                }
                                request.setAttribute("userList", searchUser);

                            }
                            break;

                            case "orders": {
                                String idStr = request.getParameter("id");
                                String customerId = request.getParameter("customerId");
                                String date = request.getParameter("date");
                                List<entity.Orders> ordersList = ordersFacade.findAll();
                                List<entity.Orders> searchOrders = new ArrayList<entity.Orders>();

                                try {
                                    if (ordersList != null) {
                                        for (entity.Orders order : ordersList) {
                                            boolean checkAdd = true;
                                            if (idStr != null && !idStr.trim().equals("")) {
                                                if (order.getOId() == Integer.parseInt(idStr)) {
                                                    searchOrders.add(order);
                                                    checkAdd = false;
                                                }
                                            }

                                            if (checkAdd && customerId != null && !customerId.trim().equals("")) {
                                                if (order.getCId().getCId() == Integer.parseInt(customerId)) {
                                                    searchOrders.add(order);
                                                    checkAdd = false;
                                                }
                                            }

                                            if (checkAdd && date != null && !date.trim().equals("")) {
                                                if (order.getOrderDate().equals(new SimpleDateFormat().parse(date))) {
                                                    searchOrders.add(order);
                                                    checkAdd = false;
                                                }
                                            }
                                        }
                                    }

                                } catch (NumberFormatException ex) {
                                    searchOrders = null;
                                    request.setAttribute("error_msg", "id must be numberic");
                                } catch (ParseException ex) {
                                    searchOrders = null;
                                    request.setAttribute("error_msg", " error when input date");
                                }
                                request.setAttribute("ordersList", searchOrders);
                            }
                            break;
                        }
                    }
                }
                break;
            }

        } catch (Exception ex) {
            rd = request.getRequestDispatcher("404.jsp");
        } finally {
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
