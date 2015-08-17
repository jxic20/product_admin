/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;


/**
 *
 * @author monvi967
 */
public class Product implements Comparable<Product>{
    public Integer product_ID;
    public String name;
    public String description;
    public String category;
    public Double price;
    public Integer stock_quantity;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.product_ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.product_ID, other.product_ID)) {
            return false;
        }
        return true;
    }
    
    
    
    /*compare method*/
    @Override
    public int compareTo(Product anotherProduct){
        Integer a = this.getProduct_ID();
        Integer b = anotherProduct.getProduct_ID();
        return a.compareTo(b);
    }
    
    

    public Integer getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        this.product_ID = product_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "product_ID=" + product_ID + ", name=" + name + '}';
    }
    
    
    
    
    
}
