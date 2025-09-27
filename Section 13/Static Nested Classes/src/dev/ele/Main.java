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
    }

    private static <T extends Employee> void printEmployees(List<T> employees) {
        for (T e : employees) {
            System.out.println(e);
        }
        System.out.println();
    }
}
