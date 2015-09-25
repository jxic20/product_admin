/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author monvi967
 */
public class OrderItem {
    public Integer quantity_purchased;
    public Double purchase_price;
    public Integer p_id;
    public Integer s_id;

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public Integer getS_id() {
        return s_id;
    }
    
    

    public Integer getQuantity_purchased() {
        return quantity_purchased;
    }

    public void setQuantity_purchased(Integer quantity_purchased) {
        this.quantity_purchased = quantity_purchased;
    }

    public Double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(Double purchase_price) {
        this.purchase_price = purchase_price;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "quantity_purchased=" + quantity_purchased + ", purchase_price=" + purchase_price + '}';
    }   
}
