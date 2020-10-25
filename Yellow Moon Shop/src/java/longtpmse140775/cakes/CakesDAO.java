/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.cakes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.naming.NamingException;
import longtpmse140775.ultil.DBHelper;

/**
 *
 * @author ACER
 */
public class CakesDAO implements Serializable {

    private List<CakesDTO> listCake;

    public List<CakesDTO> getListCake() {
        return listCake;
    }

    private List<String> listCategory;

    public List<String> getListCategory() {
        return listCategory;
    }

    private List<String> listStatus;

    public List<String> getListStatus() {
        return listStatus;
    }

    private List<String> listProduct;

    public List<String> getListProduct() {
        return listProduct;
    }

    public int countPost() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(createDate) as countDate "
                        + "FROM tblProducts";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int num = rs.getInt("countDate");
                    if (num > 0) {
                        return num;
                    }
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
        return 0;
    }

    public void showPost(int count)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT productID, p.name, price, image, quantity, createDate, expirationDate, status, c.name "
                        + "FROM tblProducts as p, tblCategory as c "
                        + "WHERE p.categoryID = c.categoryID "
                        + "ORDER BY createDate DESC "
                        + "OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
                stm = con.prepareStatement(sql);
                stm.setInt(1, (count - 1) * 20);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");
                    String pname = rs.getString("name");
                    String cname = rs.getString(9);
                    float price = rs.getFloat("price");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    Date cDate = rs.getDate("createDate");
                    Date eDate = rs.getDate("expirationDate");
                    String status = rs.getString("status");
                    if (status.equals("active") && quantity > 0) {
                        CakesDTO dto = new CakesDTO(id, pname, price, quantity, image, cDate, eDate, status, cname);
                        if (this.listCake == null) {
                            this.listCake = new ArrayList();
                        }
                        this.listCake.add(dto);
                    }
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

    public void showPostPrice(int count, Float searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT productID, p.name, price, image, quantity, createDate, expirationDate, status, c.name "
                        + "FROM tblProducts as p, tblCategory as c "
                        + "WHERE p.categoryID = c.categoryID AND p.price LIKE ? "
                        + "ORDER BY createDate DESC "
                        + "OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
                stm = con.prepareStatement(sql);
                stm.setFloat(1, searchValue);
                stm.setInt(2, (count - 1) * 20);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");
                    String pname = rs.getString("name");
                    String cname = rs.getString(9);
                    float price = rs.getFloat("price");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    Date cDate = rs.getDate("createDate");
                    Date eDate = rs.getDate("expirationDate");
                    String status = rs.getString("status");
                    if (status.equals("active") && quantity > 0) {
                        CakesDTO dto = new CakesDTO(id, pname, price, quantity, image, cDate, eDate, status, cname);
                        if (this.listCake == null) {
                            this.listCake = new ArrayList();
                        }
                        this.listCake.add(dto);
                    }
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

    public void showPostCategory(int count, String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT productID, p.name, price, image, quantity, createDate, expirationDate, status, c.name "
                        + "FROM tblProducts as p, tblCategory as c "
                        + "WHERE p.categoryID = c.categoryID AND c.name LIKE ? "
                        + "ORDER BY createDate DESC "
                        + "OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setInt(2, (count - 1) * 20);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");
                    String pname = rs.getString("name");
                    String cname = rs.getString(9);
                    float price = rs.getFloat("price");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    Date cDate = rs.getDate("createDate");
                    Date eDate = rs.getDate("expirationDate");
                    String status = rs.getString("status");
                    if (status.equals("active") && quantity > 0) {
                        CakesDTO dto = new CakesDTO(id, pname, price, quantity, image, cDate, eDate, status, cname);
                        if (this.listCake == null) {
                            this.listCake = new ArrayList();
                        }
                        this.listCake.add(dto);
                    }
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

    public void showPostName(int count, String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT productID, p.name, price, image, quantity, createDate, expirationDate, status, c.name "
                        + "FROM tblProducts as p, tblCategory as c "
                        + "WHERE p.categoryID = c.categoryID AND p.name LIKE ? "
                        + "ORDER BY createDate DESC OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setInt(2, (count - 1) * 20);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");
                    String pname = rs.getString("name");
                    String cname = rs.getString(9);
                    float price = rs.getFloat("price");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    Date cDate = rs.getDate("createDate");
                    Date eDate = rs.getDate("expirationDate");
                    String status = rs.getString("status");
                    if (status.equals("active") && quantity > 0) {
                        CakesDTO dto = new CakesDTO(id, pname, price, quantity, image, cDate, eDate, status, cname);
                        if (this.listCake == null) {
                            this.listCake = new ArrayList();
                        }
                        this.listCake.add(dto);
                    }
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

    public void showDetailPost(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT productID, p.name, price, image, quantity, createDate, expirationDate, status, c.name "
                        + "FROM tblProducts as p, tblCategory as c "
                        + "WHERE p.categoryID = c.categoryID AND p.productID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, searchValue);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");
                    String pname = rs.getString("name");
                    String cname = rs.getString(9);
                    float price = rs.getFloat("price");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    Date cDate = rs.getDate("createDate");
                    Date eDate = rs.getDate("expirationDate");
                    String status = rs.getString("status");
                    if (status.equals("active") && quantity > 0) {
                        CakesDTO dto = new CakesDTO(id, pname, price, quantity, image, cDate, eDate, status, cname);
                        if (this.listCake == null) {
                            this.listCake = new ArrayList();
                        }
                        this.listCake.add(dto);
                    }
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

    public void getCaterogy()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT name FROM tblCategory as c";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cname = rs.getString("name");
                    if (this.listCategory == null) {
                        this.listCategory = new ArrayList();
                    }
                    this.listCategory.add(cname);
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

    public void getStatus()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT status FROM tblProducts as p";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String pStatus = rs.getString("status");
                    if (this.listStatus == null) {
                        this.listStatus = new ArrayList();
                    }
                    this.listStatus.add(pStatus);
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

    public boolean updateDetailPost(int id, String name, float price, int quantity, int category, String image, Date createDate, Date expirationDate, String status)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE tblProducts "
                        + "SET name = ?, price = ?, quantity = ?, categoryID = ?, image = ?, createDate = ?, expirationDate = ?, status = ? "
                        + "WHERE productID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setFloat(2, price);
                stm.setInt(3, quantity);
                stm.setInt(4, category);
                stm.setString(5, image);
                stm.setDate(6, createDate);
                stm.setDate(7, expirationDate);
                stm.setString(8, status);
                stm.setInt(9, id);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
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
        return false;
    }

    public int getCategoryID(String name)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT categoryID FROM tblCategory WHERE name = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int pStatus = rs.getInt("categoryID");
                    return pStatus;
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
        return 0;
    }

    public void showDetailCart(String searchValue, int number)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT productID, p.name, price, image, quantity, createDate, expirationDate, status, c.name "
                        + "FROM tblProducts as p, tblCategory as c "
                        + "WHERE p.categoryID = c.categoryID AND p.productID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, searchValue);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");
                    String pname = rs.getString("name");
                    String cname = rs.getString(9);
                    float price = rs.getFloat("price");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    Date cDate = rs.getDate("createDate");
                    Date eDate = rs.getDate("expirationDate");
                    String status = rs.getString("status");
                    if (status.equals("active") && quantity > 0) {
                        CakesDTO dto = new CakesDTO(id, pname, price, quantity, image, cDate, eDate, status, cname, number);
                        if (this.listCake == null) {
                            this.listCake = new ArrayList();
                        }
                        this.listCake.add(dto);
                    }
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

    public boolean checkQuantityCart(String searchValue, int number)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT quantity "
                        + "FROM tblProducts "
                        + "WHERE productID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, searchValue);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    if (number <= 0 || number > quantity) {
                        return false;
                    } else {
                        return true;
                    }
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
        return false;
    }

    public boolean updateHistory(String user, float total, String address)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Calendar cal = Calendar.getInstance();
        Year year = Year.now();
        int numYear = Integer.parseInt(year.toString());
        int month = cal.getInstance().get(Calendar.MONTH);
        int day = cal.getInstance().get(Calendar.DAY_OF_MONTH);
        String dates = numYear + "-" + month + "-" + day;
        Date date = Date.valueOf(dates);
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO tblOrder(userID, total, date, address) "
                        + "Values(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, user);
                stm.setFloat(2, total);
                stm.setDate(3, date);
                stm.setString(4, address);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
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
        return false;
    }

    public int getID()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT MAX(orderID) FROM tblOrder";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    return id;
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
        return 0;
    }

    public boolean updateHistoryDetail(int order, int product, float price, int quantity)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO tblOrderdetail(orderID, productID, price, quantity) "
                        + "Values(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, order);
                stm.setInt(2, product);
                stm.setFloat(3, price);
                stm.setInt(4, quantity);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
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
        return false;
    }

    public void showProductName(int searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT name FROM tblProducts WHERE productID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, searchValue);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    if (this.listProduct == null) {
                        this.listProduct = new ArrayList();
                    }
                    this.listProduct.add(name);
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
