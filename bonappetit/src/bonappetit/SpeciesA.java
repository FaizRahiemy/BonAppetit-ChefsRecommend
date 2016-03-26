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
public class SpeciesA extends Ordo implements java.io.Serializable {
    //skill : movement no delay

    public SpeciesA(int posY, int posX, int level, int delay) {
        super(posY, posX, level, delay);
        super.setType(1);
    }

    @Override
    public void move(char dir, int row, int column, Asset[][] map) {
        if (super.getDelay() > 0) {
            if (dir == 'u' || dir == 'U') {
                if (super.getPosY() > 0) {
                    super.setPosY(super.getPosY() - 1);
                }
            } else if (dir == 'd' || dir == 'D') {
                if (super.getPosY() < (row - 1)) {
                    super.setPosY(super.getPosY() + 1);
                }
            } else if (dir == 'r' || dir == 'R') {
                if (super.getPosX() < (column - 1)) {
                    super.setPosX(super.getPosX() + 1);
                }
            } else if (dir == 'l' || dir == 'L') {
                if (super.getPosX() > 0) {
                    super.setPosX(super.getPosX() - 1);
                }
            }
            if (super.getDuration()>0) {
                super.setDelay(super.getDelay() + 3);
                super.setDuration(super.getDuration()-1);
            }
            else
                super.setDelay(super.getDelay() - 1);
        } else {
            super.setDelay(super.getLevel() + 1);
        }
    }

    @Override
    public String toString() {
        if (super.getLevel() == 1) {
            return "a";
        } else if (super.getLevel() == 2) {
            return "A";
        } else {
            return "Д";
        }
    }

}
