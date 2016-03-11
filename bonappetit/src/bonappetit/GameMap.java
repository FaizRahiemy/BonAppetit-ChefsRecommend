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
public class GameMap {
    private Asset map[][];
    private final int row;
    private final int column;
    
    public GameMap(int row, int column) {
        this.row = row;
        this.column = column;
        map = new Asset[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    public void addAsset(Asset a) {
        map[a.getPosY()][a.getPosX()] = a;
    }
    
    public void removeAsset(int posY, int posX) {
        map[posY][posX] = null;
    }
    
    public boolean findAsset(Asset a) {
        boolean ret = false;
        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[i].length;j++) {
                if(map[i][j]==a) {
                    ret = true;
		}
            }
	}
        return ret;
    }
}
