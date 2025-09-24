package dev.ele.util.comparators;

import java.util.Comparator;

import dev.ele.model.LPAStudent;
import dev.ele.model.Student;

public class StudentPercentCompleteComparator<T extends Student> implements Comparator<T> {

    public int compare(T student1, T student2) {
        return (student1 instanceof LPAStudent s1 && student2 instanceof LPAStudent s2)
                ? Double.valueOf(s1.getPercentComplete()).compareTo(Double.valueOf(s2.getPercentComplete()))
                : 0;
    }
}