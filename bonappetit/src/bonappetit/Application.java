/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

import IOPackage.IOFile;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Novak
 */
public class Application {

    Game game = new Game();
    IOFile file = new IOFile();
    Scanner n = new Scanner(System.in);
    Scanner a = new Scanner(System.in);

    Random rand = new Random();

    //private GameMap m = new GameMap(12, 60);
    //private Asset game.getAsset()[];
    public void credits() {
        try {
            System.out.println("Bon Appetit Credits");
            Thread.sleep(1000);
            System.out.println("Chef de Cuisine : Ubassy Abdillah");
            Thread.sleep(1000);
            System.out.println("Sous Chef       : Mohammad Zakie Faiz Rahiemy");
            Thread.sleep(1000);
            System.out.println("Chef de Parte   : Raja Ryan Pradana");
            Thread.sleep(1000);
            for (int i = 0; i < 30; i++) {
                System.out.println("Lots of text");
                Thread.sleep(100);
            }
            for (int i = 0; i < 25; i++) {
                System.out.println("Lots of things");
                Thread.sleep(100);
            }
            System.out.println("tl;dr lol");
            Thread.sleep(100);
            System.out.println("Special Thanks");
            Thread.sleep(100);
            System.out.println("Lots of people");
            Thread.sleep(100);

            System.out.println();
            System.out.println("press anykeys to continue");
            char next = n.next().charAt(0);
        } catch (Throwable f) {
            f.printStackTrace();
        }
    }

//    private void play() throws FileNotFoundException, IOException {
//        for (int o = 0; o < game.getAsset().length; o++) {
//            game.getM().addAsset(game.getAsset()[o]);
//        }
//        game.getM().display();
//        char next = n.next().charAt(0);
//        while (next != '0') {
//            if (next == 'e') {
//                game.getAsset()[0].skill();
//            } else if (next == 'q') {
//                try (FileOutputStream fout = new FileOutputStream("save.txt")) {
//                    ObjectOutputStream oout = new ObjectOutputStream(fout);
//                    oout.writeObject(game.getAsset());
//                    oout.flush();
//                }
//            } else {
//                game.moving(game.getAsset()[0], next);
//            }
//            for (int o = 1; o < game.getAsset().length; o++) {
//                game.moving(game.getAsset()[o]);
//            }
//            game.getM().nullMap();
//            for (int o = 0; o < game.getAsset().length; o++) {
//                game.getM().addAsset(game.getAsset()[o]);
//            }
//
//            System.out.println();
//            game.getM().display();
//
//            if (next != 'q') {
//                next = n.next().charAt(0);
//            } else {
//                next = '0';
//            }
//        }
//    }

    public void play2() throws IOException {
        Thread thread = new Thread(game, "Game");
        game.setRun(true);
        game.setWin(false);
        char dir = 'w';
        for (int o = 0; o < game.getAsset().length; o++) {
            game.getM().addAsset(game.getAsset()[o]);
        }
        thread.start();
        while (dir != '0' && game.getAsset()[0] != null) {
            dir = n.next().charAt(0);
            if (dir == 'e') {
                game.getAsset()[0].skill();
            } else if (dir == 'q') {
//                try (FileOutputStream fout = new FileOutputStream("save.txt")) {
//                    ObjectOutputStream oout = new ObjectOutputStream(fout);
//                    oout.writeObject(game.getAsset());
//                    oout.flush();
//                    System.out.println("File Saved");
//                } catch (IOException ex) {
//                    System.out.println("Eror File");
//                }
                file.saveFile(game.getAsset());
            } else {
                game.moving(game.getAsset()[0], dir);
            }
            game.getM().nullMap();
            for (int o = 0; o < game.getAsset().length; o++) {
                game.getM().addAsset(game.getAsset()[o]);
            }
            game.getM().display2();
            for (int p = 1; p < game.getAsset().length; p++) {
                if (game.getAsset()[p] != null) {
                    if (game.getAsset()[p].getPosY() == game.getAsset()[0].getPosY() && game.getAsset()[p].getPosX() == game.getAsset()[0].getPosX()) {
                        if (game.getAsset()[p].getLevel() <= game.getAsset()[0].getLevel()) {
                            game.removeAsset(p);
                        } //else {
//                            game.removeAsset(0);
//                            dir = '0';
//                        }
                    }
                }
            }
            if (game.getDead()==game.getAsset().length-1) {
                dir = '0';
            }
        }
        game.setRun(false);
        if (game.isWin()) {
            System.out.println("You WIN");
            System.out.println("Congratulation");
        }
        else {
            System.out.println("You LOSE");
            System.out.println("Game Over");
        }
        System.out.println("press anykeys to continue");
        char next = n.next().charAt(0);
    }

