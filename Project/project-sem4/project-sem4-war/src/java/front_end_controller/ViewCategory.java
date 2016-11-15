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
public class ViewCategory extends HttpServlet {

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
        RequestDispatcher rd;
        try {
            List<Category> categoryList = categoryFacade.findAll();
            request.setAttribute("categoryList", categoryList);
            String brand = request.getParameter("brand");
            String cateId = request.getParameter("cateId");

            List<Category> listCategory = new ArrayList<Category>();
            List<Product> listProduct = new ArrayList<Product>();

            if (brand != null && !brand.isEmpty()) {

                listCategory = categoryFacade.findCategoryByBrand(brand);

                if (listCategory != null && listCategory.size() > 0) {
                    for (Category category : listCategory) {
                        for (Product product : category.getProductCollection()) {
                            listProduct.add(product);
                        }
                    }
                }
            } else if (cateId != null && !cateId.isEmpty()) {
                Category category = categoryFacade.findById(Integer.parseInt(cateId));

                if (category == null) {
                    throw new Exception();
                }

                listProduct = productFacade.findByCateId(category);
            }

            request.setAttribute("listCategory", listCategory);
            request.setAttribute("listProduct", listProduct);
            rd = request.getRequestDispatcher("viewCategory.jsp");
            rd.forward(request, response);

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
