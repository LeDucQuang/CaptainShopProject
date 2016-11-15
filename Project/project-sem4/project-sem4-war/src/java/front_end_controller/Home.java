/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end_controller;

import entity.Category;
import entity.OrderProduct;
import entity.Orders;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CategoryFacadeLocal;
import sessionbean.CustomerFacadeLocal;
import Valid.ValidData;
import entity.Customer;
import sessionbean.OrdersFacadeLocal;
import sessionbean.ProductFacadeLocal;
import sessionbean.UsersFacadeLocal;

/**
 *
 * @author VuNK
 */
public class Home extends HttpServlet {

    @EJB
    private CategoryFacadeLocal categoryFacade;

    @EJB
    private OrdersFacadeLocal ordersFacade;

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
        List<Category> categoryList = categoryFacade.findAll();
        request.setAttribute("categoryList", categoryList);

        if (action == null) {
            action = "index";
        }

        try {
            if (action.equals("index")) {
                List<Product> newProduct = productFacade.findLimit(9);
                List<Product> topProduct = new ArrayList<Product>();
                List<Orders> ordersList = ordersFacade.findLimit(9);

                if (ordersList != null) {
                    for (Orders order : ordersList) {
                        List<OrderProduct> orderProductList = (List<OrderProduct>) order.getOrderProductCollection();
                        for (OrderProduct orderProduct : orderProductList) {
                            if (!topProduct.contains(orderProduct.getPId())) {
                                topProduct.add(orderProduct.getPId());
                            } else {
                                Product p = topProduct.get(topProduct.indexOf(orderProduct.getPId()));
                                p.setQuantity(orderProduct.getQuantity() + p.getQuantity());
                                topProduct.set(topProduct.indexOf(orderProduct.getPId()), p);
                            }
                        }
                    }
                }

                topProduct.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product fruit2, Product fruit1) {
                        return fruit1.getQuantity().compareTo(fruit2.getQuantity());
                    }
                });
                request.setAttribute("newProduct", newProduct);
                request.setAttribute("topProduct", topProduct);

                rd = request.getRequestDispatcher("index.jsp");
            } else if (action.equals("login")) { 
                Customer cus = (Customer)session.getAttribute("Customer");
               if( cus.getCId() != null ) {
                   response.sendRedirect(request.getContextPath() + "/web/Home");
                   return;
                }
                rd = request.getRequestDispatcher("login.jsp");
            } else if (action.equals("checkLogin")) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                if (email == null || email.trim().equals("")) {
                    email = "";
                }
                
                System.out.println(password);
                
                if (password == null || password.trim().equals("")) {
                    password = "";
                }

                if (customerFacade.checkLogin(email, password)) {
                    session.setAttribute("Customer", customerFacade.findByEmail(email));
                    response.sendRedirect(request.getContextPath() + "/web/Home");
                    return;
                } else if (usersFacade.checkLogin(email, password)) {
                    session.setAttribute("User", usersFacade.findByName(email));
                    response.sendRedirect(request.getContextPath() + "/admin/Index");
                    return;
                } else {
                    rd = request.getRequestDispatcher("login.jsp");
                }
            } else if (action.equals("register")) {
                rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
                return;
            } else if (action.equals("checkRegister")) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String repass = request.getParameter("repass");

                if (ValidData.isEmpty(name) || ValidData.isEmpty(email) || ValidData.isEmpty(pass) || ValidData.isEmpty(repass)) {
                    rd = request.getRequestDispatcher("register.jsp");
                    request.setAttribute("error_msg", "all field must be fill");
                    rd.forward(request, response);
                    return;
                }

                if (!ValidData.isName(name)) {
                    rd = request.getRequestDispatcher("register.jsp");
                    request.setAttribute("error_msg", "wrong user name");
                    rd.forward(request, response);
                    return;
                }

                if (!ValidData.isPassword(pass)) {
                    rd = request.getRequestDispatcher("register.jsp");
                    request.setAttribute("error_msg", "wrong password");
                    rd.forward(request, response);
                    return;
                }

                if (!pass.equals(repass)) {
                    rd = request.getRequestDispatcher("register.jsp");
                    request.setAttribute("error_msg", "wrong repass");
                    rd.forward(request, response);
                    return;
                }

                if (!pass.equals(repass)) {
                    rd = request.getRequestDispatcher("register.jsp");
                    request.setAttribute("error_msg", "wrong repass");
                    rd.forward(request, response);
                    return;
                }

                if (customerFacade.AddCustomer(name, email, pass, repass)) {
                    response.sendRedirect(request.getContextPath() + "/web/Home");
                    return;
                } else {
                    rd = request.getRequestDispatcher("register.jsp");
                    request.setAttribute("error_msg", "user name existed");
                    rd.forward(request, response);
                    return;
                }
            } else if (action.equals("logOut")) {
                session.removeAttribute("ShoppingCart");
                session.removeAttribute("Customer");
                session.removeAttribute("User");
                session.removeAttribute("CartCount");
                response.sendRedirect(request.getContextPath() + "/web/Home");
                return;
            } else if (action.equals("emptyCart")) {
                session.removeAttribute("CartCount");
                session.removeAttribute("ShoppingCart");
                response.sendRedirect(request.getContextPath() + "/web/Home");
                return;
            } else if( action.equals("contact") ) {
                rd = request.getRequestDispatcher("contact.jsp");
            }

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