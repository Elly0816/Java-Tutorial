package dev.ele;

public record Affiliation(String type, String name, String countryCode) {

    @Override
    public String toString() {
        return name + "(" + type + " in " + countryCode + ")";
    }
}