/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import entity.Users;
import entity.Warehouse;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.UsersFacadeLocal;
import sessionbean.WarehouseFacadeLocal;
import Valid.ValidData;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cgc_Shyn
 */
public class Admin extends HttpServlet {

    @EJB
    private WarehouseFacadeLocal warehouseFacade;
    @EJB
    private UsersFacadeLocal usersFacade;

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
                List<Users> userList;
                userList = usersFacade.findAll();
                request.setAttribute("userlist", userList);
                rd = request.getRequestDispatcher("users.jsp");
            } else if (action.equals("add")) {
                List<Warehouse> wareList;
                wareList = warehouseFacade.findAll();
                request.setAttribute("wareList", wareList);
                rd = request.getRequestDispatcher("users-add.jsp");
            } else if (action.equals("checkadd")) {
                List<Warehouse> wareList;
                wareList = warehouseFacade.findAll();
                request.setAttribute("wareList", wareList);
                String username = request.getParameter("username");
                String pass = request.getParameter("password");
                String repass = request.getParameter("repassword");
                String role = request.getParameter("roles");
                boolean ok = true;

                if (ValidData.isEmpty(username)) {
                    sendError(request, response, "user name must be fill", "users-add.jsp");
                    ok = false;
                    return;
                }

                if (ValidData.isEmpty(pass) || ValidData.isPassword(pass)) {
                    sendError(request, response, "password invalid", "users-add.jsp");
                    ok = false;
                    return;
                }

                if (!pass.equals(repass)) {
                    sendError(request, response, "password invalid", "users-add.jsp");
                    ok = false;
                    return;
                }

                if (role.equals("1")) {
                    role = "Super Admin";
                } else if (role.equals("2")) {
                    role = "Admin";
                } else {
                    rd.forward(request, response);
                    return;
                }
                int id = Integer.parseInt(request.getParameter("warehouse"));
                Warehouse warehouse = warehouseFacade.findById(id);
                if (warehouse == null) {
                    rd.forward(request, response);
                    return;
                }
                if (usersFacade.AddUser(username, pass, repass, role, warehouse)) {
                    List<Users> userList;
                    userList = usersFacade.findAll();
                    request.setAttribute("userlist", userList);
                    rd = request.getRequestDispatcher("users.jsp");
                } else {
                    this.sendError(request, response, "user already exist", "users-add.jsp");
                    return;
                }
            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("uId"));
                Users user = usersFacade.findById(id);
                request.setAttribute("user", user);
                List<Warehouse> wareList;
                wareList = warehouseFacade.findAll();
                request.setAttribute("wareList", wareList);
                rd = request.getRequestDispatcher("users-edit.jsp");
            } else if (action.equals("checkEdit")) {
                int id = Integer.parseInt(request.getParameter("uId"));
                String role = request.getParameter("role");
                if (role.equals("1")) {
                    role = "Super Admin";
                } else if (role.equals("2")) {
                    role = "Admin";
                } else {
                    rd.forward(request, response);
                    return;
                }
                int wareid = Integer.parseInt(request.getParameter("warehouse"));
                Warehouse warehouse = warehouseFacade.findById(wareid);
                if (warehouse == null) {
                    rd.forward(request, response);
                    return;
                }
                if (usersFacade.EditUser(id, role, warehouse)) {
                    rd = request.getRequestDispatcher("Admin?action=index");
                } else {
                    rd.forward(request, response);
                    return;
                }
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("uId"));
                if (!usersFacade.remove(id)) {
                    rd.forward(request, response);
                    return;
                } else {
                    rd = request.getRequestDispatcher("Admin?action=index");
                }
            } else if (action.equals("signOut")) {
                session.removeAttribute("User");
                session.removeAttribute("Customer");
                response.sendRedirect(request.getContextPath() + "/web/Home");
                return;
            }
            rd.forward(request, response);
        } catch (Exception e) {
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
