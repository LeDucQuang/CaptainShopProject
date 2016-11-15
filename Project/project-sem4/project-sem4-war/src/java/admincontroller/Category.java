/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CategoryFacadeLocal;
import Valid.categoryValid;
import entity.Users;
import javax.servlet.http.HttpSession;
import sessionbean.ProductFacadeLocal;

/**
 *
 * @author Khoi
 */
public class Category extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;

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
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
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
                case "index": {
                    List<entity.Category> categoryList = categoryFacade.findAll();
                    request.setAttribute("categoryList", categoryList);
                    rd = request.getRequestDispatcher("category.jsp");
                }
                break;

                case "details": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    entity.Category category = categoryFacade.findById(id);

                    if (category == null) {
                        throw new Exception();
                    }

                    List<entity.Product> proList = productFacade.findByCateId(category);

                    if (proList == null) {
                        throw new Exception();
                    }

                    request.setAttribute("category", category);
                    request.setAttribute("productList", proList);
                    rd = request.getRequestDispatcher("category-details.jsp");
                }
                break;

                case "add": {
                    request.removeAttribute("error_msg");
                    rd = request.getRequestDispatcher("category-add.jsp");
                }
                break;

                case "checkAdd": {
                    String name = request.getParameter("name");
                    String brand = request.getParameter("brand");
                    String statusStr = request.getParameter("status");
                    boolean ok = true;

                    if (categoryValid.isEmpty(name)) {
                        request.setAttribute("error_msg", " category name must be fill");
                        ok = false;
                    }

                    if (categoryValid.isEmpty(brand)) {
                        request.setAttribute("error_msg", " brand name must be fill");
                        ok = false;
                    }

                    if (statusStr == null || !statusStr.equals("1") && !statusStr.equals("2")) {
                        ok = false;
                        throw new Exception(" status not found");
                    }

                    if (ok) {
                        entity.Category category = new entity.Category();
                        category.setBrand(brand);
                        category.setCategoryName(name);
                        category.setStatus(Integer.parseInt(statusStr));

                        categoryFacade.create(category);

                        List<entity.Category> categoryList = categoryFacade.findAll();
                        request.setAttribute("categoryList", categoryList);

                        rd = request.getRequestDispatcher("category.jsp");
                    } else {
                        rd = request.getRequestDispatcher("category-add.jsp");
                    }

                }
                break;

                case "edit": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    entity.Category category = categoryFacade.find(id);
                    if (category == null) {
                        throw new Exception(" category not found");
                    }

                    request.setAttribute("category", category);
                    rd = request.getRequestDispatcher("category-edit.jsp");
                }
                break;

                case "checkEdit": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    entity.Category category = categoryFacade.find(id);
                    String brand = request.getParameter("brand");
                    String name = request.getParameter("name");
                    String statusStr = request.getParameter("status");
                    boolean ok = true;

                    if (category == null) {
                        throw new Exception("category not found");
                    }

                    if (categoryValid.isEmpty(name)) {
                        request.setAttribute("error_msg", " category name must be fill");
                        ok = false;
                    }

                    if (categoryValid.isEmpty(brand)) {
                        request.setAttribute("error_msg", " brand name must be fill");
                        ok = false;
                    }

                    if (statusStr == null || !statusStr.equals("1") && !statusStr.equals("2")) {
                        ok = false;
                        throw new Exception(" status not found");
                    }

                    if (ok) {
                        category.setBrand(brand);
                        category.setCategoryName(name);
                        category.setStatus(Integer.parseInt(statusStr));

                        categoryFacade.edit(category);

                        List<entity.Category> categoryList = categoryFacade.findAll();
                        request.setAttribute("categoryList", categoryList);

                        rd = request.getRequestDispatcher("category.jsp");
                    } else {
                        rd = request.getRequestDispatcher("category-edit.jsp");
                    }
                }
                break;

                case "delete": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    entity.Category category = categoryFacade.find(id);

                    if (category == null) {
                        throw new Exception("category not found ");
                    } else {
                        if (category.getStatus() == null || category.getStatus() == 2) {
                            category.setStatus(1);
                        } else {
                            category.setStatus(2);
                        }

                        categoryFacade.edit(category);
                    }

                    List<entity.Category> categoryList = categoryFacade.findAll();
                    request.setAttribute("categoryList", categoryList);

                    rd = request.getRequestDispatcher("category.jsp");

                }
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            rd = request.getRequestDispatcher("404.jsp");
            rd.forward(request, response);
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
