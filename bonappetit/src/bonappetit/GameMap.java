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
        if (a!=null)
            map[a.getPosY()][a.getPosX()] = a;
    }

//    public void removeAsset(int posY, int posX) {
//        map[posY][posX] = null;
//    }
//
//    public boolean findAsset(Asset a) {
//        boolean ret = false;
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                if (map[i][j] == a) {
//                    ret = true;
//                }
//            }
//        }
//        return ret;
//    }

    public Asset getAsset(Asset a) {
        int posY = 0;
        int posX = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == a) {
                    posY = i;
                    posX = j;
                }
            }
        }
        if (posY != 0 && posX != 0) {
            return map[posY][posX];
        } else {
            return null;
        }
    }

    public void display() {
        try {
            System.out.print("+");
            for (int l = 0; l < map[0].length; l++) {
                System.out.print("-");
            }
            System.out.println("+");
            for (int i = 0; i < map.length; i++) {
                System.out.print("|");
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == null) {
                        System.out.print(' ');
                    } else {
                        System.out.print(map[i][j]);
                    }
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.print("+");
            for (int l = 0; l < map[0].length; l++) {
                System.out.print("-");
            }
            System.out.print("+");
            System.out.println();
            Thread.sleep(1000);
        } catch (Throwable f) {
            f.printStackTrace();
        }
    }

    public void display2() {
            
            System.out.print("+");
            for (int l = 0; l < map[0].length; l++) {
                System.out.print("-");
            }
            System.out.println("+");
            for (int i = 0; i < map.length; i++) {
                System.out.print("|");
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == null) {
                        System.out.print(' ');
                    } else {
                        System.out.print(map[i][j]);
                    }
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.print("+");
            for (int l = 0; l < map[0].length; l++) {
                System.out.print("-");
            }
            System.out.print("+");
            System.out.println();
    }
    
    public void nullMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = null;
            }
        }
    }

    public Asset[][] getMap() {
        return map;
    }

}
