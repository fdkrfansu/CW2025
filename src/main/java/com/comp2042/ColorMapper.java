package com.comp2042;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ColorMapper {

    public static Paint getFillColor(int i) {
        Paint returnPaint;
        switch (BrickType.fromValue(i)) {
            case NONE:
                returnPaint = Color.TRANSPARENT;
                break;
            case I:
                returnPaint = Color.web("#FFD700"); // Tofu/Tempeh (Gold)
                break;
            case J:
                returnPaint = Color.web("#B22222"); // Spicy (Dark Red)
                break;
            case L:
                returnPaint = Color.web("#FF4500"); // Sambal (Orange Red)
                break;
            case O:
                returnPaint = Color.web("#FAF5E9"); // Rice (White)
                break;
            case S:
                returnPaint = Color.web("#FF0000"); // Chili (Red)
                break;
            case T:
                returnPaint = Color.web("#8B4513"); // Fried Chicken (Saddle Brown)
                break;
            case Z:
                returnPaint = Color.web("#32CD32"); // Cucumber/Cabbage (Lime Green)
                break;
            default:
                returnPaint = Color.WHITE;
                break;
        }
        return returnPaint;
    }
}
