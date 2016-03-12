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
    
    private GameMap m = new GameMap(25,80);
    private Asset player = new SpeciesA(13,40,1,2);
    private Asset npc1 = new SpeciesB(10,21,1,0);
    private Asset npc2 = new SpeciesC(23,65,1,1);
    private Asset food1 = new Food(21,15,1);
    private Asset food2 = new Food(10,72,0);
    private Asset food3 = new Food(13,60,1);
    
    Random rand = new Random();
    Scanner n = new Scanner(System.in);
    
    public void moving(Asset a) {
     //   if (a.getPosY()>0)
     //       if (m.getMap()[a.getPosY()-1][a.getPosX()]!=null&&m.getMap()[a.getPosY()-1][a.getPosX()].getLevel()<a.getLevel())
        int r = rand.nextInt(4);
        Asset temp;
        if (r==0) {
            temp = a;
            a.move('u',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            m.removeAsset(temp);
        }
        else if (r==1) {
            temp = a;
            a.move('d',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            m.removeAsset(temp);
        }
        else if (r==2) {
            temp = a;
            a.move('l',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            m.removeAsset(temp);
        }
        else {
            temp = a;
            a.move('r',m.getRow(),m.getColumn(),m.getMap());
            m.addAsset(a);
            m.removeAsset(temp);
        }
    
    }
    
    public void play() {
        
        m.addAsset(player);
        m.addAsset(npc1);
        m.addAsset(npc2);
        m.addAsset(food1);
        m.addAsset(food2);
        m.addAsset(food3);
        
        for (int i=0;i<m.getMap().length;i++) {
            for (int j=0;j<m.getMap()[i].length;j++) {
                if (m.getMap()[i][j]==null) {
                    System.out.print(' ');
                }
		else if (m.getMap()[i][j].getType()==0) {
                    System.out.print('0');
                }
                else if (m.getMap()[i][j].getType()==1) {
                    System.out.print('A');
                }
                else if (m.getMap()[i][j].getType()==2) {
                    System.out.print('B');
                }
                else if (m.getMap()[i][j].getType()==3) {
                    System.out.print('C');
                }
            }
            System.out.println();
        }
        
        //char next = n.next().charAt(0);
        
        for (int k=0; k<15; k++) {
            moving(m.getAsset(player));
            moving(m.getAsset(npc1));
            moving(m.getAsset(npc2));
            moving(m.getAsset(food1));
            moving(m.getAsset(food2));
            moving(m.getAsset(food3));
            
            System.out.println();
            
            for (int i=0;i<m.getMap().length;i++) {
            for (int j=0;j<m.getMap()[i].length;j++) {
                if (m.getMap()[i][j]==null) {
                    System.out.print(' ');
                }
		else if (m.getMap()[i][j].getType()==0) {
                    System.out.print('0');
                }
                else if (m.getMap()[i][j].getType()==1) {
                    System.out.print('A');
                }
                else if (m.getMap()[i][j].getType()==2) {
                    System.out.print('B');
                }
                else if (m.getMap()[i][j].getType()==3) {
                    System.out.print('C');
                }
            }
            System.out.println();
            }
            
            //next = n.next().charAt(0);

        }
    }
}
