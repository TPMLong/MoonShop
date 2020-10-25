/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.account;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class AccountDTO implements Serializable{
    String id;
    String password;
    String name;
    String role;
    String status;

    public AccountDTO() {
    }

    public AccountDTO(String role) {
        this.role = role;
    }   

    public AccountDTO(String name, String role) {
        this.name = name;
        this.role = role;
    }
    
    public AccountDTO(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
    
    public AccountDTO(String id, String password, String name, String role, String status) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
