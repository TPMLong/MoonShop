/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.cart;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import longtpmse140775.ultil.DBHelper;

/**
 *
 * @author ACER
 */
public class CartDAO implements Serializable{

    private List<CartDTO> listCart;

    public List<CartDTO> getListCake() {
        return listCart;
    }

    private List<String> listProduct;

    public List<String> getListProduct() {
        return listProduct;
    }

    public void showOrderID(int searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT p.orderID, p.userID , p.date, p.address FROM tblOrder as p WHERE p.orderID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, searchValue);

                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String pname = rs.getString(2);
                    Date cDate = rs.getDate(3);
                    String address = rs.getString(4);
                    CartDTO dto = new CartDTO(id, pname, cDate, address);
                    if (this.listCart == null) {
                        this.listCart = new ArrayList();
                    }
                    this.listCart.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }

    public void showProductID(int searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT c.productID FROM tblOrder as p, tblOrderdetail as c WHERE p.orderID = c.orderID AND p.orderID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, searchValue);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int num = rs.getInt(1);
                    String id = String.valueOf(num);
                    if (this.listProduct == null) {
                        this.listProduct = new ArrayList();
                    }
                    this.listProduct.add(id);
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
