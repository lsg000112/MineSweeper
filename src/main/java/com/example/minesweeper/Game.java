package com.example.minesweeper;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static int minesLeft;
    public static final int X = 20, Y = 20;
    HiddenGrid hiddenGrid;
    public static GridPane getPane() {
        return pane;
    }
    private static Cell[][] cell = new Cell[X][Y];
    static GridPane pane = new GridPane();

    public Game(int n) {
        minesLeft = n;
        for(int i = 0; i < X; i++){
            for(int j = 0; j < Y; j++){
                cell[i][j] = new Cell();
                cell[i][j].setTranslateX(i * 30);
                cell[i][j].setTranslateY(j * 30);
                cell[i][j].getNearMineText().setTranslateX(i * 30);
                cell[i][j].getNearMineText().setTranslateY(j * 30);
                cell[i][j].setWidth(30);
                cell[i][j].setHeight(30);
                cell[i][j].setStroke(Color.BLACK);
                cell[i][j].setFill(Color.GREY);
                pane.getChildren().addAll(cell[i][j].getObject());
            }
        }
        generateMine(n, X*Y);
    }

    public static Cell[][] getCell() {
        return cell;
    }

    private void generateMine(int numberOfMines, int numberOfCells) {
        ArrayList<Integer> a = new ArrayList<>();
        Random random = new Random();
        while (a.size() != numberOfMines){
            int k = random.nextInt(numberOfCells);
            if(!a.contains(k)) {
                a.add(k);
                cell[k/X][k%Y].setMine(true);
            }
        }
        for(int i = 0; i < X; i++){
            for(int j = 0; j < Y; j++){
                if(!cell[i][j].isMine())
                    cell[i][j].setNearMine(getNearMine(i,j));
                else cell[i][j].setNearMine(-1);
            }
        }
    }

    public int getNearMine(int x, int y){ //3.2일때
        int up, down, left, right, cnt = 0;
        up = (y==0)?0:y-1;//1
        down = (y==Y-1)?Y-1:y+1;//3
        right = (x==X-1)?X-1:x+1;//4
        left = (x==0)?0:x-1;//2

        for(int i = left; i <= right; i++){
            for (int j = up; j <= down; j++){
                if (cell[i][j].isMine())
                    cnt++;
            }
        }
        return cnt;
    }


}
