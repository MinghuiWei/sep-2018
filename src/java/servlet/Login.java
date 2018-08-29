/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DB;
import dto.Tuser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String result = "no";
        String loginName = req.getParameter("loginName");
        String loginPw = req.getParameter("loginPw");
        System.out.println("loginName is:" + loginName);
        System.out.println("loginPw is:" + loginPw);
        String sql = "select * from users where  username=? and password=?";
        Object[] params = {loginName, loginPw};
        Tuser user = null;
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            boolean mark = (rs == null || !rs.next() ? false : true);
            if (mark == false) {
                result = "no";
            }
            if (mark == true) {
                user = new Tuser();
                user.setFirstname(rs.getString("first_name"));
                user.setId(rs.getString("id"));
                user.setLastname(rs.getString("last_name"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                result = "yes";
                req.getSession().setAttribute("user", user);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();

        if (result.equalsIgnoreCase("yes")) {
            req.setAttribute("message", "login success");
            String targetURL = "/login_success.jsp";
            req.getRequestDispatcher(targetURL).forward(req, res);
        } else {
            req.setAttribute("message", "faild");

            String targetURL = "/login_fail.jsp";
            req.getRequestDispatcher(targetURL).forward(req, res);
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
