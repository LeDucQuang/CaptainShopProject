/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end_controller;

import entity.Category;
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
import sessionbean.CategoryFacadeLocal;
import sessionbean.ProductFacadeLocal;

/**
 *
 * @author VuNK
 */
public class ProductDetails extends HttpServlet {

    @EJB
    private CategoryFacadeLocal categoryFacade;
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
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");

        String brand = request.getParameter("brand");
        List<Category> listCategory = new ArrayList<Category>();
        List<Category> categoryList = categoryFacade.findAll();
        request.setAttribute("categoryList", categoryList);
        String productId = request.getParameter("proId");
        Product product = new Product();
        Category category = new Category();

        if (productId != null && !productId.isEmpty() && (brand == null || brand.isEmpty())) {
            product = productFacade.findById(Integer.parseInt(productId));
            category = categoryFacade.findById(product.getCateId().getCateId());

            brand = category.getBrand();
        }

        listCategory = categoryFacade.findCategoryByBrand(brand);

        request.setAttribute("listCategory", listCategory);
        request.setAttribute("productDetails", product);
        rd = request.getRequestDispatcher("productdetail.jsp");
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
