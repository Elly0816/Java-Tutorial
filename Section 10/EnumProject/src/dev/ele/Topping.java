package dev.ele;

public enum Topping {
    MUSTARD, PICKLES, BACON, CHEDDAR, TOMATO;

    public double getPrice() {
        return switch (this) {
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            case PICKLES -> 0.75;
            case TOMATO -> 0.5;
            case MUSTARD -> 0.25;
            default -> 0.0;

        };
    }

}