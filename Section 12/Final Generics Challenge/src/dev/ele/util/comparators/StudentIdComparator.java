package dev.ele.util.comparators;

import java.util.Comparator;
import dev.ele.model.Student;

public class StudentIdComparator<T extends Student> implements Comparator<T> {

    public int compare(Student student1, Student student2) {
        return Integer.valueOf(student1.getId()).compareTo(Integer.valueOf(student2.getId()));
    }
}