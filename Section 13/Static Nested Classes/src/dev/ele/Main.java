package dev.ele;

import java.util.ArrayList;
import java.util.List;

import dev.ele.domain.Employee;
import dev.ele.domain.StoreEmployee;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(
                List.of(new Employee(10001, "Ralph", 2015), new Employee(10002, "Jerry", 2014),
                        new Employee(10003, "James", 2017), new Employee(10004, "Eleazar", 2012),
                        new Employee(10005, "Caroline", 2018), new Employee(10006, "Jeffrey", 2020)));

        employees.sort(new Employee.EmployeeComparator<>(Employee.EmployeeComparator.SortType.ID));

        printEmployees(employees);

        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(
                List.of(new StoreEmployee(1100, "Meg", 2017, "GAP"), new StoreEmployee(1101, "Joe", 2018, "Target"),
                        new StoreEmployee(1102, "Mary", 2016, "H&M"), new StoreEmployee(1103, "Jack", 2015, "CostCo"),
                        new StoreEmployee(1104, "Sam", 2014, "HyperCity")));

        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);
        printEmployees(storeEmployees);

        System.out.println("With Pig Latin Names");
        addPigLatinName(storeEmployees);

    }

    private static <T extends Employee> void printEmployees(List<T> employees) {
        for (T e : employees) {
            System.out.println(e);
        }
        System.out.println();
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {
        String lastName = "Piggy";
        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {
            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            };

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());
        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = (char) (name.charAt(1) - 32) + name.substring(2) + (char) (name.charAt(0) + 32) + "ay"
            // +
            // " " + lastName
            ;
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null);
        for (var decoratedEmployee : newList) {
            System.out.println(decoratedEmployee.originalInstance.getName() + " " + decoratedEmployee.pigLatinName);
            // System.out.println(decoratedEmployee);
        }

    }
}
