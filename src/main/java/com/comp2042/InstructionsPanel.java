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
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-font-weight: bold;");

        final Label controls = new Label(
                "↑ / W = Rotate clockwise\n" +
                        "← / A = Move left\n" +
                        "→ / D = Move right\n" +
                        "↓ / S = Faster drop\n" +
                        "SPACE = Hard drop\n" +
                        "SHIFT = Hold/Replace block\n" +
                        "ESC = Pause\n" +
                        "N = New game");
        controls.setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-text-alignment: left;");

        backButton = new Button("Back");
        backButton.setPrefWidth(120);
        backButton.setPrefHeight(40);
        backButton.setStyle("-fx-font-size: 16px;");

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, controls, backButton);

        setCenter(vbox);
        setStyle("-fx-background-color: rgba(0, 0, 0, 0.9);");
    }

    public void setOnBack(EventHandler<MouseEvent> handler) {
        backButton.setOnMouseClicked(handler);
    }
}
