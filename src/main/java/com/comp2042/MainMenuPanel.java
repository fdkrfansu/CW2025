package com.comp2042;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class MainMenuPanel extends BorderPane {

    private final Button playButton;
    private final Button controlsButton;
    private final Button exitButton;

    public MainMenuPanel() {
        final Text titleLabel = new Text("TETRIS");
        titleLabel.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 100px; -fx-fill: white; -fx-stroke: black; -fx-stroke-width: 4px;");

        playButton = new Button("PLAY");
        playButton.setPrefWidth(200);
        playButton.setPrefHeight(60);
        playButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(playButton);

        controlsButton = new Button("CONTROLS");
        controlsButton.setPrefWidth(200);
        controlsButton.setPrefHeight(60);
        controlsButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(controlsButton);

        exitButton = new Button("EXIT");
        exitButton.setPrefWidth(200);
        exitButton.setPrefHeight(60);
        exitButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(exitButton);

        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new javafx.geometry.Insets(150, 0, 0, 0));
        vbox.getChildren().addAll(titleLabel, playButton, controlsButton, exitButton);

        ImageView plateView = new ImageView(new Image(getClass().getResource("/black_plate.png").toExternalForm()));
        plateView.setFitWidth(450);
        plateView.setFitHeight(450);
        plateView.setPreserveRatio(true);
        plateView.setTranslateY(120);

        StackPane stack = new StackPane();
        stack.getChildren().addAll(plateView, vbox);

        setCenter(stack);
        setStyle("-fx-background-color: transparent;");
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
