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
    
    public void add(Product pdt){
        productList.add(pdt);
    }
    
    public ArrayList<Product> getProductList(){
        return productList;
    }
    
}
