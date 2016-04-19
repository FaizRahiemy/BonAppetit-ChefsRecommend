/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import model.*;
import view.NewGame;

/**
 *
 * @author Novak
 */
public class ControllerNewGame implements ActionListener {
    Random rand = new Random();
    NewGame ng;
    Game game;

    public ControllerNewGame() {
        ng = new NewGame();
        ng.setResizable(false);
        game = new Game();
        ng.getBtnContinue().addActionListener(this);
        ng.setVisible(true);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if (x.equals(ng.getBtnContinue())) {
            String dif = ng.getComboBoxDif().getSelectedItem().toString();
            String chr = ng.getComboBoxType().getSelectedItem().toString();
            System.out.println("NewGame Status : Difficulty = "+dif+", Character = "+chr);
            
            if (dif.equals("Easy")) {
                game.setAsset(new Asset[10]);
                for (int o = 1; o < game.getAsset().length; o++) {
                    int r = rand.nextInt(7);
                    if (r == 0) {
                        game.setAsset2(o, new SpeciesA(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(5)));
                    } else if (r == 1) {
                        game.setAsset2(o, new SpeciesB(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(5)));
                    } else if (r == 2) {
                        game.setAsset2(o, new SpeciesC(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(5)));
                    } else {
                        game.setAsset2(o, new Food(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), rand.nextInt(2)));
                    }
                }
            } else if (dif.equals("Normal")) {
                game.setAsset(new Asset[25]);
                for (int o = 1; o < game.getAsset().length; o++) {
                    int r = rand.nextInt(7);
                    if (r == 0) {
                        game.setAsset2(o, new SpeciesA(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(5)));
                    } else if (r == 1) {
                        game.setAsset2(o, new SpeciesB(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(5)));
                    } else if (r == 2) {
                        game.setAsset2(o, new SpeciesC(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(5)));
                    } else {
                        game.setAsset2(o, new Food(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), rand.nextInt(2)));
                    }
                }
            } else if (dif.equals("Hard")) {
                game.setAsset(new Asset[30]);
                for (int o = 1; o < game.getAsset().length; o++) {
                    int r = rand.nextInt(6);
                    if (r == 0) {
                        game.setAsset2(o, new SpeciesA(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 2, rand.nextInt(6)));
                    } else if (r == 1) {
                        game.setAsset2(o, new SpeciesB(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 2, rand.nextInt(6)));
                    } else if (r == 2) {
                        game.setAsset2(o, new SpeciesC(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 2, rand.nextInt(6)));
                    } else {
                        game.setAsset2(o, new Food(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), rand.nextInt(2)));
                    }
                }
            }
            
            if (chr.equals("Speed")) {
                game.setAsset2(0, new SpeciesA((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
            }
            else if (chr.equals("Defend")) {
                game.setAsset2(0, new SpeciesB((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
            }
            else if (chr.equals("Attack")) {
                game.setAsset2(0, new SpeciesC((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
            }
            game.setDead(0);
            for (int o = 0; o < game.getAsset().length; o++) {
                game.getM().addAsset(game.getAsset()[o]);
            }
            System.out.println("NewGame Status : dead = "+game.getDead());
            System.out.print("NewGame Status : ");
            for (int i=0; i<game.getAsset().length; i++) {
                System.out.print(game.getAsset()[i]+" ");
            }
            System.out.println();
            
            ControllerPlay play = new ControllerPlay();
            play.setGame(game);
            ng.dispose();
        }
    }
}
