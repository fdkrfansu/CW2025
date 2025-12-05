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
                returnPaint = Color.AQUA;
                break;
            case J:
                returnPaint = Color.BLUEVIOLET;
                break;
            case L:
                returnPaint = Color.DARKGREEN;
                break;
            case O:
                returnPaint = Color.YELLOW;
                break;
            case S:
                returnPaint = Color.RED;
                break;
            case T:
                returnPaint = Color.BEIGE;
                break;
            case Z:
                returnPaint = Color.BURLYWOOD;
                break;
            default:
                returnPaint = Color.WHITE;
                break;
        }
        return returnPaint;
    }
}
