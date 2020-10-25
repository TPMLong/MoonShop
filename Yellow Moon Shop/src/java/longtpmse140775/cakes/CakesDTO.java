/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.cakes;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ACER
 */
public class CakesDTO implements Serializable {

    private int productID;
    private String name;
    private float price;
    private int quantity;
    private int categoryID;
    private String image;
    private Date createDate;
    private Date expirationDate;
    private String statusID;
    private String category;
    private int numberCart;

    public CakesDTO() {
    }

    public CakesDTO(int productID, String name, float price, int quantity, int categoryID, String image, Date createDate, Date expirationDate) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.image = image;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
    }

    public CakesDTO(int productID, String name, float price, int quantity, String image, Date createDate, Date expirationDate, String statusID, String category) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.statusID = statusID;
        this.category = category;
    }

        public CakesDTO(int productID, String name, float price, int quantity, String image, Date createDate, Date expirationDate, String statusID, String category, int numberCart) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.statusID = statusID;
        this.category = category;
        this.numberCart = numberCart;
    }
    
    public CakesDTO(int productID, String name, float price, int quantity, int categoryID, String image, Date createDate, Date expirationDate, String statusID, String category, int numberCart) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.image = image;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.statusID = statusID;
        this.category = category;
        this.numberCart = numberCart;
    }

    public int getNumberCart() {
        return numberCart;
    }

    public void setNumberCart(int numberCart) {
        this.numberCart = numberCart;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

}
