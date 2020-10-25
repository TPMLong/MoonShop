/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtpmse140775.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class CartObject implements Serializable {

    private Map<String, Integer> items;

    public CartObject() {
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String title, int num) {
        if (title == null) {
            return;
        }

        if (title.trim().isEmpty()) {
            return;
        }

        if (this.items == null) {
            this.items = new HashMap<>();
        }

        
        if (this.items.containsKey(title)) {
            num = this.items.get(title) + num;
        }

        this.items.put(title, num);
    }

    public void removeItemFromCart(String title) {
        if (this.getItems() == null) {
            return;
        }
        if (this.getItems().containsKey(title)) {
            this.getItems().remove(title);
            if (this.getItems().isEmpty()) {
                this.items = null;
            }
        }
    }

    public void updateQuantity(String title, int quantity) {
        if (this.getItems() == null) {
            return;
        }

        if (this.getItems().containsKey(title)) {
            if (quantity == 0) {
                removeItemFromCart(title);
            } else if (quantity > 0) {
                this.getItems().put(title, quantity);
            }
        }
    }
}
