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
public class Game {
    
    Random rand = new Random();
    Scanner n = new Scanner(System.in);
    Scanner a = new Scanner(System.in);
    
    
    private GameMap m = new GameMap(12,60);
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
        if (r==0) {
            a.move('u',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            //if (a==m.getMap()[a.getPosY()+1][a.getPosX()])
            //    m.removeAsset(m.getMap()[a.getPosY()+1][a.getPosX()]);
        }
        else if (r==1) {
            a.move('d',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            //if (a==m.getMap()[a.getPosY()-1][a.getPosX()])
            //    m.removeAsset(m.getMap()[a.getPosY()-1][a.getPosX()]);
        }
        else if (r==2) {
            a.move('l',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            //if (a==m.getMap()[a.getPosY()][a.getPosX()+1])
            //    m.removeAsset(m.getMap()[a.getPosY()][a.getPosX()+1]);
        }
        else {
            a.move('r',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            //if (a==m.getMap()[a.getPosY()][a.getPosX()-1])
            //    m.removeAsset(m.getMap()[a.getPosY()][a.getPosX()-1]);
        }
    }
    
    private void moving(Asset a, char in) {
        if (in=='w'||in=='W') {
            a.move('u',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            if (a==m.getMap()[a.getPosY()+1][a.getPosX()])
                m.removeAsset(m.getMap()[a.getPosY()+1][a.getPosX()]);
        }
        else if (in=='s'||in=='S') {
            a.move('d',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            if (a==m.getMap()[a.getPosY()-1][a.getPosX()])
                m.removeAsset(m.getMap()[a.getPosY()-1][a.getPosX()]);
        }
        else if (in=='a'||in=='A') {
            a.move('l',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            if (a==m.getMap()[a.getPosY()][a.getPosX()+1])
                m.removeAsset(m.getMap()[a.getPosY()][a.getPosX()+1]);
        }
        else {
            a.move('r',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            if (a==m.getMap()[a.getPosY()][a.getPosX()-1])
                m.removeAsset(m.getMap()[a.getPosY()][a.getPosX()-1]);
        }
    }
    
    public void play() {
        
        System.out.print("Input number = ");
        int jum = a.nextInt();
        System.out.print("Input Player (A/B/C) = ");
        char c = n.next().charAt(0);
        
        asset = new Asset[jum];
        if (c=='a'||c=='A')
            asset[0] = new SpeciesA((m.getRow()/2),(m.getColumn()/2),1,2);
        else if (c=='b'||c=='B')
            asset[0] = new SpeciesB((m.getRow()/2),(m.getColumn()/2),1,2);
        else 
            asset[0] = new SpeciesC((m.getRow()/2),(m.getColumn()/2),1,2);
        
        for (int o=1; o<asset.length; o++) {
            int r = rand.nextInt(6);
            if (r==0) {
                asset[o] = new SpeciesA(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1,rand.nextInt(3));
            }
            else if (r==1) {
                asset[o] = new SpeciesB(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1,rand.nextInt(3));
            }
            else if (r==2) {
                asset[o] = new SpeciesC(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),1,rand.nextInt(3));
            }
            else
                asset[o] = new Food(rand.nextInt(m.getRow()),rand.nextInt(m.getColumn()),rand.nextInt(2));
        }
        
        for (int o=0;o<asset.length;o++) {
            m.addAsset(asset[o]);
        }
        
        
        System.out.print("+");
        for (int l=0;l<m.getMap()[0].length;l++)
            System.out.print("-");
        System.out.println("+");
        for (int i=0;i<m.getMap().length;i++) {
            System.out.print("|");
            for (int j=0;j<m.getMap()[i].length;j++) {
                if (m.getMap()[i][j]==null) {
                    System.out.print(' ');
                }
		else if (m.getMap()[i][j].getType()==0) {
                    System.out.print(m.getMap()[i][j]);
                }
                else if (m.getMap()[i][j].getType()==1) {
                    System.out.print(m.getMap()[i][j]);
                }
                else if (m.getMap()[i][j].getType()==2) {
                    System.out.print(m.getMap()[i][j]);
                }
                else if (m.getMap()[i][j].getType()==3) {
                    System.out.print(m.getMap()[i][j]);
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("+");
        for (int l=0;l<m.getMap()[0].length;l++)
            System.out.print("-");
        System.out.print("+");
        char next = n.next().charAt(0);
        
        for (int k=0; k<15; k++) {
            moving(asset[0],next);
            for (int o=1; o<asset.length; o++) {
                moving(asset[o]);
            }
            
            System.out.println();
            System.out.print("+");
            for (int l=0;l<m.getMap()[0].length;l++)
                System.out.print("-");
            System.out.println("+");
            for (int i=0;i<m.getMap().length;i++) {
                System.out.print("|");
                for (int j=0;j<m.getMap()[i].length;j++) {
                    if (m.getMap()[i][j]==null) {
                        System.out.print(' ');
                    }
                    else if (m.getMap()[i][j].getType()==0) {
                        System.out.print(m.getMap()[i][j]);
                    }
                    else if (m.getMap()[i][j].getType()==1) {
                        System.out.print(m.getMap()[i][j]);
                    }
                    else if (m.getMap()[i][j].getType()==2) {
                        System.out.print(m.getMap()[i][j]);
                    }
                    else if (m.getMap()[i][j].getType()==3) {
                        System.out.print(m.getMap()[i][j]);
                    }
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.print("+");
            for (int l=0;l<m.getMap()[0].length;l++)
                System.out.print("-");
            System.out.print("+");
            
            next = n.next().charAt(0);

        }
    }
}
