/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Novak
 */
public class Game {

    Random rand = new Random();
    Scanner n = new Scanner(System.in);
    Scanner a = new Scanner(System.in);

    private GameMap m = new GameMap(12, 60);
    private Asset asset[];
    //private Asset player = new SpeciesA((m.getRow()/2),(m.getColumn()/2),1,2);
    //private Asset npc1 = new SpeciesB(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1,0);
    //private Asset npc2 = new SpeciesC(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1,1);
    //private Asset food1 = new Food(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1);
    //private Asset food2 = new Food(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),0);
    //private Asset food3 = new Food(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1);

    private void moving(Asset a) {
        //   if (a.getPosY()>0)
        //       if (m.getMap()[a.getPosY()-1][a.getPosX()]!=null&&m.getMap()[a.getPosY()-1][a.getPosX()].getLevel()<a.getLevel())
        int r = rand.nextInt(4);
        boolean delay = false;
        char dir;
        if (r == 0) {
            if (a.getDelay() != 0) {
                delay = true;
            }
            dir = 'u';
            a.move(dir, m.getRow(), m.getColumn(), m.getMap());
            if (delay) {
                if (dir == 'u') {
                    m.removeAsset(a.getPosY() + 1, a.getPosX());
                } else if (dir == 'd') {
                    m.removeAsset(a.getPosY() - 1, a.getPosX());
                } else if (dir == 'l') {
                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
                } else if (dir == 'r') {
                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
                }
            }
            m.addAsset(a);
            delay = false;
        } else if (r == 1) {
            if (a.getDelay() != 0) {
                delay = true;
            }
            dir = 'd';
            a.move(dir, m.getRow(), m.getColumn(), m.getMap());
            m.addAsset(a);
            if (delay) {
                if (dir == 'u') {
                    m.removeAsset(a.getPosY() + 1, a.getPosX());
                } else if (dir == 'd') {
                    m.removeAsset(a.getPosY() - 1, a.getPosX());
                } else if (dir == 'l') {
                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
                } else if (dir == 'r') {
                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
                }
            }
            m.addAsset(a);
            delay = false;
        } else if (r == 2) {
            if (a.getDelay() != 0) {
                delay = true;
            }
            dir = 'l';
            a.move(dir, m.getRow(), m.getColumn(), m.getMap());
            m.addAsset(a);
            if (delay) {
                if (dir == 'u') {
                    m.removeAsset(a.getPosY() + 1, a.getPosX());
                } else if (dir == 'd') {
                    m.removeAsset(a.getPosY() - 1, a.getPosX());
                } else if (dir == 'l') {
                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
                } else if (dir == 'r') {
                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
                }
            }
            m.addAsset(a);
            delay = false;
        } else {
            if (a.getDelay() != 0) {
                delay = true;
            }
            dir = 'r';
            a.move(dir, m.getRow(), m.getColumn(), m.getMap());
            m.addAsset(a);
            if (delay) {
                if (dir == 'u') {
                    m.removeAsset(a.getPosY() + 1, a.getPosX());
                } else if (dir == 'd') {
                    m.removeAsset(a.getPosY() - 1, a.getPosX());
                } else if (dir == 'l') {
                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
                } else if (dir == 'r') {
                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
                }
            }
            m.addAsset(a);
            delay = false;
        }
    }

    private void moving(Asset a, char in) {
        boolean delay = false;
        if (in == 'w' || in == 'W') {
            if (a.getDelay() != 0) {
                delay = true;
            }
            a.move('u', m.getRow(), m.getColumn(), m.getMap());
            m.addAsset(a);
            if (delay) {
                if (a == m.getMap()[a.getPosY() + 1][a.getPosX()]) {
                    m.removeAsset(a.getPosY() + 1, a.getPosX());
                }
            }
            delay = false;
        } else if (in == 's' || in == 'S') {
            if (a.getDelay() != 0) {
                delay = true;
            }
            a.move('d', m.getRow(), m.getColumn(), m.getMap());
            m.addAsset(a);
            if (delay) {
                if (a == m.getMap()[a.getPosY() - 1][a.getPosX()]) {
                    m.removeAsset(a.getPosY() - 1, a.getPosX());
                }
            }
            delay = false;
        } else if (in == 'a' || in == 'A') {
            if (a.getDelay() != 0) {
                delay = true;
            }
            a.move('l', m.getRow(), m.getColumn(), m.getMap());
            m.addAsset(a);
            if (delay) {
                if (a == m.getMap()[a.getPosY()][a.getPosX() + 1]) {
                    m.removeAsset(a.getPosY(), a.getPosX() + 1);
                }
            }
            delay = false;
        } else if (in == 'd' || in == 'D') {
            if (a.getDelay() != 0) {
                delay = true;
            }
            a.move('r', m.getRow(), m.getColumn(), m.getMap());
            m.addAsset(a);
            if (delay) {
                if (a == m.getMap()[a.getPosY()][a.getPosX() - 1]) {
                    m.removeAsset(a.getPosY(), a.getPosX() - 1);
                }
            }
            delay = false;
        }
    }