    public void newPlay() throws IOException {

        game.setAsset(null);
        System.out.println("[E]asy [N]ormal [H]ard");
        System.out.print("Choose Difficulty = ");
        char dif = n.next().charAt(0);
        System.out.print("Input Player (A/B/C) = ");
        char c = n.next().charAt(0);

        if (dif == 'e' || dif == 'E') {
            game.setAsset(new Asset[10]);
        } else if (dif == 'n' || dif == 'N') {
            game.setAsset(new Asset[25]);
        } else if (dif == 'h' || dif == 'H') {
            game.setAsset(new Asset[30]);
        } else {
            game.setAsset(new Asset[10]);
        }
        if (c == 'a' || c == 'A') {
            game.setAsset2(0, new SpeciesA((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
        } else if (c == 'b' || c == 'B') {
            game.setAsset2(0, new SpeciesB((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
        } else if (c == 'c' || c == 'C') {
            game.setAsset2(0, new SpeciesC((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
        } else {
            int random = rand.nextInt(3);
            if (random == 0) {
                game.setAsset2(0, new SpeciesA((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
            } else if (random == 1) {
                game.setAsset2(0, new SpeciesB((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
            } else {
                game.setAsset2(0, new SpeciesC((game.getM().getRow() / 2), (game.getM().getColumn() / 2), 1, 2));
            }
        }

        if (dif == 'H' || dif == 'h') {
            for (int o = 1; o < game.getAsset().length; o++) {
                int r = rand.nextInt(6);
                if (r == 0) {
                    game.setAsset2(o, new SpeciesA(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 2, rand.nextInt(3)));
                } else if (r == 1) {
                    game.setAsset2(o, new SpeciesB(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 2, rand.nextInt(3)));
                } else if (r == 2) {
                    game.setAsset2(o, new SpeciesC(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 2, rand.nextInt(3)));
                } else {
                    game.setAsset2(o, new Food(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), rand.nextInt(2)));
                }
            }
        } else {
            for (int o = 1; o < game.getAsset().length; o++) {
                int r = rand.nextInt(7);
                if (r == 0) {
                    game.setAsset2(o, new SpeciesA(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(3)));
                } else if (r == 1) {
                    game.setAsset2(o, new SpeciesB(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(3)));
                } else if (r == 2) {
                    game.setAsset2(o, new SpeciesC(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), 1, rand.nextInt(3)));
                } else {
                    game.setAsset2(o, new Food(rand.nextInt(game.getM().getRow()), rand.nextInt(game.getM().getColumn()), rand.nextInt(2)));
                }
            }
        }

        game.setDead(0);
        play2();

    }

    public void loadPlay() throws IOException {
        game.setAsset(null);
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.txt"))) {
//            Object ob = ois.readObject();
//            game.setAsset((Asset[]) ob);
//
//            if (game.getAsset() == null) {
//                System.out.println("No save file");
//            } else {
//                int dead = 0;
//                for (int i = 0; i < game.getAsset().length; i++) {
//                    if (game.getAsset()[i] == null) {
//                        dead++;
//                    }
//                }
//                game.setDead(dead);
//                play2();
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not Found");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("No class found");
//        }

            game.setAsset((Asset[]) file.loadFile());

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
                play2();
            }
            
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
                pil = a.nextInt();
                if (pil == 1) {
                    newPlay();
                } else if (pil == 2) {
                    loadPlay();
                } else if (pil == 3) {
                    credits();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Wrong input");
                a = new Scanner(System.in);
                pil = 4;
            }// catch (Exception es) {
//                System.out.println("Error");
//                pil = 4;
//            }
        } while (pil != 0);
    }
}
