package dev.ele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

        String[] names = { "Jackson", "Martha", "James", "Elizabeth", "Daniel", "Frank", "George", "Henry", "Matthew",
                "Naomi", "Lisa", "Charles", "Hansen", "Ashley", "Alexander", "Jerome", "Eliezer" };

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String employeeFirstName = names[rand.nextInt(names.length)];
            String employeeLastName = names[rand.nextInt(names.length)];
            int year = rand.nextInt(2010, 2026);
            employees.add(new Employee(employeeFirstName, employeeLastName, year));
        }

        wrapperMethod(employees);
    }

    private static void wrapperMethod(List<Employee> employees) {
        class EmployeeWrapper {

            private String fullName;
            private int yearsWorked;
            // private final int YEAR = Calendar.getInstance().get(Calendar.YEAR);
            private final int YEAR = LocalDate.now().getYear();
            private Employee instance;

            public EmployeeWrapper(Employee employee) {
                instance = employee;
                fullName = employee.firstName() + " " + employee.lastName();
                yearsWorked = YEAR - employee.hireYear();
            }

            @Override
            public String toString() {
                return instance.toString() + "\nFull Name: " + fullName + "\nYears worked: " + yearsWorked;
            }
        }

        List<EmployeeWrapper> employeesWrapped = new ArrayList<>();
        for (var e : employees) {
            employeesWrapped.add(new EmployeeWrapper(e));
        }

        employeesWrapped.sort(new Comparator<EmployeeWrapper>() {
            public int compare(EmployeeWrapper a, EmployeeWrapper b) {
                // return a.fullName.compareTo(b.fullName);
                return Integer.valueOf(a.yearsWorked).compareTo(Integer.valueOf(b.yearsWorked));
            }
        }.reversed());

        for (var e : employeesWrapped) {
            System.out.println(e);
            System.out.println();
        }
    }

}