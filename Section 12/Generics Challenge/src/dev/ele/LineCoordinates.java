package dev.ele;

import java.util.Arrays;

public record LineCoordinates(Coordinates... coordinates) {

    @Override
    public String toString() {
        return Arrays.toString(coordinates);
    }
};