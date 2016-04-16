/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import IOPackage.IOFile;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.MainMenu;

/**
 *
 * @author Novak
 */
public class ControllerMainMenu implements ActionListener {
    MainMenu menu;
    Game game;
    IOFile file;
    
    public ControllerMainMenu() {
        menu = new MainMenu();
        game = new Game();
        file = new IOFile();
        menu.setResizable(false);
        menu.getBtnCredit().addActionListener(this);
        menu.getBtnNew().addActionListener(this);
        menu.getBtnLoad().addActionListener(this);
        menu.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if (x.equals(menu.getBtnCredit())) {
            ControllerCredit cc = new ControllerCredit();
            menu.dispose();
            //cc.show();
        } else if (x.equals(menu.getBtnNew())) {
            ControllerNewGame cng = new ControllerNewGame();
            menu.dispose();
        } else if (x.equals(menu.getBtnLoad())) {
            game.setAsset(null);
            try {
                game.setAsset((Asset[]) file.loadFile());
            } catch (IOException ex) {
                System.out.println("error");
            }

            if (game.getAsset() == null) {
                System.out.println("No save file");
            } else {
                int dead = 0;
                for (int i = 0; i < game.getAsset().length; i++) {
                    if (game.getAsset()[i] == null) {
                        dead++;
                    }
                }
                game.setDead(dead);
                for (int o = 0; o < game.getAsset().length; o++) {
                    game.getM().addAsset(game.getAsset()[o]);
                }
                System.out.println("LoadGame Status : dead = "+game.getDead());
                System.out.print("LoadGame Status : ");
                for (int i = 0; i < game.getAsset().length; i++) {
                    System.out.print(game.getAsset()[i] + " ");
                }
                System.out.println();
                ControllerPlay play = new ControllerPlay();
                play.setGame(game);
                menu.dispose();
            }
            
        }
    }
    
}
