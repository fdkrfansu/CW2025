package com.comp2042;

import java.util.Arrays;

public enum BrickType {
    NONE(0),
    I(1),
    J(2),
    L(3),
    O(4),
    S(5),
    T(6),
    Z(7);

    private final int value;

    BrickType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BrickType fromValue(int value) {
        return Arrays.stream(BrickType.values())
                .filter(type -> type.value == value)
                .findFirst()
                .orElse(NONE);
    }
}
