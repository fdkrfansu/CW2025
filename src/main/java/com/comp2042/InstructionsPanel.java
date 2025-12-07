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
        titleLabel.setStyle("-fx-font-size: 32px; -fx-text-fill: white; -fx-font-weight: bold;");

        final Label controls = new Label(
                "• ↑ / W - Rotate\n" +
                        "• ← / A - Move Left\n" +
                        "• → / D - Move Right\n" +
                        "• ↓ / S - Drop Faster\n" +
                        "• SPACE - Hard Drop\n" +
                        "• SHIFT - Hold Block\n" +
                        "• ESC - Pause\n" +
                        "• N - New Game");
        controls.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");

        backButton = new Button("Back");
        backButton.setPrefWidth(150);
        backButton.setPrefHeight(50);
        backButton.setStyle("-fx-font-size: 20px;");

        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, controls, backButton);

        setCenter(vbox);
        setStyle("-fx-background-color: rgba(0, 0, 0, 0.9);");
    }

    public void setOnBack(EventHandler<MouseEvent> handler) {
        backButton.setOnMouseClicked(handler);
    }
}
