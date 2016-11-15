/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import entity.Category;
import entity.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sessionbean.CategoryFacadeLocal;
import sessionbean.ProductFacadeLocal;

/**
 *
 * @author Cgc_Shyn
 */
@MultipartConfig
public class Products extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
        String action = request.getParameter("action");
        if (action == null) {
            action = "index";
        }
        try {
            if (action.equals("index")) {
                List<Product> productsList;
                productsList = productFacade.findAll();

                request.setAttribute("productlist", productsList);
                rd = request.getRequestDispatcher("products.jsp");
            } else if (action.equals("add")) {
                List<Category> cateList;
                cateList = categoryFacade.findAll();

                request.setAttribute("cateList", cateList);
                rd = request.getRequestDispatcher("products-add.jsp");
            } else if (action.equals("checkadd")) {
                String name = request.getParameter("name");
                Part filePart = request.getPart("imglink");
//                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = filePart.getInputStream();
                ServletContext context = getServletContext();
                String fName[] = filePart.getSubmittedFileName().split("[.]");
                System.out.println(filePart.getSubmittedFileName());
                String filePath = context.getRealPath("web/images") + "\\" + filePart.getSubmittedFileName();
                System.out.println(filePath);
                File f = new File(filePath);
                String imglink;

                if (!f.exists()) {
                    f.createNewFile();
                } else {
                    fName[0] = fName[0] + "_1";
                    filePath = context.getRealPath("web/images") + "/" + fName[0] + fName[1];
                    f = new File(filePath);
                    f.createNewFile();
                }

                imglink = "images/" + fName[0] + "." + fName[1];
                int content;
                OutputStream outSt = new FileOutputStream(f);

                do {
                    content = fileContent.read();
                    outSt.write(content);
                } while (content != -1);

                outSt.flush();
                outSt.close();

                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("des");
                int id = Integer.parseInt(request.getParameter("cateid"));
                Category category = categoryFacade.findById(id);

                if (productFacade.AddProduct(category, name, imglink, price, quantity, description)) {
                    List<Product> productsList;
                    productsList = productFacade.findAll();

                    request.setAttribute("productlist", productsList);
                    rd = request.getRequestDispatcher("products.jsp");
                } else {
                    rd.forward(request, response);
                    return;
                }
            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("pId"));
                Product product = productFacade.findById(id);
                request.setAttribute("product", product);
                List<Category> cateList;
                cateList = categoryFacade.findAll();

                request.setAttribute("cateList", cateList);
                rd = request.getRequestDispatcher("products-edit.jsp");
            } else if (action.equals("checkEdit")) {
                int id = Integer.parseInt(request.getParameter("pId"));
                Product p = productFacade.findById(id);
                Part filePart = request.getPart("imglink"); 
//                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                InputStream fileContent = filePart.getInputStream();
                ServletContext context = getServletContext();
                String fName[] = filePart.getSubmittedFileName().split("[.]");
                String filePath = context.getRealPath("web") + "/" + p.getImageLink();
                File f = new File(filePath);

                f.createNewFile();

                int content;
                OutputStream outSt = new FileOutputStream(f);;

                do {
                    content = fileContent.read();
                    outSt.write(content);
                } while (content != -1);

                outSt.flush();
                outSt.close();

                String name = request.getParameter("name");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("des");
                int cateid = Integer.parseInt(request.getParameter("cateid"));
                Category category = categoryFacade.findById(cateid);

                if (productFacade.EditProduct(id, category, name, price, quantity, description)) {
                    List<Product> productsList;
                    productsList = productFacade.findAll();

                    request.setAttribute("productlist", productsList);
                    rd = request.getRequestDispatcher("Products?action=index");
                } else {
                    rd.forward(request, response);
                    return;
                }
            } else if (action.equals("delete")) {
                int pId = Integer.parseInt(request.getParameter("pId"));
                if (productFacade.remove(pId)) {
                    List<Product> productsList;
                    productsList = productFacade.findAll();

                    request.setAttribute("productlist", productsList);
                    rd = request.getRequestDispatcher("Products?action=index");
                } else {
                    rd.forward(request, response);
                    return;
                }
            }
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
