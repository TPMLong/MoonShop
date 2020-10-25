/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.cart;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ACER
 */
public class CartDTO implements Serializable{
    private int orderId;
    private String userId;
    private float total;
    private Date date;
    private String name;
    private String address;
    private int detailId;
    private int productId;
    private float price;
    private int quantity;

    public CartDTO() {
    }

    public CartDTO(int orderId, String userId, Date date, String address) {
        this.orderId = orderId;
        this.userId = userId;
        this.date = date;
        this.address = address;
    }
    
    

    public CartDTO(int orderId, String userId, float total, Date date, String name, String address, int detailId, int productId, float price, int quantity) {
        this.orderId = orderId;
        this.userId = userId;
        this.total = total;
        this.date = date;
        this.name = name;
        this.address = address;
        this.detailId = detailId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
