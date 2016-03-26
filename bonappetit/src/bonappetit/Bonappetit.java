/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

import java.io.IOException;


/**
 *
 * @author Novak
 */
public class Bonappetit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        Game game = new Game();
        
        game.loadPlay();
        // we serve you the best, happy bon appetit
    }
    
}
