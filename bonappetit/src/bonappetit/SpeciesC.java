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
public class SpeciesC extends Ordo {
    //skill : fast level up
    public SpeciesC(int posY, int posX, int level, int delay) {
        super(posY,posX,level,delay);
        super.setType(3);
    }
    
    @Override
    public void move(char dir, int row, int column, Asset[][] map) {
        if (super.getDelay()>0) {
        if (dir=='u'||dir=='U') {
            if (super.getPosY()>0) {
                super.setPosY(super.getPosY()-1);
                super.setDelay(super.getDelay()-1);
            }
        }
        else if (dir=='d'||dir=='D') {
            if (super.getPosY()<(row-1)){
                super.setPosY(super.getPosY()+1);
                super.setDelay(super.getDelay()-1);
            }
        }
        else if (dir=='r'||dir=='R') {
            if (super.getPosX()<(column-1)){
                super.setPosX(super.getPosX()+1);
                super.setDelay(super.getDelay()-1);
            }
        }
        else if (dir=='l'||dir=='L') {
            if (super.getPosX()>0) {
                super.setPosX(super.getPosX()-1);
                super.setDelay(super.getDelay()-1);
            }
        }
        }
        else
            super.setDelay(super.getLevel()+1);
    }
    
    public String toString() {
        if (super.getLevel()==1)
            return "c";
        else if (super.getLevel()==2)
            return "C";
        else
            return "C^";
    }
}
