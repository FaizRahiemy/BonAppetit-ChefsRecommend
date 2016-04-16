/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Credit;

/**
 *
 * @author Novak
 */
public class ControllerCredit implements ActionListener, Runnable {
    Credit c;

    public ControllerCredit() {
        c = new Credit();
        c.setResizable(false);
        c.getBtnMenu().addActionListener(this);
        c.getTextCredit().setText("");
        c.setVisible(true);
        
        Thread t = new Thread(this);
        t.start();
    }
    
    
    public void show() {
        try {
            c.getTextCredit().append(" Bon Appetit Credits \n");
            Thread.sleep(1000);
            c.getTextCredit().append(" Chef de Cuisine \t : Ubassy Abdillah \n");
            Thread.sleep(1000);
            c.getTextCredit().append(" Sous Chef       \t \t : Mohammad Zakie Faiz Rahiemy \n");
            Thread.sleep(1000);
            c.getTextCredit().append(" Chef de Parte   \t \t : Raja Ryan Pradana \n");
            Thread.sleep(1000);
            for (int i = 0; i < 5; i++) {
                c.getTextCredit().append(" Lots of text \n");
                Thread.sleep(100);
            }
            for (int i = 0; i < 2; i++) {
                c.getTextCredit().append(" Lots of things \n");
               Thread.sleep(100);
            }
            c.getTextCredit().append(" tl;dr lol \n");
            Thread.sleep(100);
            c.getTextCredit().append(" Special Thanks \n");
            Thread.sleep(1000);
            c.getTextCredit().append(" Lots of asprak \n");
            Thread.sleep(1000);
            c.getTextCredit().append(" and especially YOU \n");
        } catch (Throwable f) {
            f.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if (x.equals(c.getBtnMenu())) {
            ControllerMainMenu cm = new ControllerMainMenu();
            
            c.dispose();
        }
    }

    @Override
    public void run() {
        this.show();
    }
    
}
