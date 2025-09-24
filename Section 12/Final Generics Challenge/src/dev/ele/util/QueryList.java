package dev.ele.util;

import java.util.ArrayList;
import java.util.List;

import dev.ele.model.LPAStudent;
import dev.ele.model.Student;

public class QueryList<T extends Student & QueryItem> extends ArrayList<T> {

    public QueryList() {
        super();
    }

    public QueryList(List<T> items) {
        super(items);
    }

    public static <S extends Student> QueryList<S> getMatches(Fields field, String value, QueryList<S> items) {
        QueryList<S> matches = new QueryList<>();
        for (S i : items) {
            if (i.matchFieldValue(field, value)) {
                matches.add(i);
            }
        }
        return matches;
    }

    public QueryList<T> getMatches(Fields field, String value) {
        QueryList<T> matches = new QueryList<>();
        for (T i : this) {
            if (i.matchFieldValue(field, value)) {
                matches.add(i);
            }
        }
        return matches;
    }

    public QueryList<T> filter(Fields field, String value, Comparison comparison) {
        QueryList<T> matches = new QueryList<>();
        for (T i : this) {
            switch (field) {
                case NAME -> {
                    if (compare(i.getName(), value, comparison)) {
                        matches.add(i);
                    }
                }
                case COURSE -> {
                    if (compare(i.getCourse(), value, comparison)) {
                        matches.add(i);
                    }
                }
                case YEAR -> {
                    if (compare(i.getYearStarted(), convertToInt(value), comparison)) {
                        matches.add(i);
                    }
                }
                case ID -> {
                    if (compare(i.getId(), convertToInt(value), comparison)) {
                        matches.add(i);
                    }
                }
                case COMPLETION_PERCENTAGE -> {
                    if (i instanceof LPAStudent l) {
                        if (compare(l.getPercentComplete(), convertToDouble(value), comparison)) {
                            matches.add(i);
                        }
                    }
                }
            }

        }
        return matches;
    }

    private Integer convertToInt(String val) {
        Integer tempVal;
        try {
            tempVal = Integer.valueOf(val);
        } catch (NumberFormatException e) {
            tempVal = 0;
        }
        return tempVal;
    }

    private Double convertToDouble(String val) {
        Double tempVal;
        try {
            tempVal = Double.valueOf(val);
        } catch (NumberFormatException e) {
            tempVal = 0.0;
        }
        return tempVal;
    }

    private <S extends Comparable<S>> boolean compare(S v1, S v2, Comparison c) {
        return switch (c) {
            case GREATER_THAN -> v1.compareTo(v2) > 0;
            case LESS_THAN -> v1.compareTo(v2) < 0;
            case EQUALS -> v1.compareTo(v2) == 0;
            case GREATER_THAN_OR_EQUALS -> v1.compareTo(v2) >= 0;
            case LESS_THAN_OR_EQUALS -> v1.compareTo(v2) <= 0;
            default -> false;
        };
    }

}