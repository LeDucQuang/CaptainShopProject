/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import Valid.ValidData;
import entity.Warehouse;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.WarehouseFacadeLocal;

/**
 *
 * @author Cgc_Shyn
 */
public class Warehouses extends HttpServlet {

    @EJB
    private WarehouseFacadeLocal warehouseFacade;

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
        Warehouse warehouse;
        ValidData valid = new ValidData();
        if (action == null) {
            action = "index";
        }
        try {
            if (action.equals("index")) {
                List<Warehouse> warehouseList;
                warehouseList = warehouseFacade.findAll();
                request.setAttribute("warehouselist", warehouseList);
                rd = request.getRequestDispatcher("warehouses.jsp");
            } else if (action.equals("add")) {
                rd = request.getRequestDispatcher("warehouses-add.jsp");
            } else if (action.equals("checkadd")) {
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                int status = Integer.parseInt(request.getParameter("status"));
                if (warehouseFacade.AddWarehouse(name, address, status)) {
                    List<Warehouse> warehouseList;
                    warehouseList = warehouseFacade.findAll();
                    request.setAttribute("warehouselist", warehouseList);
                    rd = request.getRequestDispatcher("warehouses.jsp");
                } else {
                    rd.forward(request, response);
                    return;
                }

            } else if (action.equals("details")) {
                int id = Integer.parseInt(request.getParameter("wId"));
                warehouse = warehouseFacade.findById(id);
                // validator data(){} add after
                if (warehouse == null) {
                    rd.forward(request, response);
                    return;
                }
                request.setAttribute("warehouse", warehouse);
                rd = request.getRequestDispatcher("warehouses-details.jsp");
            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("wId"));
                warehouse = warehouseFacade.findById(id);
                request.setAttribute("warehouse", warehouse);
                rd = request.getRequestDispatcher("warehouses-edit.jsp");
            } else if (action.equals("checkEdit")) {
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                if (name == null || address == null || name.trim().equals("") || address.trim().equals("")) {
                    rd.forward(request, response);
                    return;
                }
                int id = Integer.parseInt(request.getParameter("wId"));
                if (warehouseFacade.EditWarehouse(id, name, address)) {
                    rd = request.getRequestDispatcher("warehouses.jsp");
                } else {
                    rd.forward(request, response);
                    return;
                }
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("wId"));
                warehouseFacade.remove(id);
                List<Warehouse> warehouseList;
                warehouseList = warehouseFacade.findAll();
                request.setAttribute("warehouselist", warehouseList);
                rd = request.getRequestDispatcher("warehouses.jsp");
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
