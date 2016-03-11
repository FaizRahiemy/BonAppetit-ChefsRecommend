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
public class SpeciesA extends Ordo {
    //skill : movement 2x faster
    
    public SpeciesA(int posY, int posX, int level) {
        super(posY,posX,level);
        super.setType(1);
    }
    
    @Override
    public void move(char dir) {
        if (super.getSpeciality()>0) {
            if (dir=='u'||dir=='U') {
                super.setPosY(super.getPosY()-2);
                super.setSpeciality(super.getSpeciality()-1);
            }
            else if (dir=='d'||dir=='D') {
                super.setPosY(super.getPosY()+2);
                super.setSpeciality(super.getSpeciality()-1);
            }
            else if (dir=='r'||dir=='R') {
                super.setPosX(super.getPosX()+2);
                super.setSpeciality(super.getSpeciality()-1);
            }
            else if (dir=='l'||dir=='L') {
                super.setPosX(super.getPosX()-2);
                super.setSpeciality(super.getSpeciality()-1);
            }
        }
        else {
            if (dir=='u'||dir=='U') {
                super.setPosY(super.getPosY()-1);
            }
            else if (dir=='d'||dir=='D') {
                super.setPosY(super.getPosY()+1);
            }
            else if (dir=='r'||dir=='R') {
                super.setPosX(super.getPosX()+1);
            }
            else if (dir=='l'||dir=='L') {
                super.setPosX(super.getPosX()-1);
            }
        }
    }
    
}
