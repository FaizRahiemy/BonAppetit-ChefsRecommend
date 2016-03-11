/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonappetit;

/**
 *
 * @author No. 8
 */
public class Food extends Asset {
    
    public Food(int posY, int posX) {
        super(posY,posX);
        super.setLevel(0);
        super.setType(0);
        super.setSpeciality(0);
    }
    
    @Override
    public void move(char dir) {
        if (super.getSpeciality()==0) {
            if (dir=='u'||dir=='U') {
                super.setPosY(super.getPosY()-1);
                super.setSpeciality(1);
            }
            else if (dir=='d'||dir=='D') {
                super.setPosY(super.getPosY()+1);
                super.setSpeciality(1);
            }
            else if (dir=='r'||dir=='R') {
                super.setPosX(super.getPosX()+1);
                super.setSpeciality(1);
            }
            else if (dir=='l'||dir=='L') {
                super.setPosX(super.getPosX()-1);
                super.setSpeciality(1);
            }
        }
        else
            super.setSpeciality(0);
    }
    
    @Override
    public void evolution() {
        super.setLevel(0);
        super.setType(0);
    }
    
    @Override
    public void skill() {
        super.setLevel(0);
        super.setType(0);
    }
}
