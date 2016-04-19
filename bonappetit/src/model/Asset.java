/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kel. 8
 */
public abstract class Asset implements java.io.Serializable {
    private int type;
    private int level;
    private int exp;
    private int duration = -1;
    private int delay; //temporary
    protected int expMax[] = new int[3];
    private int posX;
    private int posY;
    
    public Asset(int posY, int posX) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public abstract void move(char dir, int row, int column, Asset[][] map);
    public abstract void evolution();
    public abstract void skill();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int speciality) {
        this.duration = speciality;
    }

    
    //temporary
    public int getDelay() {
        return delay;
    }

    //temporary
    public void setDelay(int delay) {
        this.delay = delay;
    }
    
}
