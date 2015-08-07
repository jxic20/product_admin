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
//            if(Product_entry.selcat != null || !pdt.getCategory().equals(Product_entry.selcat)){
//                productCatSet.remove(Product_entry.selcat);
//                System.out.println("list is null" + Product_entry.selcat + " " + productCatSet.keySet() );
//                Product_entry.selcat = null;
//                System.out.println("list is null" + Product_entry.selcat);
//            }
        } else {
            System.out.println("list not null" + Product_entry.selcat);
            
           
//            if((productCatSet.get(Product_entry.selcat)).contains(Product_entry.p) || (productCatSet.get(Product_entry.selcat)).size() == 1){
//                System.out.println("list not null" + Product_entry.selcat + " > " + productCatSet.get(Product_entry.selcat).size() + productCatSet.keySet());
//                (productCatSet.get(Product_entry.selcat)).clear();
//                Product_entry.p = new Product();
//                if(productCatSet.get(Product_entry.selcat).size() < 1){
//                    System.out.println("list not null rem" + Product_entry.selcat + "," + productCatSet.get(Product_entry.selcat).size() + " " + Product_entry.p + " "+ productCatSet.keySet());
//                    //productCatSet.remove(Product_entry.selcat);
//                    //categoryList.remove(Product_entry.selcat);
//                    //System.out.println("list not null rem" + " "+ productCatSet.keySet());
//                    Product_entry.selcat = null;
//                }
//            
//            }
            

            productCatSet.get(cat).add(pdt);
            
        }
    }
    
    private Set<String> getKS(){
        
        return productCatSet.keySet();
    }
    
    private void deleteFromCatSeT(Product pdt){
        System.out.println("dell" + Product_entry.selcat);
        
//        getKS
        //productCatSet.remove(Product_entry.selcat);
        
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
//        productList.add(pdt);
        addToSet(pdt);
//        categoryList.add(pdt.getCategory());
        productIDList.put(pdt.getProduct_ID(), pdt);
        
    }
    
    public void delete(Product pdt){
//        productList.remove(pdt);
//        categoryList.remove(pdt.getCategory());
        productIDList.remove(pdt.getProduct_ID());
//        deleteFromCat(pdt);
        
    }
    
    public Product search_by_ID(Integer id){
        Product pdt = productIDList.get(id);
        if(pdt != null){
            return pdt;
        }
        return null;
    }
    
    
    public Collection<Product> get(){
        return productIDList.values();
    }
    
    public Collection<String> getCategories(){
       return getKS();
    }
    
    public Map<Integer, Product> getProduct_IDs(){
        return productIDList;
    }
    
}
