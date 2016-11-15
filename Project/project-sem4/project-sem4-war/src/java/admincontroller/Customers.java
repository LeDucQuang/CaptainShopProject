/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import entity.Customer;
import entity.Users;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CustomerFacadeLocal;

/**
 *
 * @author Khoi
 */
public class Customers extends HttpServlet {

    //call ejb
    @EJB
    private CustomerFacadeLocal customerFacade;

    public boolean checkNum(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
        String action = request.getParameter("action");
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


        if (action == null) {
            action = "index";
        }
        try {
          
            if (action.equals("index")) {
                List<Customer> customerList;
                customerList = customerFacade.findLimit();
                int customerQuantity = customerFacade.findAll().size();
                request.setAttribute("customerList", customerList);
                request.setAttribute("customerQuantity", customerQuantity);
                rd = request.getRequestDispatcher("customers.jsp");
            } else if (action.equals("details")) {
                int id = Integer.parseInt(request.getParameter("id"));
                // validator data(){} add after
                Customer customer = customerFacade.findById(id);
                if (customer == null) {
                    rd.forward(request, response);
                    return;
                }
                request.setAttribute("customer", customer);
                rd = request.getRequestDispatcher("customers-details.jsp");
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                if (!customerFacade.remove(id)) {
                    rd.forward(request, response);
                    return;
                } else {
                    List<Customer> customerList;
                    customerList = customerFacade.findLimit();
                    request.setAttribute("customerList", customerList);
                    rd = request.getRequestDispatcher("customers.jsp");
                }
            } else if (action.equals("edit")) {
                if (request.getParameter("id") == null) {
                    rd.forward(request, response);
                    return;
                }
                String subAction = request.getParameter("sub-action");
                int id = Integer.parseInt(request.getParameter("id"));
                Customer customer = customerFacade.findById(id);
                if (customer == null) {
                    rd.forward(request, response);
                    return;
                }
                if (subAction == null) {
                    rd = request.getRequestDispatcher("customers-edit.jsp");
                    request.setAttribute("customer", customer);
                } else {
                    String customerRate = request.getParameter("customer-rate");
                    rd = request.getRequestDispatcher("customers.jsp");
                    switch (customerRate) {
                        case "1": {
                            customer.setRate(1);
                        }
                        break;
                        case "2": {
                            customer.setRate(1000);
                        }
                        break;
                        case "3": {
                            customer.setRate(2000);
                        }
                        break;
                        default: {
                            rd = request.getRequestDispatcher("404.jsp");
                        }
                        break;
                    }
                    customerFacade.edit(customer);
                    List<Customer> customerList;
                    customerList = customerFacade.findLimit();
                    request.setAttribute("customerList", customerList);
                }
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                customerFacade.remove(id);
                rd = request.getRequestDispatcher("customers.jsp");
            }
        } catch (Exception e) {
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
