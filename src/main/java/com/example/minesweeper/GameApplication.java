package com.example.minesweeper;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240)
        int level = 20;
        Game game = new Game(level);
        GridPane cellPane = Game.getPane();
        Cell[][] cell = Game.getCell();
        for(int i = 0; i < Game.X; i++){
            for(int j = 0; j < Game.Y; j++){
                final int x = i, y = j;
                cell[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        System.out.println(cell[x][y].getNearMine());
                        cell[x][y].setFill(Color.TRANSPARENT);
                    }
                });
            }
        }
        cellPane.setTranslateY(150);
        Scene scene = new Scene(cellPane,600, 800);
        stage.setTitle("Mine Sweeper");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}