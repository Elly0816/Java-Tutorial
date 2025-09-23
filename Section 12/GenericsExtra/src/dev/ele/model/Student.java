package dev.ele.model;

import java.util.Random;

import dev.ele.util.QueryItem;

public class Student implements QueryItem {
    private String name;
    private String course;
    private int yearStarted;
    protected static Random random = new Random();
    private static String[] firstNames = { "Anne", "Bill", "Cathy", "John", "Tim" };
    private static String[] courses = { "C++", "Java", "Python" };

    public Student() {
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2021, 2026);

    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
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
    public boolean matchFieldValue(String field, String value) {
        return switch (field.toUpperCase()) {
            case "NAME" -> this.name.equalsIgnoreCase(value);
            case "COURSE" -> this.course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> {
                int valueToReturn;
                try {
                    valueToReturn = Integer.valueOf(value);
                } catch (NumberFormatException e) {
                    valueToReturn = this.yearStarted == 0 ? 1 : 0;
                }
                yield this.yearStarted == valueToReturn;
            }
            default -> false;
        };
    }

}