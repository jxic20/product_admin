/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dao;

import domain.Product;
import java.util.ArrayList;

/**
 *
 * @author monvi967
 */
public class Products_list {
    private static ArrayList<Product> productList = new ArrayList();
    private static ArrayList<String> categoryList = new ArrayList();
    
    public void add(Product pdt){
        productList.add(pdt);
        categoryList.add(pdt.getCategory());
    }
    
    public ArrayList<Product> get(){
        return productList;
    }
    
    public ArrayList<String> getCategories(){
        return categoryList;
    }
    
}
