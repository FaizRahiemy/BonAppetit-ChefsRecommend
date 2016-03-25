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
    
    public Food(int posY, int posX, int delay) {
        super(posY,posX);
        super.setLevel(0);
        super.setType(0);
        super.setDelay(delay); //temporary
    }
    
    @Override
    public void move(char dir, int row, int column, Asset[][] map) {
        if (super.getDelay()==0) {
                if (super.getPosY()==0&&super.getPosX()==0) {
                    if (map[super.getPosY()+1][super.getPosX()]!=null) {
                        super.setPosX(super.getPosX()+1);
                    }
                    else {
                        super.setPosY(super.getPosY()+1);
                    }
                    super.setDelay(1);
                }
                else if (super.getPosY()==0&&super.getPosX()==column-1) {
                    if (map[super.getPosY()+1][super.getPosX()]!=null) {
                        super.setPosX(super.getPosX()-1);
                    }
                    else {
                        super.setPosY(super.getPosY()+1);
                    }
                    super.setDelay(1);
                }
                else if (super.getPosY()==row-1&&super.getPosX()==0) {
                    if (map[super.getPosY()+1][super.getPosX()]!=null)
                        super.setPosX(super.getPosX()+1);
                    else 
                        super.setPosY(super.getPosY()-1);
                    super.setDelay(1);
                }
                else if (super.getPosY()==row-1&&super.getPosX()==column-1) {
                    if (map[super.getPosY()-1][super.getPosX()]!=null)
                        super.setPosX(super.getPosX()-1);
                    else
                        super.setPosY(super.getPosY()-1);
                    super.setDelay(1);
                }
                else if (super.getPosY()==0) {
                    if (map[super.getPosY()][super.getPosX()+1]!=null)
                        super.setPosX(super.getPosX()-1);
                    else if (map[super.getPosY()][super.getPosX()-1]!=null)
                        super.setPosY(super.getPosY()+1);
                    else
                        super.setPosX(super.getPosX()+1);
                    super.setDelay(1);
                }
                else if (super.getPosY()==row-1) {
                    if (map[super.getPosY()-1][super.getPosX()]!=null)
                        super.setPosX(super.getPosX()-1);
                    else if (map[super.getPosY()][super.getPosX()-1]!=null)
                        super.setPosY(super.getPosY()-1);
                    else
                        super.setPosX(super.getPosX()+1);
                    super.setDelay(1);
                }
                else if (super.getPosX()==0) {
                    if (map[super.getPosY()-1][super.getPosX()]!=null)
                        super.setPosX(super.getPosX()+1);
                    else if (map[super.getPosY()+1][super.getPosX()]!=null)
                        super.setPosY(super.getPosY()-1);
                    else
                        super.setPosY(super.getPosY()+1);
                    super.setDelay(1);
                }
                else if (super.getPosX()==column-1) {
                    if (map[super.getPosY()-1][super.getPosX()]!=null)
                        super.setPosX(super.getPosX()-1);
                    else if (map[super.getPosY()][super.getPosX()-1]!=null)
                        super.setPosY(super.getPosY()-1);
                    else
                        super.setPosY(super.getPosY()+1);
                    super.setDelay(1);
                }
                else if (map[super.getPosY()][super.getPosX()-1]!=null||map[super.getPosY()][super.getPosX()+1]!=null||
                        map[super.getPosY()-1][super.getPosX()]!=null||map[super.getPosY()+1][super.getPosX()]!=null){
                    if (map[super.getPosY()-1][super.getPosX()]!=null)
                        super.setPosY(super.getPosY()+1);
                    else if (map[super.getPosY()+1][super.getPosX()]!=null)
                        super.setPosY(super.getPosY()-1);
                    else if (map[super.getPosY()][super.getPosX()-1]!=null)
                        super.setPosX(super.getPosX()+1);
                    else
                        super.setPosX(super.getPosX()-1);
                    super.setDelay(1);
                }
                else {
                    if (dir=='u'||dir=='U') {
                        if (super.getPosY()>0) {
                            super.setPosY(super.getPosY()-1);
                            super.setDelay(1);
                        }
                    }
                    else if (dir=='d'||dir=='D') {
                        if (super.getPosY()<(row-1)){
                            super.setPosY(super.getPosY()+1);
                            super.setDelay(1);
                        }
                    }
                    else if (dir=='r'||dir=='R') {
                        if (super.getPosX()<(column-1)){
                            super.setPosX(super.getPosX()+1);
                            super.setDelay(1);
                        }
                    }
                    else if (dir=='l'||dir=='L') {
                        if (super.getPosX()>0) {
                            super.setPosX(super.getPosX()-1);
                            super.setDelay(1);
                        }
                    }
                }
        }
        else
            super.setDelay(0);
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
    
    @Override
    public String toString() {
        return "0";
    }
}
