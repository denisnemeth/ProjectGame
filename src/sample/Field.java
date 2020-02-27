package sample;

import java.util.Random;

public class Field {

    private Tile[][] arr;

    public Field() {initField();}
    public Tile[][] getArr() {return arr;}
    public void setArr(Tile[][] arr) {this.arr = arr;}
    public void initField() {
        arr = new Tile[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = new Tile();
            }
        }
    }
    public boolean isWinner() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j].isValue()) count++;
            }
        }
        if (count == 0 || count == 16) return true;
        else return false;
    }
    public void toggleTile1(int code) {
        int x = code%arr.length, y = code/arr.length;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((x+i >= 0 && x+i < arr.length) && (y+j >= 0 && y+j < arr.length) && !(i == 0 && j == 0)) arr[x+i][y+j].toggle();
            }
        }
    }
    public void toggleTile2(int code) {
        int x = code%arr.length, y = code/arr.length;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (!(x == i && y == j) && Math.abs(x-j) <= 1 && Math.abs(y-i) <= 1) arr[j][i].toggle();
            }
        }
    }
    public void print () {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j].isValue() ? " X " : " O ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void shuffle() {
        Random rnd = new Random();
        do {
            for (int i = 0; i < 50; i++) toggleTile1(rnd.nextInt(15));
        } while (isWinner());
    }
}
