/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import longtpmse140775.account.AccountDAO;
import longtpmse140775.cakes.CakesDAO;

import org.apache.log4j.Logger;

/**
 *
 * @author ACER
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {//v thi chua co code ma + jsp vao a

    private final String SEARCH_PAGE = "showPost";
    private final String UPDATE_PAGE = "update";
    private final String INVALID_PAGE = "invalid";
    private final Logger LOGGER = Logger.getLogger(LoginServlet.class);

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
        PrintWriter out = response.getWriter();
        String url = INVALID_PAGE;

        try {
            String username = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            AccountDAO dao = new AccountDAO();
            boolean result = dao.checkLogin(username, password);
            if (result) {             
//                ArticleDAO daos = new ArticleDAO();
                //           int num = daos.countPost();
                //             int pageNum = num / 20;
                String admin = dao.getRole();
                String name = dao.getUsername();
                CakesDAO daos = new CakesDAO();
                daos.showPost(1);
                HttpSession session = request.getSession();
                session.setAttribute("ADMIN", admin);
                session.setAttribute("NAME", name);
                if(admin.equals("Admin")){
                    url = UPDATE_PAGE;
                }else{
                    if(admin.equals("Member")){
                        url = SEARCH_PAGE;
                    }
                }
            }
        } catch (NamingException ex) {
            LOGGER.info("LoginServlet_NamingException: " + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.info("LoginServlet_SQLException: " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
            out.close();
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
