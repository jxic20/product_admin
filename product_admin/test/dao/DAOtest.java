/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Jvic
 */


@RunWith(Parameterized.class)

public class DAOtest {
    private ProductsDatabaseManagement pdtCollectionsDAO;
    private Product prod1;
    private Product prod2;
    
    public DAOtest(ProductsDatabaseManagement pDAO) {
        pdtCollectionsDAO = pDAO;
    }
    
    @Parameterized.Parameters
    public static Collection<?> daoObjectsToTest() {
        return Arrays.asList(new Object[][]{
            {new ProductCollectionsDAO()},
            {new ProductsDatabaseManagement(
                "jdbc:h2:tcp://localhost/project-testing;IFEXISTS=TRUE")}
        });
    }

    public DAOtest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.prod1 = new Product();
        this.prod2 = new Product();
        //prod1
        this.prod1.setProduct_ID(1);
        this.prod1.setName("name1");
        this.prod1.setDescription("desc1");
        this.prod1.setCategory("cat1");
        this.prod1.setPrice(11.0);
        this.prod1.setStock_quantity(22);
        //prod2
        this.prod2.setProduct_ID(2);
        this.prod2.setName("name2");
        this.prod2.setDescription("desc2");
        this.prod2.setCategory("cat2");
        this.prod2.setPrice(33.0);
        this.prod2.setStock_quantity(44);
        
        pdtCollectionsDAO.add(prod1); 
        pdtCollectionsDAO.add(prod2);
    }
    
    @After
    public void tearDown() {
        pdtCollectionsDAO.delete(prod1); 
        pdtCollectionsDAO.delete(prod2);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testDaoSaveAndDelete(){
        Product savedProd = new Product();
        //savedprod
        savedProd.setProduct_ID(3);
        savedProd.setName("name");
        savedProd.setDescription("desc");
        savedProd.setCategory("cat");
        savedProd.setPrice(1.0);
        savedProd.setStock_quantity(2);
        
        pdtCollectionsDAO.add(savedProd);
        Product retrieved = pdtCollectionsDAO.search_by_ID(3);
        assertEquals("Retrieved product should be the same as the saved one",
                savedProd, retrieved);
       pdtCollectionsDAO.delete(savedProd);
        retrieved = pdtCollectionsDAO.search_by_ID(3);
        assertNull("Product should no longer exist", retrieved);
        
    }
    
    @Test
    public void testDaoGetAll(){
        Collection<Product> products = pdtCollectionsDAO.get();
        
        assertTrue("prod1 should exist", products.contains(prod1));
        assertTrue("prod2 should exist", products.contains(prod2));
        
        assertEquals("Only 2 products in result", 2, products.size());
        
        for (Product p : products){
            if (p.equals(prod1)){
                assertEquals(prod1.getProduct_ID(), p.getProduct_ID());
                assertEquals(prod1.getName(), p.getName());
                assertEquals(prod1.getDescription(), p.getDescription());
                assertEquals(prod1.getCategory(), p.getCategory());
                assertEquals(prod1.getPrice(), p.getPrice());
                assertEquals(prod1.getStock_quantity(), p.getStock_quantity());
            }  
        }       
    }
    
    @Test
    public void testDaoFindByID(){
        Product pdt = pdtCollectionsDAO.search_by_ID(1);
        Product x;
        if(prod1.equals(pdt) && prod1 != null){
            x = pdtCollectionsDAO.search_by_ID(999);
            assertTrue("x should not exist", x == null); 
        }
    }
}
