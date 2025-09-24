package dev.ele.util.comparators;

import java.util.Comparator;
import dev.ele.model.Student;

public class StudentCourseComparator<T extends Student> implements Comparator<T> {

    public int compare(T student1, T student2) {
        return student1.getCourse().compareTo(student2.getCourse());
    }
}