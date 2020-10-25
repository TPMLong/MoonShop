/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import longtpmse140775.cakes.CakesDAO;
import longtpmse140775.cakes.CakesDTO;

import org.apache.log4j.Logger;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ShowPostServlet", urlPatterns = {"/ShowPostServlet"})
public class ShowPostServlet extends HttpServlet {

    private final String SEARCH_PAGE = "search.jsp";
    //private final String LOGIN_PAGE = "try";
    private final Logger LOGGER = Logger.getLogger(ShowPostServlet.class);

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
        //int numPages = Integer.parseInt(request.getParameter("hiddencount"));
        //String url = LOGIN_PAGE;
        //System.out.println(numPages);
        String url = SEARCH_PAGE;
        try {

            CakesDAO dao = new CakesDAO();
            int num = dao.countPost();
            int pageNum = num / 20;
            System.out.println(pageNum);
            //if(num > 0 && num < 20){
                dao.showPost(1);
                request.setAttribute("PAGE", pageNum);
            //}else{
               // if(num >= 20){
                 //   int pageNum = num / 20;
                  //  dao.showPost(pageNum + 1);
                  //  request.setAttribute("PAGE", pageNum);
               // }
           // }

            List<CakesDTO> result = dao.getListCake();
            
            request.setAttribute("SHOWRESULT", result);
        } catch (NamingException ex) {
            LOGGER.info("ShowPostServlet_NamingException: " + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.info("ShowPostServlet_SQLException: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
