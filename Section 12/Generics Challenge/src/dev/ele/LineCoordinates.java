package dev.ele;

public record LineCoordinates(Coordinates start, Coordinates middle, Coordinates end) {

    @Override
    public String toString() {
        return "[%s], [%s], [%s]".formatted(start(), middle(), end());
    }
};