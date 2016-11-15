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
import sessionbean.CustomerFacadeLocal;
import sessionbean.OrderProductFacadeLocal;
import sessionbean.OrdersFacadeLocal;
import sessionbean.ProductFacadeLocal;
import sessionbean.UsersFacadeLocal;

/**
 *
 * @author VuNK
 */
public class Home extends HttpServlet {

    @EJB
    private OrdersFacadeLocal ordersFacade;
    @EJB
    private OrderProductFacadeLocal orderProductFacade;

    @EJB
    private UsersFacadeLocal usersFacade;
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
        String action = request.getParameter("action");
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
        HttpSession session = request.getSession();
        if (action == null) {
            action = "index";
        }
        try {
            if (action.equals("index")) {
                List<Product> listProduct;
                listProduct = productFacade.findAll();
                request.setAttribute("listProduct", listProduct);
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else if (action.equals("login")) {
                rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);

            } else if (action.equals("checkLogin")) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                if (customerFacade.checkLogin(email, password)) {
                   rd = request.getRequestDispatcher("");
                rd.forward(request, response);
                } else if (usersFacade.checkLogin(email, password)) {
                    rd = request.getRequestDispatcher("");
                    rd.forward(request, response);
                } else {
                    rd = request.getRequestDispatcher("404.jsp");
                    rd.forward(request, response);

                }
            } else if (action.equals("register")) {
                rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
                return;
            } else if (action.equals("checkRegister")) {
                System.out.println(action);
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String repass = request.getParameter("repass");
                if (customerFacade.AddCustomer(name, email, pass, repass)) {
                    System.out.println("add success");
                } else {
                    System.out.println("add error");
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
