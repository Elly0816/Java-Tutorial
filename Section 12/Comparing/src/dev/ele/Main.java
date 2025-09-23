package dev.ele;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = { 1, 35, 76, 2, 56, 2, 62, 62, 7, 39, 5 };
        for (Integer o : others) {
            int compare = o.compareTo(five);
            if (compare > 0) {
                System.out.println(o + " is greater than " + five + " and the result of the comparison is: " + compare);
            } else if (compare < 0) {
                System.out.println(o + " is less than " + five + " and the result of the comparison is: " + compare);
            } else {
                System.out.println(o + " is equal to " + five + " and the result of the comparison is: " + compare);
            }
            five = o;
        }

        String banana = "Banana";
        String[] fruit = { "Peach", "Pineapple", "Orange", "BANANA", "Grape", "Apple", "Cherry", "Apricot", "Almond" };
        for (String f : fruit) {
            int compare = f.compareTo(banana);
            System.out.printf("%s %s %s and the result is %s%n", banana,
                    compare > 0 ? "is greater than" : compare < 0 ? "is less than" : "is equal to", f, compare);
        }
        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        Student tim = new Student("Tim");
        Student mark = new Student("Mark");
        Student james = new Student("James");
        Student ryan = new Student("Ryan");
        Student anne = new Student("Anne");
        Student zach = new Student("Zach");
        Student eleazar = new Student("Eleazar");
        // Student eleazar2 = new Student("Eleazar");
        Student[] students = { tim, mark, james, ryan, anne, zach, eleazar,
                // eleazar2
        };
        // Arrays.sort(students);
        Arrays.sort(students, new StudentGPAComparator().reversed());
        System.out.println(Arrays.toString(students));

    }

}