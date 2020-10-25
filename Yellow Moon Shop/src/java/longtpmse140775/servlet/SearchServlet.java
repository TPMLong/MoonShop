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
import longtpmse140775.cart.CartDAO;
import longtpmse140775.cart.CartDTO;
import org.apache.log4j.Logger;

/**
 *
 * @author ACER
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    private final String HISTORY_PAGE = "history.jsp";
    private final String SEARCH_PAGE = "search.jsp";
    private final Logger LOGGER = Logger.getLogger(SearchServlet.class);

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
        String searchValue = request.getParameter("txtSearch");
        String searchcbx = request.getParameter("cboBook");
        String url = SEARCH_PAGE;

        try {
            // HttpSession session = request.getSession(false);
            CakesDAO dao = new CakesDAO();
//            if (session != null) {
            if (!searchValue.trim().equals("") && searchcbx.equals("category")) {
                dao.showPostCategory(1, searchValue);
                List<CakesDTO> result = dao.getListCake();
                //request.setAttribute("SEARCHVALUE", searchValue);
                request.setAttribute("SEARCHRESULTS", result);
            } else {
                if (!searchValue.trim().equals("") && searchcbx.equals("name")) {
                    dao.showPostName(1, searchValue);
                    List<CakesDTO> result = dao.getListCake();
                    //  request.setAttribute("SEARCHVALUE", searchValue);
                    request.setAttribute("SEARCHRESULTS", result);

                } else {
                    if (!searchValue.trim().equals("") && searchcbx.equals("price")) {
                        dao.showPostPrice(1, Float.parseFloat(searchValue));
                        List<CakesDTO> result = dao.getListCake();
                        //  request.setAttribute("SEARCHVALUE", searchValue);
                        request.setAttribute("SEARCHRESULTS", result);
                    } else {
                        CartDAO daos = new CartDAO();
                        daos.showOrderID(Integer.parseInt(searchValue));
                        daos.showProductID(Integer.parseInt(searchValue));
                        List<CartDTO> result = daos.getListCake();
                        List<String> results = daos.getListProduct();
                        for (String result1 : results) {
                            int num = Integer.parseInt(result1);
                            dao.showProductName(num);
                        }
                        List<String> name = dao.getListProduct();
                        request.setAttribute("SEARCHRESULT", result);                        
                        request.setAttribute("SEARCHRESULTS", name);
                        url = HISTORY_PAGE;
                    }

                }
            }

//                url = VIEW_PAGE;
//            } else {
//                url = LOGIN_PAGE;
//            }
        } catch (NamingException ex) {
            LOGGER.info("SearchServlet_NamingException: " + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.info("SearchServletl_SQLException: " + ex.getMessage());
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
