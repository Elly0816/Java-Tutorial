package dev.ele.domain;

import java.util.Comparator;

public class Employee {

    // Comparator for Employee and it's subclasses
    public static class EmployeeComparator<T extends Employee> implements Comparator<T> {

        // Enum for Employee fields
        public static enum SortType {
            NAME, YEAR, ID;
        }

        private SortType sortType;

        public EmployeeComparator() {
            this.sortType = SortType.NAME;
        }

        public EmployeeComparator(SortType sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(T a, T b) {
            Employee employeeA = (Employee) a;
            Employee employeeB = (Employee) b;
            return switch (sortType) {
                case NAME -> {
                    yield employeeA.name.compareTo(employeeB.name);
                }
                case YEAR -> {
                    yield Integer.valueOf(employeeA.yearStarted).compareTo(Integer.valueOf(employeeB.yearStarted));
                }
                case ID -> {
                    yield Integer.valueOf(employeeA.employeeId).compareTo(Integer.valueOf(employeeB.employeeId));
                }
                default -> {
                    yield Integer.valueOf(employeeA.employeeId).compareTo(Integer.valueOf(employeeB.employeeId));
                }
            };
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {

    }

    public Employee(int id, String name, int year) {
        employeeId = id;
        this.name = name;
        yearStarted = year;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }

}