package com.comp2042;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class InstructionsPanel extends BorderPane {

    private final Button backButton;

    public InstructionsPanel() {
        final Label titleLabel = new Label("CONTROLS");
        titleLabel.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 60px; -fx-text-fill: white; -fx-font-weight: bold;");

        final Label controls = new Label(
                "• ↑ / W - Rotate\n" +
                        "• ← / A - Move Left\n" +
                        "• → / D - Move Right\n" +
                        "• ↓ / S - Drop Faster\n" +
                        "• CTRL - Rotate Anti-Clockwise\n" +
                        "• SPACE - Hard Drop\n" +
                        "• SHIFT - Hold Block\n" +
                        "• ESC - Pause\n" +
                        "• N - New Game");
        controls.setStyle("-fx-font-family: 'VT323'; -fx-font-size: 24px; -fx-text-fill: white;");

        backButton = new Button("BACK");
        backButton.setPrefWidth(200);
        backButton.setPrefHeight(60);
        backButton.setStyle(
                "-fx-font-family: 'VT323'; -fx-font-size: 30px; -fx-background-color: black; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        createHoverEffect(backButton);

        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, controls, backButton);

        setCenter(vbox);
        setStyle("-fx-background-color: rgba(0, 0, 0, 0.9);");
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

    public void setOnBack(EventHandler<MouseEvent> handler) {
        backButton.setOnMouseClicked(handler);
    }
}
