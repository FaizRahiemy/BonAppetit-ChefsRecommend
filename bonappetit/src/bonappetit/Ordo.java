/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

/**
 *
 * @author Novak
 */
public abstract class Ordo extends Asset {
    
    
    public Ordo(int posY, int posX, int level, int delay) {
        super(posY,posX);
        super.setLevel(level);
        super.expMax[0] = 2;
        super.expMax[1] = 3;
        super.expMax[2] = 5;
        super.setDelay(delay); //temporary
    }
    
    @Override
    public void evolution() {
        if (super.getLevel()<4)
            if (super.expMax[super.getLevel()-1]==super.getExp()) {
                super.setLevel(super.getLevel()+1);
                super.setExp(0);
            }
    }
    
    @Override
    public void skill() {
        if (super.getLevel()>=2)
            super.setDuration(3);
    }
    
    @Override
    public abstract void move(char dir, int row, int column, Asset[][] map);
}
