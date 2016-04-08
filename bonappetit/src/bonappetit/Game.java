/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

import java.util.Random;
import java.util.Scanner;

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

    GameMap m = new GameMap(12, 60);
    Asset asset[];
    int dead = 0;
    //private Asset player = new SpeciesA((m.getRow()/2),(m.getColumn()/2),1,2);
    //private Asset npc1 = new SpeciesB(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1,0);
    //private Asset npc2 = new SpeciesC(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1,1);
    //private Asset food1 = new Food(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1);
    //private Asset food2 = new Food(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),0);
    //private Asset food3 = new Food(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1);

//    public void moving(Asset a) {
//        int r = rand.nextInt(4);
//        boolean delay = false;
//        char dir;
//        if (r == 0) {
//            if (a.getDelay() != 0) {
//                delay = true;
//            }
//            dir = 'u';
//            a.move(dir, m.getRow(), m.getColumn(), m.getMap());
//            if (delay) {
//                if (dir == 'u') {
//                    m.removeAsset(a.getPosY() + 1, a.getPosX());
//                } else if (dir == 'd') {
//                    m.removeAsset(a.getPosY() - 1, a.getPosX());
//                } else if (dir == 'l') {
//                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
//                } else if (dir == 'r') {
//                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
//                }
//            }
//            m.addAsset(a);
//            delay = false;
//        } else if (r == 1) {
//            if (a.getDelay() != 0) {
//                delay = true;
//            }
//            dir = 'd';
//            a.move(dir, m.getRow(), m.getColumn(), m.getMap());
//            m.addAsset(a);
//            if (delay) {
//                if (dir == 'u') {
//                    m.removeAsset(a.getPosY() + 1, a.getPosX());
//                } else if (dir == 'd') {
//                    m.removeAsset(a.getPosY() - 1, a.getPosX());
//                } else if (dir == 'l') {
//                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
//                } else if (dir == 'r') {
//                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
//                }
//            }
//            m.addAsset(a);
//            delay = false;
//        } else if (r == 2) {
//            if (a.getDelay() != 0) {
//                delay = true;
//            }
//            dir = 'l';
//            a.move(dir, m.getRow(), m.getColumn(), m.getMap());
//            m.addAsset(a);
//            if (delay) {
//                if (dir == 'u') {
//                    m.removeAsset(a.getPosY() + 1, a.getPosX());
//                } else if (dir == 'd') {
//                    m.removeAsset(a.getPosY() - 1, a.getPosX());
//                } else if (dir == 'l') {
//                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
//                } else if (dir == 'r') {
//                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
//                }
//            }
//            m.addAsset(a);
//            delay = false;
//        } else {
//            if (a.getDelay() != 0) {
//                delay = true;
//            }
//            dir = 'r';
//            a.move(dir, m.getRow(), m.getColumn(), m.getMap());
//            m.addAsset(a);
//            if (delay) {
//                if (dir == 'u') {
//                    m.removeAsset(a.getPosY() + 1, a.getPosX());
//                } else if (dir == 'd') {
//                    m.removeAsset(a.getPosY() - 1, a.getPosX());
//                } else if (dir == 'l') {
//                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
//                } else if (dir == 'r') {
//                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
//                }
//            }
//            m.addAsset(a);
//            delay = false;
//        }
//    }

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
        for (int i=0; i<asset.length; i++) {
            if (a!=asset[i]&&a.getPosX()==asset[i].getPosX()&&a.getPosY()==asset[i].getPosY()&&a.getLevel()>=asset[i].getLevel())
                asset[i] = null;
        }
    }
    
    public void moving(Asset a, char in) {
        if (in == 'w' || in == 'W') {
            a.move('u', m.getRow(), m.getColumn(), m.getMap());
        } else if (in == 's' || in == 'S') {
            a.move('d', m.getRow(), m.getColumn(), m.getMap());
        } else if (in == 'a' || in == 'A') {
            a.move('l', m.getRow(), m.getColumn(), m.getMap());
        } else if (in == 'd' || in == 'D') {
            a.move('r', m.getRow(), m.getColumn(), m.getMap());
        }
        for (int i=0; i<asset.length; i++) {
            if (a!=asset[i]&&a.getPosX()==asset[i].getPosX()&&a.getPosY()==asset[i].getPosY()&&a.getLevel()>=asset[i].getLevel())
                asset[i] = null;
        }
    }

    private boolean isRun() {
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

    public void setAsset2(int i, Asset a) {
        asset[i] = a;
    }

    @Override
    public void run() {
        while (isRun()) {
            for (int s = 1;
                    s < asset.length; s++) {
                if (asset[s] != null) {
                    moving(asset[s]);
                    m.nullMap();
                    for (int o = 0; o < asset.length; o++) {
                        if (asset[o]!=null)
                            m.addAsset(asset[o]);
                    }
                } 
            }
            m.display();
            if (asset[0]==null) {
                run = false;
            }
            for (int i=1; i<asset.length; i++) {
                if (asset[i]==null) {
                    dead++;
                }
            }
            if (dead == asset.length-1) {
                run = false;
                win = true;
            }
        }
    }

}
