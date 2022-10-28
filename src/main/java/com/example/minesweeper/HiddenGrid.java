package com.example.minesweeper;

public class HiddenGrid {
    private int n;
    private int cell[][];

    public HiddenGrid(int n) {
        this.n = n;
        cell = new int[n][n];
    }

    public void printHiddenGrid(){
        for(int i = 0; i < this.n; i++){
            for (int j = 0; j < this.n; j++)
                System.out.printf("%d ", this.cell[i][j]);
            System.out.println();
        }
    }

    public void openCell(int x, int y, int k){
        this.cell[x][y] = k;
    }
}
