package dev.ele.domain;

import java.util.Comparator;

public class StoreEmployee extends Employee {
    private String store;

    public StoreEmployee() {

    }

    public StoreEmployee(int id, String name, int year, String store) {
        super(id, name, year);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-15s%s".formatted(store, super.toString());
    }

    public class StoreComparator<T extends StoreEmployee> implements Comparator<T> {
        @Override
        public int compare(T s1, T s2) {
            StoreEmployee employeeS1 = (StoreEmployee) s1;
            StoreEmployee employeeS2 = (StoreEmployee) s2;
            int result = employeeS1.store.compareTo(employeeS2.store);
            if (result == 0) {
                return new Employee.EmployeeComparator<>(Employee.EmployeeComparator.SortType.YEAR).compare(employeeS1,
                        employeeS2);
            }
            return result;
        }
    }
}