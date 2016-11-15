/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import entity.Orders;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.OrdersFacadeLocal;

/**
 *
 * @author Khoi
 */
public class Order extends HttpServlet {

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
        String action = request.getParameter("action");
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");

        if (action == null) {
            action = "index";
        }

        if (action.equals("index")) {
            List<Orders> orderList = ordersFacade.findLimit();
            int ordersQuantity = ordersFacade.findAll().size();

            request.setAttribute("ordersQuantity", ordersQuantity);
            request.setAttribute("ordersList", orderList);
            rd = request.getRequestDispatcher("orders.jsp");
        } else if (action.equals("details")) {
            if (request.getParameter("id") == null) {
                rd.forward(request, response);
                return;
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                Orders order = ordersFacade.findById(id);
                if (order == null) {
                    rd.forward(request, response);
                    return;
                } else {
                    request.setAttribute("order", order);
                    rd = request.getRequestDispatcher("orders-details.jsp");
                }
            }
        } else if (action.equals("edit")) {
            if (request.getParameter("id") == null) {
                rd.forward(request, response);
                return;
            }
            String sub_action = request.getParameter("sub-action");
            int id = Integer.parseInt(request.getParameter("id"));
            Orders order = ordersFacade.findById(id);
            if (order == null) {
                rd.forward(request, response);
                return;
            }
            if (sub_action == null) {
                request.setAttribute("order", order);
                rd = request.getRequestDispatcher("orders-edit.jsp");
            } else {
                String status = request.getParameter("status");
                String note = request.getParameter("note");
                
                if( status != null ) {
                    switch(status) {
                        case "1":
                            status = "hoan thanh";
                        break;
                        case "2":
                            status = "dang doi";
                        break;
                    }
                    order.setOrderStatus(status);
                }
                
                if( note != null ) {
                    order.setOrderNote(note);
                }
                
                ordersFacade.edit(order);
                
                List<Orders> orderList = ordersFacade.findLimit();
                int ordersQuantity = ordersFacade.findAll().size();

                request.setAttribute("ordersQuantity", ordersQuantity);
                request.setAttribute("ordersList", orderList);
                
                rd = request.getRequestDispatcher("orders.jsp");
            }
        } else if( action.equals("delete") ) {
            if (request.getParameter("id") == null) {
                rd.forward(request, response);
                return;
            }
            
            int id = Integer.parseInt(request.getParameter("id"));
            Orders order = ordersFacade.findById(id);
            
            if (order == null) {
                rd.forward(request, response);
                return;
            } else {
                order.setOrderStatus("huy");
                ordersFacade.edit(order);
                
                List<Orders> orderList = ordersFacade.findLimit();
                int ordersQuantity = ordersFacade.findAll().size();

                request.setAttribute("ordersQuantity", ordersQuantity);
                request.setAttribute("ordersList", orderList);
                
                rd = request.getRequestDispatcher("orders.jsp");
            }
            
            
        }
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
