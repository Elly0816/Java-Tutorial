package dev.ele.util.comparators;

import java.util.Comparator;
import dev.ele.model.Student;

public class StudentYearComparator<T extends Student> implements Comparator<T> {

    public int compare(T student1, T student2) {
        return Integer.valueOf(student1.getYearStarted()).compareTo(Integer.valueOf(student2.getYearStarted()));
    }
}