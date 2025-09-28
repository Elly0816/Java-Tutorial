package dev.ele;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import dev.ele.domain.Employee;
import dev.ele.domain.StoreEmployee;

public class RunMethods {

    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(
                List.of(new StoreEmployee(1100, "Meg", 2017, "GAP"), new StoreEmployee(1101, "Joe", 2018, "Target"),
                        new StoreEmployee(1102, "Mary", 2016, "H&M"), new StoreEmployee(1103, "Jack", 2015, "CostCo"),
                        new StoreEmployee(1104, "Sam", 2014, "HyperCity")));

        sortIt(storeEmployees, new Employee.EmployeeComparator<StoreEmployee>());
        sortIt(storeEmployees, new StoreEmployee().new StoreComparator<>());
        sortIt(storeEmployees, new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee a, StoreEmployee b) {
                return a.getName().compareTo(b.getName());
            }
        });

    }

    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {
        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for (var e : list) {
            System.out.println(e);
        }

    }

}