/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end_controller;

import entity.Category;
import entity.Customer;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CategoryFacadeLocal;
import sessionbean.CustomerFacadeLocal;
import sessionbean.OrdersFacadeLocal;

/**
 *
 * @author Cgc_Shyn
 */
public class CustomerDetails extends HttpServlet {

    @EJB
    private OrdersFacadeLocal ordersFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;

    @EJB
    private CategoryFacadeLocal categoryFacade;

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
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
        List<Category> categoryList = categoryFacade.findAll();
        request.setAttribute("categoryList", categoryList);

        try {
            int id = Integer.parseInt(request.getParameter("cusId"));
            Customer customer = customerFacade.findById(id);
            if (customer == null) {
                rd.forward(request, response);
                return;
            }
            request.setAttribute("customer", customer);
            rd = request.getRequestDispatcher("single.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            rd = request.getRequestDispatcher("404.jsp");
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
