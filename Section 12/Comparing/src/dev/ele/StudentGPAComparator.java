package dev.ele;

import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return (Double.valueOf(s1.gpa) + s1.getName()).compareTo((Double.valueOf(s2.gpa) + s1.getName()));
    }
}