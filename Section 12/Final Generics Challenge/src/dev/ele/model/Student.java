package dev.ele.model;

import java.util.Random;

import dev.ele.util.Fields;
import dev.ele.util.QueryItem;

public class Student implements QueryItem, Comparable<Student> {
    private String name;
    private String course;
    private int yearStarted;
    private static int COUNT = 1_000;
    private int id;
    protected static Random random = new Random();
    private static String[] firstNames = { "Anne", "Bill", "Cathy", "John", "Tim" };
    private static String[] courses = { "C++", "Java", "Python" };

    public Student() {
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2021, 2026);
        id = COUNT++;
    }

    @Override
    public int compareTo(Student student) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(student.getId()));
    }

    @Override
    public String toString() {
        return "%-5d %-15s %-15s %d".formatted(id, name, course, yearStarted);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the yearStarted
     */
    public int getYearStarted() {
        return yearStarted;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    @Override
    public boolean matchFieldValue(Fields field, String value) {
        return switch (field) {
            case NAME -> this.name.equalsIgnoreCase(value);
            case COURSE -> this.course.equalsIgnoreCase(value);
            case YEAR -> {
                int valueToReturn;
                try {
                    valueToReturn = Integer.valueOf(value);
                } catch (NumberFormatException e) {
                    yield false;
                }
                yield this.yearStarted == valueToReturn;
            }
            default -> false;
        };
    }

}