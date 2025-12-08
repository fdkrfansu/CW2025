package com.comp2042;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Represents the pause overlay screen.
 * Appears when the game is paused, offering options to Resume, View Controls,
 * or Exit to Main Menu.
 * features a semi-transparent dark background for better visibility over the
 * game board.
 */
public class PauseMenuScreen extends BorderPane {

    private final Button resumeButton;
    private final Button controlsButton;
    private final Button exitButton;

    public PauseMenuScreen() {
        resumeButton = new Button("RESUME");
        resumeButton.setPrefWidth(200);
        resumeButton.setPrefHeight(60);
        resumeButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(resumeButton);

        controlsButton = new Button("CONTROLS");
        controlsButton.setPrefWidth(200);
        controlsButton.setPrefHeight(60);
        controlsButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(controlsButton);

        exitButton = new Button("EXIT TO MAIN MENU");
        exitButton.setPrefWidth(300);
        exitButton.setPrefHeight(60);
        exitButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(exitButton);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(resumeButton, controlsButton, exitButton);

        setCenter(vbox);
        setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);");
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
