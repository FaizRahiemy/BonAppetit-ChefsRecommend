/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import IOPackage.IOFile;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import view.Play;

/**
 *
 * @author Novak
 */
public class ControllerPlay implements KeyListener, Runnable {

    Play play;
    Game game;
    Font field = new Font("Monospaced", Font.PLAIN, 13);
    Color maroon = new Color(128, 0, 0);
    IOFile file;

    public ControllerPlay() {
        file = new IOFile();
        play = new Play();
        game = new Game();
        play.setResizable(false);
        play.getFieldPlay().setFont(field);
        play.getFieldPlay().addKeyListener(this);
        play.getFieldPlay().setText("");
        play.setVisible(true);

        Thread t = new Thread(this);
        t.start();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void display() {
        play.getFieldPlay().setText("");
        play.getFieldPlay().append("+");
        for (int l = 0; l < game.getM().getMap()[0].length; l++) {
            play.getFieldPlay().append("-");
        }
        play.getFieldPlay().append("+ \n");
        for (int i = 0; i < game.getM().getMap().length; i++) {
            play.getFieldPlay().append("|");
            for (int j = 0; j < game.getM().getMap()[i].length; j++) {
                if (game.getM().getMap()[i][j] == game.getAsset()[0]) {
                    play.getFieldPlay().setForeground(Color.RED);
                    play.getFieldPlay().append(game.getM().getMap()[i][j].toString());
                    play.getFieldPlay().setForeground(Color.BLACK);
                } else if (game.getM().getMap()[i][j] == null) {
                    play.getFieldPlay().append(" ");
                } else {
                    play.getFieldPlay().append(game.getM().getMap()[i][j].toString());
                }
            }
            play.getFieldPlay().append("| \n");
        }
        play.getFieldPlay().append("+");
        for (int l = 0; l < game.getM().getMap()[0].length; l++) {
            play.getFieldPlay().append("-");
        }
        play.getFieldPlay().append("+");

    }

    public void display2() {
        try {
            play.getFieldPlay().setText("");
            play.getFieldPlay().append("+");
            for (int l = 0; l < game.getM().getMap()[0].length; l++) {
                play.getFieldPlay().append("-");
            }
            play.getFieldPlay().append("+ \n");
            for (int i = 0; i < game.getM().getMap().length; i++) {
                play.getFieldPlay().append("|");
                for (int j = 0; j < game.getM().getMap()[i].length; j++) {
                    if (game.getM().getMap()[i][j] == game.getAsset()[0]) {
                        play.getFieldPlay().setForeground(Color.RED);
                        play.getFieldPlay().append(game.getM().getMap()[i][j].toString());
                        play.getFieldPlay().setForeground(Color.BLACK);
                    } else if (game.getM().getMap()[i][j] == null) {
                        play.getFieldPlay().append(" ");
                    } else {
                        play.getFieldPlay().append(game.getM().getMap()[i][j].toString());
                    }
                }
                play.getFieldPlay().append("| \n");
            }
            play.getFieldPlay().append("+");
            for (int l = 0; l < game.getM().getMap()[0].length; l++) {
                play.getFieldPlay().append("-");
            }
            play.getFieldPlay().append("+");
            Thread.sleep(1000);
        } catch (Throwable f) {
            f.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object a = e.getSource();
        if (a.equals(play.getFieldPlay())) {
            if (e.getKeyCode() == e.VK_E) {
                game.getAsset()[0].skill();
                display();
                play.getFieldStatus().setText("Status : Skill Activated");
            } else if (e.getKeyCode() == e.VK_Q) {
                try {
                    file.saveFile(game.getAsset());
                    display();
                    play.getFieldStatus().setText("Status : File Saved");
                } catch (IOException ex) {
                    System.out.println("Save error");
                    JOptionPane.showMessageDialog(null, "Save Error");
                }
            } else if (e.getKeyCode() == e.VK_W) {
                game.moving(game.getAsset()[0], 'w');
                game.getM().nullMap();
                for (int o = 0; o < game.getAsset().length; o++) {
                    game.getM().addAsset(game.getAsset()[o]);
                }
                for (int p = 1; p < game.getAsset().length; p++) {
                    if (game.getAsset()[p] != null) {
                        if (game.getAsset()[p].getPosY() == game.getAsset()[0].getPosY() && game.getAsset()[p].getPosX() == game.getAsset()[0].getPosX()) {
                            if (game.getAsset()[p].getLevel() <= game.getAsset()[0].getLevel()) {
                                game.removeAsset(p);
                            }
                        }
                    }
                }
                display();
                for (int i = 1; i < game.getAsset().length; i++) {
                    if (game.getAsset()[i] == null) {
                        game.setDead(game.getDead() + 1);
                    }
                }
                if (game.isWin()) {
                    ControllerMainMenu mm = new ControllerMainMenu();
                    play.dispose();
                }
                if (game.getDead() == game.getAsset().length - 1) {
                    game.setWin(true);
                    play.getFieldStatus().setText("Status : You Win !");
                } else {
                    play.getFieldStatus().setText("Status : Enemy Leftover = " + (game.getAsset().length - game.getDead() - 1));
                    game.setDead(0);
                }
            } else if (e.getKeyCode() == e.VK_S) {
                game.moving(game.getAsset()[0], 's');
                game.getM().nullMap();
                for (int o = 0; o < game.getAsset().length; o++) {
                    game.getM().addAsset(game.getAsset()[o]);
                }
                for (int p = 1; p < game.getAsset().length; p++) {
                    if (game.getAsset()[p] != null) {
                        if (game.getAsset()[p].getPosY() == game.getAsset()[0].getPosY() && game.getAsset()[p].getPosX() == game.getAsset()[0].getPosX()) {
                            if (game.getAsset()[p].getLevel() <= game.getAsset()[0].getLevel()) {
                                game.removeAsset(p);
                            }
                        }
                    }
                }
                display();
                for (int i = 1; i < game.getAsset().length; i++) {
                    if (game.getAsset()[i] == null) {
                        game.setDead(game.getDead() + 1);
                    }
                }
                if (game.isWin()) {
                    ControllerMainMenu mm = new ControllerMainMenu();
                    play.dispose();
                }
                if (game.getDead() == game.getAsset().length - 1) {
                    game.setWin(true);
                    play.getFieldStatus().setText("Status : You Win !");
                } else {
                    play.getFieldStatus().setText("Status : Enemy Leftover = " + (game.getAsset().length - game.getDead() - 1));
                    game.setDead(0);
                }
            } else if (e.getKeyCode() == e.VK_A) {
                game.moving(game.getAsset()[0], 'a');
                game.getM().nullMap();
                for (int o = 0; o < game.getAsset().length; o++) {
                    game.getM().addAsset(game.getAsset()[o]);
                }
                for (int p = 1; p < game.getAsset().length; p++) {
                    if (game.getAsset()[p] != null) {
                        if (game.getAsset()[p].getPosY() == game.getAsset()[0].getPosY() && game.getAsset()[p].getPosX() == game.getAsset()[0].getPosX()) {
                            if (game.getAsset()[p].getLevel() <= game.getAsset()[0].getLevel()) {
                                game.removeAsset(p);
                            }
                        }
                    }
                }
                display();
                for (int i = 1; i < game.getAsset().length; i++) {
                    if (game.getAsset()[i] == null) {
                        game.setDead(game.getDead() + 1);
                    }
                }
                if (game.isWin()) {
                    ControllerMainMenu mm = new ControllerMainMenu();
                    play.dispose();
                }
                if (game.getDead() == game.getAsset().length - 1) {
                    game.setWin(true);
                    play.getFieldStatus().setText("Status : You Win !");
                } else {
                    play.getFieldStatus().setText("Status : Enemy Leftover = " + (game.getAsset().length - game.getDead() - 1));
                    game.setDead(0);
                }
            } else if (e.getKeyCode() == e.VK_D) {
                game.moving(game.getAsset()[0], 'd');
                game.getM().nullMap();
                for (int o = 0; o < game.getAsset().length; o++) {
                    game.getM().addAsset(game.getAsset()[o]);
                }
                for (int p = 1; p < game.getAsset().length; p++) {
                    if (game.getAsset()[p] != null) {
                        if (game.getAsset()[p].getPosY() == game.getAsset()[0].getPosY() && game.getAsset()[p].getPosX() == game.getAsset()[0].getPosX()) {
                            if (game.getAsset()[p].getLevel() <= game.getAsset()[0].getLevel()) {
                                game.removeAsset(p);
                            }
                        }
                    }
                }
                display();
                for (int i = 1; i < game.getAsset().length; i++) {
                    if (game.getAsset()[i] == null) {
                        game.setDead(game.getDead() + 1);
                    }
                }
                if (game.isWin()) {
                    ControllerMainMenu mm = new ControllerMainMenu();
                    play.dispose();
                }
                if (game.getDead() == game.getAsset().length - 1) {
                    game.setWin(true);
                    play.getFieldStatus().setText("Status : You Win !");
                } else {
                    play.getFieldStatus().setText("Status : Enemy Leftover = " + (game.getAsset().length - game.getDead() - 1));
                    game.setDead(0);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (game.isRun()) {
            for (int s = 1; s < game.getAsset().length; s++) {
                if (game.getAsset()[s] != null) {
                    game.moving(game.getAsset()[s]);
                }
            }
            game.getM().nullMap();
//            for (int b = 1; b < game.getAsset().length; b++) {
//                if (game.getAsset()[b] != null) {
//                    System.out.println("null b");
//                    for (int c = 0; c < game.getAsset().length; c++) {
//                        if (game.getAsset()[c] != null) {
//                            System.out.println("null c");
//                            if (game.getAsset()[c] != game.getAsset()[b]) {
//                                System.out.println("c =/= b");
//                                if (game.getAsset()[b].getPosY() == game.getAsset()[c].getPosY() && game.getAsset()[b].getPosX() == game.getAsset()[c].getPosX()) {
//                                    System.out.println(" pos c = pos b");
//                                    if (game.getAsset()[b].getLevel() >= game.getAsset()[c].getLevel()) {
//                                        game.removeAsset(c);
//                                    } else {
//                                        game.removeAsset(b);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
            for (int o = 0; o < game.getAsset().length; o++) {
                if (game.getAsset()[o] != null) {
                    game.getM().addAsset(game.getAsset()[o]);
                }
            }
            this.display2();
            if (game.getAsset()[0] == null) {
                game.setRun(false);
            }
            for (int i = 1; i < game.getAsset().length; i++) {
                if (game.getAsset()[i] == null) {
                    game.setDead(game.getDead() + 1);
                }
            }
            if (game.getDead() == game.getAsset().length - 1) {
                game.setRun(false);
                game.setWin(true);
            } else {
                game.setDead(0);
            }
        }

    }

}
