
import dao.ProductsDatabaseManagement;
import gui.MainMenu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monvi967
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductsDatabaseManagement jdbcDAO = new ProductsDatabaseManagement();
        MainMenu mainMenu = new MainMenu(jdbcDAO);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
        
        
    }
    
}
