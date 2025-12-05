package com.comp2042.logic.bricks;

import com.comp2042.MatrixOperations;

import java.util.ArrayList;
import java.util.List;

final class JBrick implements Brick {

        private final List<int[][]> brickMatrix = new ArrayList<>();

        public JBrick() {
                int v = com.comp2042.BrickType.J.getValue();
                brickMatrix.add(new int[][] {
                                { 0, 0, 0, 0 },
                                { v, v, v, 0 },
                                { 0, 0, v, 0 },
                                { 0, 0, 0, 0 }
                });
                brickMatrix.add(new int[][] {
                                { 0, 0, 0, 0 },
                                { 0, v, v, 0 },
                                { 0, v, 0, 0 },
                                { 0, v, 0, 0 }
                });
                brickMatrix.add(new int[][] {
                                { 0, 0, 0, 0 },
                                { 0, v, 0, 0 },
                                { 0, v, v, v },
                                { 0, 0, 0, 0 }
                });
                brickMatrix.add(new int[][] {
                                { 0, 0, v, 0 },
                                { 0, 0, v, 0 },
                                { 0, v, v, 0 },
                                { 0, 0, 0, 0 }
                });
        }

        @Override
        public List<int[][]> getShapeMatrix() {
                return MatrixOperations.deepCopyList(brickMatrix);
        }
}
