package com.comp2042;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PauseMenuScreen extends BorderPane {

    private final Button resumeButton;
    private final Button exitButton;

    public PauseMenuScreen() {
        resumeButton = new Button("Resume");
        resumeButton.setPrefWidth(100);
        resumeButton.setPrefHeight(40);

        exitButton = new Button("Exit");
        exitButton.setPrefWidth(100);
        exitButton.setPrefHeight(40);

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(resumeButton, exitButton);

        setCenter(vbox);
        setStyle("-fx-background-color: rgba(255, 255, 255, 0.8); -fx-background-radius: 10;");
    }

    public void setOnResume(EventHandler<MouseEvent> handler) {
        resumeButton.setOnMouseClicked(handler);
    }

    public void setOnExit(EventHandler<MouseEvent> handler) {
        exitButton.setOnMouseClicked(handler);
    }
}
