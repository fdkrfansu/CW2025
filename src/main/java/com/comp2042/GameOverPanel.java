package com.comp2042;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GameOverPanel extends BorderPane {

    private final Button newGameButton;
    private final Button exitButton;

    public GameOverPanel() {
        final Label gameOverLabel = new Label("GAME OVER");
        gameOverLabel.getStyleClass().add("gameOverStyle");

        newGameButton = new Button("New Game");
        newGameButton.setPrefWidth(120);
        newGameButton.setPrefHeight(40);

        exitButton = new Button("Exit");
        exitButton.setPrefWidth(120);
        exitButton.setPrefHeight(40);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(gameOverLabel, newGameButton, exitButton);

        setCenter(vbox);
    }

    public void setOnNewGame(EventHandler<MouseEvent> handler) {
        newGameButton.setOnMouseClicked(handler);
    }

    public void setOnExit(EventHandler<MouseEvent> handler) {
        exitButton.setOnMouseClicked(handler);
    }

}