    private void play() throws FileNotFoundException, IOException {
        for (int o = 0; o < asset.length; o++) {
            m.addAsset(asset[o]);
        }
        System.out.print("+");
        for (int l = 0; l < m.getMap()[0].length; l++) {
            System.out.print("-");
        }
        System.out.println("+");
        for (int i = 0; i < m.getMap().length; i++) {
            System.out.print("|");
            for (int j = 0; j < m.getMap()[i].length; j++) {
                if (m.getMap()[i][j] == null) {
                    System.out.print(' ');
                } else if (m.getMap()[i][j].getType() == 0) {
                    System.out.print(m.getMap()[i][j]);
                } else if (m.getMap()[i][j].getType() == 1) {
                    System.out.print(m.getMap()[i][j]);
                } else if (m.getMap()[i][j].getType() == 2) {
                    System.out.print(m.getMap()[i][j]);
                } else if (m.getMap()[i][j].getType() == 3) {
                    System.out.print(m.getMap()[i][j]);
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("+");
        for (int l = 0; l < m.getMap()[0].length; l++) {
            System.out.print("-");
        }
        System.out.print("+");
        char next = n.next().charAt(0);
        while (next != '0') {
            if (next == 'e') {
                asset[0].skill();
            } else if (next == 'q') {
                try (FileOutputStream fout = new FileOutputStream("save.txt")) {
                    ObjectOutputStream oout = new ObjectOutputStream(fout);
                    oout.writeObject(asset);
                    oout.flush();
                }
            } else {
                moving(asset[0], next);
            }
            for (int o = 1; o < asset.length; o++) {
                moving(asset[o]);
            }

            System.out.println();
            System.out.print("+");
            for (int l = 0; l < m.getMap()[0].length; l++) {
                System.out.print("-");
            }
            System.out.println("+");
            for (int i = 0; i < m.getMap().length; i++) {
                System.out.print("|");
                for (int j = 0; j < m.getMap()[i].length; j++) {
                    if (m.getMap()[i][j] == null) {
                        System.out.print(' ');
                    } else if (m.getMap()[i][j].getType() == 0) {
                        System.out.print(m.getMap()[i][j]);
                    } else if (m.getMap()[i][j].getType() == 1) {
                        System.out.print(m.getMap()[i][j]);
                    } else if (m.getMap()[i][j].getType() == 2) {
                        System.out.print(m.getMap()[i][j]);
                    } else if (m.getMap()[i][j].getType() == 3) {
                        System.out.print(m.getMap()[i][j]);
                    }
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.print("+");
            for (int l = 0; l < m.getMap()[0].length; l++) {
                System.out.print("-");
            }
            System.out.print("+");

            if (next != 'q') {
                next = n.next().charAt(0);
            } else {
                next = '0';
            }

        }
    }

    public void newPlay() throws IOException {

        System.out.print("Input number = ");
        int jum = a.nextInt();
        System.out.print("Input Player (A/B/C) = ");
        char c = n.next().charAt(0);

        asset = new Asset[jum];
        if (c == 'a' || c == 'A') {
            asset[0] = new SpeciesA((m.getRow() / 2), (m.getColumn() / 2), 3, 2);
        } else if (c == 'b' || c == 'B') {
            asset[0] = new SpeciesB((m.getRow() / 2), (m.getColumn() / 2), 3, 2);
        } else if (c == 'c' || c == 'C') {
            asset[0] = new SpeciesC((m.getRow() / 2), (m.getColumn() / 2), 3, 2);
        } else {
            int random = rand.nextInt(3);
            if (random == 0) {
                asset[0] = new SpeciesA((m.getRow() / 2), (m.getColumn() / 2), 3, 2);
            } else if (random == 1) {
                asset[0] = new SpeciesB((m.getRow() / 2), (m.getColumn() / 2), 3, 2);
            } else {
                asset[0] = new SpeciesC((m.getRow() / 2), (m.getColumn() / 2), 3, 2);
            }
        }

        for (int o = 1; o < asset.length; o++) {
            int r = rand.nextInt(7);
            if (r == 0) {
                asset[o] = new SpeciesA(rand.nextInt(m.getRow()), rand.nextInt(m.getColumn()), 1, rand.nextInt(3));
            } else if (r == 1) {
                asset[o] = new SpeciesB(rand.nextInt(m.getRow()), rand.nextInt(m.getColumn()), 1, rand.nextInt(3));
            } else if (r == 2) {
                asset[o] = new SpeciesC(rand.nextInt(m.getRow()), rand.nextInt(m.getColumn()), 1, rand.nextInt(3));
            } else {
                asset[o] = new Food(rand.nextInt(m.getRow()), rand.nextInt(m.getColumn()), rand.nextInt(2));
            }
        }
        play();

    }

    public void loadPlay() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.txt"))) {
            Object ob = ois.readObject();
            asset = (Asset[]) ob;

            if (asset == null) {
                System.out.println("No save file");
            } else {
                play();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger("No class found");
        }
    }
}
