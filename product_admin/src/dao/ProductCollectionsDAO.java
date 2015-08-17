/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dao;

import domain.Product;
import java.util.*;
//import gui.Product_entry;

/**
 *
 * @author monvi967
 */
public class ProductCollectionsDAO implements ProductCollectionsInterface{
//    private static Collection<Product>  productList = new TreeSet();
//    private static Collection<String> categoryList = new TreeSet();
    private static Map<Integer, Product> productIDList = new HashMap();
    private static Map<String, Set<Product>> productCatSet = new HashMap();
    
    
    /*adding products to Category Set*/
    
    private void addToSet(Product pdt){
        String cat = pdt.getCategory();
        Set<Product> newPSet = new HashSet();
        
        // does category exist?
        if ((productCatSet.get(cat)) == null){
            // nope
            newPSet.add(pdt);
            productCatSet.put(pdt.getCategory(), newPSet);

        } else {
            productCatSet.get(cat).add(pdt);
            
        }
    }
    
    
    private Set<String> getKS(){
        
        return productCatSet.keySet();
    }
    @Override
    
    /*retrieving products from category set via category name*/
    public Set<Product> getCatSet(String cat){
        return productCatSet.get(cat);
    }
    @Override
    
    public void add(Product pdt){
//        productList.add(pdt);
        addToSet(pdt);
//        categoryList.add(pdt.getCategory());
        productIDList.put(pdt.getProduct_ID(), pdt);
        
    }
    @Override
    public void delete(Product pdt){
//        productList.remove(pdt);
//        categoryList.remove(pdt.getCategory());
        productIDList.remove(pdt.getProduct_ID());
//        deleteFromCat(pdt);
        
    }
    @Override
    
    public Product search_by_ID(Integer id){
        Product pdt = productIDList.get(id);
        if(pdt != null){
            return pdt;
        }
        return null;
    }
    @Override
    
    
    public Collection<Product> get(){
        return productIDList.values();
    }
    @Override
    
    public Collection<String> getCategories(){
       return getKS();
    }
    
    public Map<Integer, Product> getProduct_IDs(){
        return productIDList;
    }
    
}
