package dev.ele;

public record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name, String type) {
        this(name, type, 1);
    }

    public GroceryItem(String name) {
        this(name, "DAIRY");
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
};