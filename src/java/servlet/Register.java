/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.ProjectUtil;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

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
        req.setCharacterEncoding("utf-8");
        res.setCharacterEncoding("utf-8");

        String firstname = req.getParameter("firstname");//浠庨〉闈㈡帴鍙楃殑鐢ㄦ埛鍚�
        String lastname = req.getParameter("lastname");//瀵嗙爜
        String username = req.getParameter("username");//鐢佃瘽
        String password = req.getParameter("password");//鍦板潃锛岃璇嗚嫳鏂囧氨鐭ラ亾鍚箟

        if (ProjectUtil.juadge(username.trim()).equalsIgnoreCase("-1")) {
            String sql = "insert into users (first_name,last_name,username,password) values(?,?,?,?) "; //杩欎釜灏辨槸涓�涓猻ql insert 璇彞
            Object[] params = {firstname, lastname, username, password};
            DB mydb = new DB();
            mydb.doPstm(sql, params);//鎵ц
            mydb.closed();
            req.setAttribute("message", "register success锛�:" + username + ";password is锛氾細" + password);//鎻愮ず浣犳敞鍐屾垚鍔�
            String targetURL = "/login_success.jsp";
            req.getRequestDispatcher(targetURL).forward(req, res);
        } else {
            req.setAttribute("message", "username has already exists!!!!");
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
