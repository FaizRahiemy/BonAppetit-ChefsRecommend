/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Novak
 */
public class Application {

    Game game = new Game();
    Scanner n = new Scanner(System.in);
    Scanner a = new Scanner(System.in);

    public void credits() {
        System.out.println("Bon Appetit Credits");
        System.out.println("Chef de Cuisine : Ubassy Abdillah");
        System.out.println("Sous Chef       : Mohammad Zakie Faiz Rahiemy");
        System.out.println("Chef de Parte   : Raja Ryan Pradana");
        System.out.println();
        System.out.println("press anykeys to back");
        char next = a.next().charAt(0);
    }

    public void menu() throws IOException {
        int pil;
        do {
            System.out.println("Bon Appetit");
            System.out.println("1. New Game");
            System.out.println("2. Load Game");
            System.out.println("3. Credits");
            System.out.println("0. Close");
            System.out.print("Input : ");
            try {
                pil = n.nextInt();
                if (pil == 1) {
                    game.newPlay();
                } else if (pil == 2) {
                    game.loadPlay();
                } else if (pil == 3) {
                    credits();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Wrong input");
                pil = 0;
            }
        } while (pil != 0);
    }
}
