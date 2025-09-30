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

        printOrderedField(employees, "lastName");
    }

    private static void printOrderedField(List<Employee> employees, String field) {
        class MyEmployee {

            private String fullName;
            private int yearsWorked;
            // private final int YEAR = Calendar.getInstance().get(Calendar.YEAR);
            private final int YEAR = LocalDate.now().getYear();
            private Employee instance;

            public MyEmployee(Employee employee) {
                instance = employee;
                fullName = String.join(" ", employee.firstName(), employee.lastName());
                yearsWorked = YEAR - employee.hireYear();
            }

            @Override
            public String toString() {
                return instance.toString() + "\nFull Name: " + fullName + "\nYears worked: " + yearsWorked;
            }
        }

        List<MyEmployee> employeesWrapped = new ArrayList<>();
        for (var e : employees) {
            employeesWrapped.add(new MyEmployee(e));
        }

        employeesWrapped.sort(new Comparator<MyEmployee>() {
            public int compare(MyEmployee a, MyEmployee b) {
                return switch (field.toUpperCase()) {
                    case "FIRSTNAME" -> a.instance.firstName().compareTo(b.instance.firstName());
                    case "LASTNAME" -> a.instance.lastName().compareTo(b.instance.lastName());
                    case "FULLNAME" -> a.fullName.compareTo(b.fullName);
                    case "HIREYEAR" ->
                        Integer.valueOf(a.instance.hireYear()).compareTo(Integer.valueOf(b.instance.hireYear()));
                    case "YEARS" -> Integer.valueOf(a.yearsWorked).compareTo(Integer.valueOf(b.yearsWorked));
                    default -> Integer.valueOf(a.yearsWorked).compareTo(Integer.valueOf(b.yearsWorked));
                };
            }
        }.reversed());

        for (var e : employeesWrapped) {
            System.out.println(e);
            System.out.println();
        }
    }

}