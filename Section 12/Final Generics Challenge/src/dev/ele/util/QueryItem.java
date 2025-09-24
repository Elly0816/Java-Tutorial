package dev.ele.util;

public interface QueryItem {
    public boolean matchFieldValue(Fields fieldName, String value);
}