package dev.ele.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import dev.ele.model.Student;

public class QueryList<T extends Student & QueryItem> {

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public static <T extends QueryItem> List<T> getMatches(String field, String value, List<T> items) {
        List<T> matches = new ArrayList<>();
        for (T i : items) {
            if (i.matchFieldValue(field, value)) {
                matches.add(i);
            }
        }
        return Collections.unmodifiableList(matches);
    }

    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (T i : items) {
            if (i.matchFieldValue(field, value)) {
                matches.add(i);
            }
        }
        return Collections.unmodifiableList(matches);
    }

}