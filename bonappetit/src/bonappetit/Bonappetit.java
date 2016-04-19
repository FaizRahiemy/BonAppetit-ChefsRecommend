/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

import controller.ControllerMainMenu;
import java.io.IOException;
import model.ConsoleApplication;

/**
 *
 * @author Novak
 */
public class Bonappetit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ConsoleApplication app = new ConsoleApplication();
//        app.menu();

        ControllerMainMenu cm = new ControllerMainMenu();
        
        // we serve you the best, happy bon appetit
    }
    
}
