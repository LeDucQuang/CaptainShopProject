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
import Valid.productValid;
import entity.Users;
import javax.servlet.http.HttpSession;

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
    private void sendError( HttpServletRequest request, HttpServletResponse response, String msg, String page ) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        List<Category> cateList;
        cateList = categoryFacade.findAll();
        request.setAttribute("error_msg", msg);
        request.setAttribute("cateList", cateList);
        
        try {
            rd.forward(request, response);
            return;
        } catch( Exception ex ) {
            throw new Exception("Can't find the specific path");
        }
            
    }
    
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "index";
        }
        try {
            if (action.equals("index")) {
                List<Product> productsList;
                productsList = productFacade.findLimit( 50 );
                int productsQuantity = productFacade.count();
                request.setAttribute("productlist", productsList);
                request.setAttribute("productQuantity", productsQuantity);
                rd = request.getRequestDispatcher("products.jsp");
            } else if (action.equals("add")) {
                List<Category> cateList;
                cateList = categoryFacade.findAll();
                request.setAttribute("cateList", cateList);
                rd = request.getRequestDispatcher("products-add.jsp");
            } else if (action.equals("checkadd")) {
                String name = request.getParameter("name");
                Part filePart = request.getPart("imglink");
                
                if( filePart.getSubmittedFileName().equals("") ) {
                    this.sendError(request, response, "product image not be choosed", "products-add.jsp");
                    return;
                }
                
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = filePart.getInputStream();
                ServletContext context = getServletContext();
                String fName[] = filePart.getSubmittedFileName().split("[.]");
                String quantityStr = request.getParameter("quantity");
                String priceStr = request.getParameter("price");
                String description = request.getParameter("des");
                int id = Integer.parseInt(request.getParameter("cateid"));
                Category category = categoryFacade.findById(id);
                String filePath = context.getRealPath("web/images") + "\\" + filePart.getSubmittedFileName();
                
                if( productValid.isEmpty(name) ) {
                    this.sendError(request, response, "product name must be fill", "products-add.jsp");
                    return;
                }
                
                if( productValid.isEmpty( description ) ) {
                    this.sendError(request, response, "description must be fill", "products-add.jsp");
                    return;
                }
                
                if( productValid.isEmpty( quantityStr ) ) {
                    this.sendError(request, response, "product quantity must be fill", "products-add.jsp");
                    return;
                }
                
                if( productValid.isEmpty( priceStr ) ) {
                    this.sendError(request, response, "price must be fill", "products-add.jsp");
                    return;
                }
                
                if( !productValid.isNumber( quantityStr ) ) {
                    this.sendError(request, response, "quantity is numberic", "products-add.jsp");
                    return;
                }
                
                if( !productValid.isDoubleNumber( priceStr ) ) {
                    this.sendError(request, response, "price is numberic", "products-add.jsp");
                    return;
                }
                
                if( !productValid.isImage( fName[1] ) ) {
                    this.sendError(request, response, "can't found image", "products-add.jsp");
                    return;
                }
                
                int quantity = Integer.parseInt( quantityStr );
                Double price = Double.parseDouble( priceStr );
                
                File f = new File(filePath);
                String imglink;

                if (!f.exists()) {
                    f.createNewFile();
                } else {
                    fName[0] = fName[0] + "_1.";
                    filePath = context.getRealPath("web/images") + "/" + fName[0] + fName[1];
                    f = new File(filePath);
                    f.createNewFile();
                }

                imglink = "images/" + fName[0] +"."+ fName[1];
                int content;
                OutputStream outSt = new FileOutputStream(f);

                do {
                    content = fileContent.read();
                    outSt.write(content);
                } while (content != -1);

                outSt.flush();
                outSt.close();
                
                if( category == null ) {
                    rd.forward(request, response);
                    return;
                }
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
                request.setAttribute("product", p);
                Part filePart = request.getPart("imglink"); 
                String name = request.getParameter("name");
                String quantityStr = request.getParameter("quantity");
                String priceStr = request.getParameter("price");
                String description = request.getParameter("des");
                int cateid = Integer.parseInt(request.getParameter("cateid"));
                Category category = categoryFacade.findById(cateid);
                
                
                if( productValid.isEmpty(name) ) {
                    this.sendError(request, response, "product name must be fill", "products-add.jsp");
                    return;
                }
                
                if( productValid.isEmpty( description ) ) {
                    this.sendError(request, response, "description must be fill", "products-add.jsp");
                    return;
                }
                
                if( productValid.isEmpty( quantityStr ) ) {
                    this.sendError(request, response, "product quantity must be fill", "products-add.jsp");
                    return;
                }
                
                if( productValid.isEmpty( priceStr ) ) {
                    this.sendError(request, response, "price must be fill", "products-add.jsp");
                    return;
                }
                
                if( !productValid.isNumber( quantityStr ) ) {
                    this.sendError(request, response, "quantity is numberic", "products-add.jsp");
                    return;
                }
                
                if( !productValid.isDoubleNumber( priceStr ) ) {
                    this.sendError(request, response, "price is numberic", "products-add.jsp");
                    return;
                }
                
                
                int quantity = Integer.parseInt(quantityStr);
                double price = Double.parseDouble(priceStr);
                
                if( !filePart.getSubmittedFileName().equals("") ) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                    InputStream fileContent = filePart.getInputStream();
                    ServletContext context = getServletContext();
                    String fName[] = filePart.getSubmittedFileName().split("[.]");
                    String filePath = context.getRealPath("web") + "/" + p.getImageLink();
                    File f = new File(filePath);
                    
                    if( !productValid.isImage( fName[1] ) ) {
                        this.sendError(request, response, "can't found image", "products-add.jsp");
                        return;
                    }
                    
                    f.createNewFile();

                    int content;
                    OutputStream outSt = new FileOutputStream(f);

                    do {
                        content = fileContent.read();
                        outSt.write(content);
                    } while (content != -1);

                    outSt.flush();
                    outSt.close();
                }

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
                entity.Product product = productFacade.findById( pId );
                if( product == null ) {
                    rd.forward(request, response);
                    return;
                } else {
                    if( product.getStatus() == 1 ) {
                        product.setStatus( 2 );
                    } else {
                        product.setStatus( 1 );
                    }
                    
                    productFacade.edit( product );
                    rd = request.getRequestDispatcher("Products?action=index");
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
