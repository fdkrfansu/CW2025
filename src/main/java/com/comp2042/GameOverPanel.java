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
        gameOverLabel
                .setStyle("-fx-font-family: 'VT323'; -fx-font-size: 100px; -fx-text-fill: red; -fx-font-weight: bold;");

        final Label spicyLabel = new Label("Too spicy for you?");
        spicyLabel.setStyle("-fx-font-family: 'VT323'; -fx-font-size: 20px; -fx-text-fill: red;");

        newGameButton = new Button("NEW GAME");
        newGameButton.setPrefWidth(200);
        newGameButton.setPrefHeight(60);
        newGameButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(newGameButton);

        exitButton = new Button("EXIT TO MAIN MENU");
        exitButton.setPrefWidth(300);
        exitButton.setPrefHeight(60);
        exitButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(exitButton);

        VBox textVBox = new VBox(0);
        textVBox.setAlignment(Pos.CENTER);
        textVBox.getChildren().addAll(gameOverLabel, spicyLabel);

        VBox vbox = new VBox(50);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(textVBox, newGameButton, exitButton);

        setCenter(vbox);
        setStyle("-fx-background-color: rgba(0, 0, 0, 0.8);");
    }

    private void createHoverEffect(Button button) {
        button.setOnMouseEntered(e -> {
            button.setScaleX(1.1);
            button.setScaleY(1.1);
            button.setStyle(
                    "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        });
        button.setOnMouseExited(e -> {
            button.setScaleX(1.0);
            button.setScaleY(1.0);
            button.setStyle(
                    "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        });
    }

    public void setOnNewGame(EventHandler<MouseEvent> handler) {
        newGameButton.setOnMouseClicked(handler);
    }

    public void setOnExit(EventHandler<MouseEvent> handler) {
        exitButton.setOnMouseClicked(handler);
    }

}
