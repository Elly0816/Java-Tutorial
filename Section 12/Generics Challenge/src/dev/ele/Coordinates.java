package dev.ele;

public record Coordinates(double latitude, double longitude) {

    @Override
    public String toString() {
        return "[%.4f, %.4f]".formatted(latitude(), longitude());
    }
}