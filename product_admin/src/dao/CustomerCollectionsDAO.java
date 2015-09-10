/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.util.*;

/**
 *
 * @author Jvic
 */
public class CustomerCollectionsDAO {
    
    private static Set<Customer> customerCatSet = new HashSet();
    
    public void save(Customer ctr){
        customerCatSet.add(ctr);
        System.out.print(ctr.toString());
    }
}
