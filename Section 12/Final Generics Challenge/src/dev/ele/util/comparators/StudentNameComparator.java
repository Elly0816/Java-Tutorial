package dev.ele.util.comparators;

import java.util.Comparator;

import dev.ele.model.Student;

public class StudentNameComparator<T extends Student> implements Comparator<T> {

    public int compare(T s1, T s2) {
        return s1.getName().compareTo(s2.getName());
    }
}