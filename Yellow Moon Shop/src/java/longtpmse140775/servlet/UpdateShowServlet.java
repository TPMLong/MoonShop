/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import longtpmse140775.cakes.CakesDAO;
import org.apache.log4j.Logger;

/**
 *
 * @author ACER
 */
@WebServlet(name = "UpdateShowServlet", urlPatterns = {"/UpdateShowServlet"})
public class UpdateShowServlet extends HttpServlet {
    private final String UPDATE_PAGE = "update";
    private final Logger LOGGER = Logger.getLogger(UpdateShowServlet.class);
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
        int id = Integer.parseInt(request.getParameter("txtID"));
        String name = request.getParameter("txtName");
        Float price = Float.parseFloat(request.getParameter("txtPrice"));
        int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        String image = request.getParameter("txtImage");
        Date createDate = Date.valueOf(request.getParameter("txtCreateDay"));
        Date expirationDate = Date.valueOf(request.getParameter("txtExpirationDay"));
        String category = request.getParameter("cbxCaterogy");
        String status = request.getParameter("cbxStatus");     
        String url = UPDATE_PAGE;
        try {
              CakesDAO dao = new CakesDAO();
              int categoryID = dao.getCategoryID(category);
              dao.updateDetailPost(id, name, price, quantity, categoryID, image, createDate, expirationDate, status);
        } catch (NamingException ex) {
            LOGGER.info("UpdateShowServlet_NamingException: " + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.info("UpdateShowServlet_SQLException: " + ex.getMessage());
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
