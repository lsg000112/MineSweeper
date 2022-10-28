package com.example.minesweeper;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Cell extends Rectangle
{
    private boolean isMine;

    public StackPane getObject() {
        return stackPane;
    }

    public int getNearMine() {
        if(this.isMine())
            return -1;
        return nearMine;
    }

    public void setNearMine(int nearMine) {
        this.nearMine = nearMine;
        this.nearMineText.setText(String.valueOf(nearMine));
        this.stackPane.getChildren().addAll(this.nearMineText, this);
        stackPane.setPickOnBounds(false);
    }

    private int nearMine;
    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isMine() {
        return isMine;
    }

    private final StackPane stackPane = new StackPane();

    public Text getNearMineText() {
        return nearMineText;
    }

    private final Text nearMineText = new Text();

}
