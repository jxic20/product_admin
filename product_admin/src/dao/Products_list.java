/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dao;

import domain.Product;
import java.util.*;
import gui.Product_entry;

/**
 *
 * @author monvi967
 */
public class Products_list{
    private static Collection<Product>  productList = new TreeSet();
    //private static Collection<String> categoryList = new TreeSet();
    private static Map<Integer, Product> productIDList = new HashMap();
    private static Map<String, Set<Product>> productCatSet = new HashMap();
    
    
    /*adding products to Category Set*/
    public void addToSet(Product pdt, Integer id){
        String cat = pdt.getCategory();
        Set<Product> newPSet = new HashSet();
        
        if ((productCatSet.get(cat)) == null){
            newPSet.add(pdt);
            productCatSet.put(pdt.getCategory(), newPSet);
            if((!"non".equals(Product_entry.selcat)) /*|| !pdt.getCategory().equals(Product_entry.selcat)*/){
                productCatSet.remove(Product_entry.selcat);
                Product_entry.selcat = "non";
                
                
                
                
            }
        } else {
            (productCatSet.get(cat)).add(pdt);
        }
    }
    
    public Set<String> getKS(){
        
        return productCatSet.keySet();
    }
    
    public void deleteFromCat(Product pdt){
        //(productCatSet.get(pdt.getCategory())).remove(pdt);
        //if( productCatSet.get(pdt.getCategory()) == null){
        //    productCatSet.remove(pdt.getCategory());
        //}
    }
    
    /*retrieving products from category set via category name*/
    public Set<Product> getCatSet(String cat){
        return productCatSet.get(cat);
    }
    
    public void add(Product pdt){
        productList.add(pdt);
        addToSet(pdt, pdt.getProduct_ID());
        //categoryList.add(pdt.getCategory());
        productIDList.put(pdt.getProduct_ID(), pdt);
        
    }
    
    public void delete(Product pdt){
        productList.remove(pdt);
        //categoryList.remove(pdt.getCategory());
        productIDList.remove(pdt.getProduct_ID());
        //deleteFromCat(pdt);
        
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
    
    //public Collection<String> getCategories(){
    //    return categoryList;
    //}
    
    public Map<Integer, Product> getProduct_IDs(){
        return productIDList;
    }
    
}
