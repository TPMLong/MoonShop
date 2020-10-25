/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.account;

import java.io.Serializable;
import longtpmse140775.ultil.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ACER
 */
public class AccountDAO implements Serializable{

    private String username;

    public String getUsername() {
        return username;
    }

    private AccountDTO user;

    public AccountDTO getUser() {
        return user;
    }

    public void setUser(AccountDTO user) {
        this.user = user;
    }
    
    String role = new String();

    public String getRole() {
        return role;
    }
    
    AccountDTO users = new AccountDTO();
    
    public boolean checkLogin(String id, String password)
            throws NamingException, SQLException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select userID, tblUsers.name, password, tblUsers.roleID, tblRoles.name From tblUsers, tblRoles Where userID = ? and password = ? and tblUsers.roleID = tblRoles.roleID";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);           
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    role = rs.getString(5);
                    username = rs.getString(2);
                    users = new AccountDTO(username, role);
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
    
     public String getAddress(String name)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select address From tblUsers Where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);           
                rs = stm.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("address");
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
        return null;
    }
}
