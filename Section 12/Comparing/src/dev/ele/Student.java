package dev.ele;

import java.util.Random;

public class Student implements Comparable<Student> {
    private String name;
    private int id;
    protected double gpa;
    private static int LAST_ID = 1000;
    private static Random random = new Random();

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student student) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(student.id));
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }
}