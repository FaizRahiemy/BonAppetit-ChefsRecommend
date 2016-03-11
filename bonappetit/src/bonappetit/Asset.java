/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

/**
 *
 * @author Kel. 8
 */
public abstract class Asset {
    private int type;
    private int level;
    private int exp;
    private int speciality;
    protected int expMax[] = new int[3];
    private int posX;
    private int posY;
    
    public Asset(int posY, int posX) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public abstract void move(char dir);
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

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }
    
}
