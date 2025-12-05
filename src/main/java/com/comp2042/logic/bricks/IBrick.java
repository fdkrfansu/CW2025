package com.comp2042.logic.bricks;

import com.comp2042.MatrixOperations;

import java.util.ArrayList;
import java.util.List;

final class IBrick implements Brick {

    private final List<int[][]> brickMatrix = new ArrayList<>();

    public IBrick() {
        int v = com.comp2042.BrickType.I.getValue();
        brickMatrix.add(new int[][] {
                { 0, 0, 0, 0 },
                { v, v, v, v },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        });
        brickMatrix.add(new int[][] {
                { 0, v, 0, 0 },
                { 0, v, 0, 0 },
                { 0, v, 0, 0 },
                { 0, v, 0, 0 }
        });
    }

    @Override
    public List<int[][]> getShapeMatrix() {
        return MatrixOperations.deepCopyList(brickMatrix);
    }

}
