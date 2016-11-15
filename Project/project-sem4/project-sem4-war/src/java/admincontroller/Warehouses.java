/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

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
import Valid.warehousesValid;
import entity.Users;
import javax.servlet.http.HttpSession;

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
    private void sendError(HttpServletRequest request, HttpServletResponse response, String msg, String page) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher(page);
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
        request.setAttribute("error_msg", msg);

        try {
            rd.forward(request, response);
            return;
        } catch (Exception ex) {
            throw new Exception("Can't find the specific path");
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
        String action = request.getParameter("action");
        Warehouse warehouse;
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

                if (warehousesValid.isEmpty(name)) {
                    this.sendError(request, response, "warehouse name must be fill", "warehouses-add.jsp");
                    return;
                }

                if (warehousesValid.isEmpty(address)) {
                    this.sendError(request, response, "warehouse address must be fill", "warehouses-add.jsp");
                    return;
                }

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
                int id = Integer.parseInt(request.getParameter("wId"));
                warehouse = warehouseFacade.findById(id);

                request.setAttribute("warehouse", warehouse);
                if (warehousesValid.isEmpty(name)) {
                    this.sendError(request, response, "warehouse name must be fill", "warehouses-edit.jsp");
                    return;
                }

                if (warehousesValid.isEmpty(address)) {
                    this.sendError(request, response, "warehouse address must be fill", "warehouses-edit.jsp");
                    return;
                }

                int status = Integer.parseInt(request.getParameter("status"));
                if (warehouseFacade.EditWarehouse(id, name, address, status)) {
                    rd = request.getRequestDispatcher("warehouses.jsp");
                } else {
                    rd.forward(request, response);
                    return;
                }
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("wid"));
                warehouse = warehouseFacade.find(id);

                if (warehouse.getStatus() == null) {
                    warehouse.setStatus(1);
                } else if (warehouse.getStatus() == 1) {
                    warehouse.setStatus(2);
                } else {
                    warehouse.setStatus(1);
                }

                if (warehouse == null) {
                    throw new Exception();
                }

                warehouseFacade.edit(warehouse);

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
