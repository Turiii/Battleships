package Controller;


import Model.Point;

public class Ocean implements OceanInterface {
    private char[][] ocean = new char[10][10];

    public Ocean() {

    }

    public char[][] getOcean() {
        return ocean;
    }

    @Override
    public void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + ocean[i][j]);
            }
            System.out.println();
        }
    }


    @Override
    public void start() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ocean[i][j] = '~';
            }
        }
    }

    @Override
    public boolean isOccupied(Point point) {
        return ocean[point.getY()][point.getX()] == 'O';
    }
}
