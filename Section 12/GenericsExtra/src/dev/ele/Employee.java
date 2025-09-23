package dev.ele;

import dev.ele.util.QueryItem;

public record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String field, String value) {
        return switch (field.toUpperCase()) {
            case "NAME" -> this.name.equalsIgnoreCase(value);
            default -> false;
        };
    }
};