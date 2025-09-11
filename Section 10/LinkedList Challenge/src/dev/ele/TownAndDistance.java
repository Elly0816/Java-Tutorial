package dev.ele;

public record TownAndDistance(String town, double distance) {

    @Override
    public String toString() {
        return String.format("%s, (%.2f)", town, distance);
    }

};