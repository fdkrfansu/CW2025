package com.comp2042;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PauseMenuScreen extends BorderPane {

    private final Button resumeButton;
    private final Button controlsButton;
    private final Button exitButton;

    public PauseMenuScreen() {
        resumeButton = new Button("Resume");
        resumeButton.setPrefWidth(180);
        resumeButton.setPrefHeight(40);

        controlsButton = new Button("Controls");
        controlsButton.setPrefWidth(180);
        controlsButton.setPrefHeight(40);

        exitButton = new Button("Exit to Main Menu");
        exitButton.setPrefWidth(180);
        exitButton.setPrefHeight(40);

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(resumeButton, controlsButton, exitButton);

        setCenter(vbox);
        setStyle("-fx-background-color: rgba(255, 255, 255, 0.8); -fx-background-radius: 10;");
    }

    public void setOnResume(EventHandler<MouseEvent> handler) {
        resumeButton.setOnMouseClicked(handler);
    }

    public void setOnControls(EventHandler<MouseEvent> handler) {
        controlsButton.setOnMouseClicked(handler);
    }

    public void setOnExit(EventHandler<MouseEvent> handler) {
        exitButton.setOnMouseClicked(handler);
    }
}
