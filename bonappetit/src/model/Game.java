/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Novak
 */
public class Game extends Thread {

    Random rand = new Random();
    Scanner n = new Scanner(System.in);
    Scanner a = new Scanner(System.in);
    boolean run = true;
    boolean win = false;
    boolean show = false;

    char up = 'w';
    char down = 's';
    char left = 'a';
    char right = 'd';
    char skill = 'e';
    char save = 'q';
    char quit = '0';
    
    GameMap m;
    Asset asset[];
    int dead = 0;

    public Game() {
        m = new GameMap(12, 60);
    }
    
    public void moving(Asset a) {
        int r = rand.nextInt(4);
        if (r == 0) {
            a.move('u', m.getRow(), m.getColumn(), m.getMap());
        } else if (r == 1) {
            a.move('d', m.getRow(), m.getColumn(), m.getMap());
        } else if (r == 2) {
            a.move('l', m.getRow(), m.getColumn(), m.getMap());
        } else {
            a.move('r', m.getRow(), m.getColumn(), m.getMap());
        }
    }

    public void moving(Asset a, char in) {
        if (a!=null) {
            if (in == up) {
                a.move('u', m.getRow(), m.getColumn(), m.getMap());
            } else if (in == down) {
                a.move('d', m.getRow(), m.getColumn(), m.getMap());
            } else if (in == left) {
                a.move('l', m.getRow(), m.getColumn(), m.getMap());
            } else if (in == right) {
                a.move('r', m.getRow(), m.getColumn(), m.getMap());
            }
        }
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }
    
    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public GameMap getM() {
        return m;
    }

    public void setM(GameMap m) {
        this.m = m;
    }

    public Asset[] getAsset() {
        return asset;
    }

    public void setAsset(Asset[] asset) {
        this.asset = asset;
    }

    public void removeAsset(int i) {
        asset[i]=null;
    }
    
    public void setAsset2(int i, Asset a) {
        asset[i] = a;
    }

    public char getUp() {
        return up;
    }

    public void setUp(char up) {
        this.up = up;
    }

    public char getDown() {
        return down;
    }

    public void setDown(char down) {
        this.down = down;
    }

    public char getLeft() {
        return left;
    }

    public void setLeft(char left) {
        this.left = left;
    }

    public char getRight() {
        return right;
    }

    public void setRight(char right) {
        this.right = right;
    }

    public char getSkill() {
        return skill;
    }

    public void setSkill(char skill) {
        this.skill = skill;
    }

    public char getSave() {
        return save;
    }

    public void setSave(char save) {
        this.save = save;
    }

    public char getQuit() {
        return quit;
    }

    public void setQuit(char quit) {
        this.quit = quit;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    
    
    
    @Override
    public void run() {
        while (isRun()) {
            for (int s = 1; s < asset.length; s++) {
                if (asset[s] != null) {
                    moving(asset[s]);
                }
            }
            m.nullMap();
            for (int b = 1; b < asset.length; b++) {
                if (asset[b]!=null) {
                    for(int c = 0; c<asset.length; c++) {
                        if (asset[c] != null && asset[b] != null) {
                            if (asset[c]!=asset[b]) {
                                if (asset[b].getPosY()==asset[c].getPosY() && asset[b].getPosX()==asset[c].getPosX()) {
                                    if (asset[b].getLevel()>asset[c].getLevel()) {
                                        asset[c]=null;
                                    }
                                    else {
                                        asset[b]=null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int o = 0; o < asset.length; o++) {
               if (asset[o] != null) {
                    m.addAsset(asset[o]);
                }
            }
            if (show) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                m.display();
            }
            if (asset[0] == null) {
                run = false;
            }
            for (int i = 1; i < asset.length; i++) {
                if (asset[i] == null) {
                    dead++;
                }
            }
            if (dead == asset.length - 1) {
                run = false;
                win = true;
            }
            else {
                dead = 0;
            }
        }
    }

}
