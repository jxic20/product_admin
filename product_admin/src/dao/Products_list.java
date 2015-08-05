/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dao;

import domain.Product;
import java.util.*;

/**
 *
 * @author monvi967
 */
public class Products_list{
    private static Collection<Product>  productList = new TreeSet();
    private static Collection<String> categoryList = new TreeSet();
    private static Map<Integer, Product> productIDList = new HashMap();
    
    public void add(Product pdt){
        productList.add(pdt);
        categoryList.add(pdt.getCategory());
        productIDList.put(pdt.getProduct_ID(), pdt);
    }
    
    public void delete(Product pdt){
        productList.remove(pdt);
        categoryList.remove(pdt.getCategory());
        productIDList.remove(pdt.getProduct_ID());
    }
    
    public Product search_by_ID(Integer id){
        Product pdt = productIDList.get(id);
        if(pdt != null){
            return pdt;
        }
        return null;
    }
    
    
    public Collection<Product> get(){
        return productList;
    }
    
    public Collection<String> getCategories(){
        return categoryList;
    }
    
    public Map<Integer, Product> getProduct_IDs(){
        return productIDList;
    }
    
}
