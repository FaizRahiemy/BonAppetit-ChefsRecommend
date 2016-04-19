/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Novak
 */
public class SpeciesC extends Ordo implements java.io.Serializable {

    //skill : fast level up
    public SpeciesC(int posY, int posX, int level, int delay) {
        super(posY, posX, level, delay);
        super.setType(3);
    }

    @Override
    public void move(char dir, int row, int column, Asset[][] map) {
        if (super.getDelay() > 0) {
            if (dir == 'u' || dir == 'U') {
                if (super.getPosY() > 0) {
                    if (map[super.getPosY()-1][super.getPosX()]!=null&&map[super.getPosY()-1][super.getPosX()].getLevel()<=super.getLevel()) {
                        if (super.getDuration()>0) {
                            super.setExp(super.getExp()+2); 
                            super.setDuration(super.getDuration()-1);
                        }
                        else {
                            super.setExp(super.getExp()+1);
                        }
                    }
                    super.setPosY(super.getPosY() - 1);
                }
            } else if (dir == 'd' || dir == 'D') {
                if (super.getPosY() < (row - 1)) {
                    if (map[super.getPosY()+1][super.getPosX()]!=null&&map[super.getPosY()+1][super.getPosX()].getLevel()<=super.getLevel()) {
                        if (super.getDuration()>0) {
                            super.setExp(super.getExp()+2); 
                            super.setDuration(super.getDuration()-1);
                        }
                        else {
                            super.setExp(super.getExp()+1);
                        }   
                    }
                    super.setPosY(super.getPosY() + 1);
                }
            } else if (dir == 'r' || dir == 'R') {
                if (super.getPosX() < (column - 1)) {
                    if (map[super.getPosY()][super.getPosX()+1]!=null&&map[super.getPosY()][super.getPosX()+1].getLevel()<=super.getLevel()) {
                        if (super.getDuration()>0) {
                            super.setExp(super.getExp()+2); 
                            super.setDuration(super.getDuration()-1);
                        }
                        else {
                            super.setExp(super.getExp()+1);
                        }  
                    }
                    super.setPosX(super.getPosX() + 1);
                }
            } else if (dir == 'l' || dir == 'L') {
                if (super.getPosX() > 0) {
                    if (map[super.getPosY()][super.getPosX()-1]!=null&&map[super.getPosY()][super.getPosX()-1].getLevel()<=super.getLevel()) {
                        if (super.getDuration()>0) {
                            super.setExp(super.getExp()+2); 
                            super.setDuration(super.getDuration()-1);
                        }
                        else {
                            super.setExp(super.getExp()+1);
                        }    
                    }
                    super.setPosX(super.getPosX() - 1);
                }
            }
            super.setDelay(super.getDelay()-1);
            if (super.getLevel()<3) {
                if (super.expMax[super.getLevel()-1]<=super.getExp()) {
                    super.setExp(0);
                    super.setLevel(super.getLevel()+1);
                }
            }
        } else {
            super.setDelay(super.getLevel() + 3);
        }
    }

    @Override
    public String toString() {
        if (super.getLevel() == 1) {
            return "c";
        } else if (super.getLevel() == 2) {
            return "C";
        } else {
            return "€";
        }
    }
}
