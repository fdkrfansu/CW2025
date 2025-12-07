package com.comp2042;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainMenuPanel extends BorderPane {

    private final Button playButton;
    private final Button controlsButton;
    private final Button exitButton;

    public MainMenuPanel() {
        final Label titleLabel = new Label("TETRIS");
        titleLabel.setStyle("-fx-font-size: 48px; -fx-text-fill: white; -fx-font-weight: bold;");

        playButton = new Button("Play");
        playButton.setPrefWidth(150);
        playButton.setPrefHeight(50);
        playButton.setStyle("-fx-font-size: 20px;");

        controlsButton = new Button("Controls");
        controlsButton.setPrefWidth(150);
        controlsButton.setPrefHeight(50);
        controlsButton.setStyle("-fx-font-size: 20px;");

        exitButton = new Button("Exit");
        exitButton.setPrefWidth(150);
        exitButton.setPrefHeight(50);
        exitButton.setStyle("-fx-font-size: 20px;");

        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, playButton, controlsButton, exitButton);

        setCenter(vbox);
        setStyle("-fx-background-color: rgba(0, 0, 0, 0.9);");
    }

    public void setOnPlay(EventHandler<MouseEvent> handler) {
        playButton.setOnMouseClicked(handler);
    }

    public void setOnControls(EventHandler<MouseEvent> handler) {
        controlsButton.setOnMouseClicked(handler);
    }

    public void setOnExit(EventHandler<MouseEvent> handler) {
        exitButton.setOnMouseClicked(handler);
    }
}
