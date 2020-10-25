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
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import longtpmse140775.cakes.CakesDAO;
import longtpmse140775.cakes.CakesDTO;
import longtpmse140775.cart.CartObject;
import org.apache.log4j.Logger;

/**
 *
 * @author ACER
 */
@WebServlet(name = "DeleteCartServlet", urlPatterns = {"/DeleteCartServlet"})
public class DeleteCartServlet extends HttpServlet {

    private final String SHOW_PAGE = "cartShow";
    private final Logger LOGGER = Logger.getLogger(DeleteCartServlet.class);

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
        /* TODO output your page here. You may use following sample code. */
        String url = SHOW_PAGE;
        String removeCart = request.getParameter("removeCart");
        float total = 0;
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                CartObject cart = (CartObject) session.getAttribute("CART");
                if (cart != null) {
                    CakesDAO dao = new CakesDAO();
                    cart.removeItemFromCart(removeCart);
                    Map<String, Integer> name = cart.getItems();
                    if (cart.getItems() != null) {
                        for (String key : name.keySet()) {
                            dao.showDetailCart(key, name.get(key));
                            session.setAttribute("CART", cart);
                            List<CakesDTO> result = dao.getListCake();
                            for (CakesDTO cakesDTO : result) {
                                total = total + cakesDTO.getPrice() * cakesDTO.getNumberCart();
                            }
                            session.setAttribute("CAKEDETAIL", result);
                            session.setAttribute("PRICE", total);
                        }
                    }else{
                        String mess = "EMPTY CART";
                        session.setAttribute("NULLDETAIL", mess);
                    }
                }
            }
        } catch (NamingException ex) {
            LOGGER.info("DeleteCartServlet_NamingException: " + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.info("DeleteCartServlet_SQLException: " + ex.getMessage());
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
