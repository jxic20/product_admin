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
 * @author Jvic
 */
public interface ProductCollectionsInterface {
    //private void addToSet(Product pdt);
    //private Set<String> getKS();   
    /*retrieving products from category set via category name*/
    public Set<Product> getCatSet(String cat); 
    public void add(Product pdt); 
    public void delete(Product pdt); 
    public Product search_by_ID(Integer id);
    public Collection<Product> get();
    public Collection<String> getCategories();
//    public Map<Integer, Product> getProduct_IDs();
}
