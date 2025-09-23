package dev.ele;

import java.util.ArrayList;
import java.util.List;

import dev.ele.model.LPAStudent;
import dev.ele.model.Student;
import dev.ele.util.QueryList;

public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());

        }
        // students.add(new LPAStudent());
        // printList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());

        }
        // printList(lpaStudents);
        printMoreLists(lpaStudents);

        // testList(new ArrayList<String>(List.of("Abel", "Barry", "Charlie")));
        // testList(new ArrayList<Integer>(List.of(1, 2, 3)));

        // QueryList<LPAStudent> queryList = new QueryList<>(lpaStudents);
        // var queryList = new QueryList<>(lpaStudents);

        // printMoreLists(matches);
        // for (int i = 0; i < 15; i++) {
        // System.out.println(queryList.getMatches("Name", lpaStudents.get(i %
        // lpaStudents.size()).getName()));
        // }

        var queryList = new ArrayList<>(lpaStudents);
        List<LPAStudent> matches = QueryList.getMatches("course", "java", queryList);
        printMoreLists(matches);

        // QueryList<Employee> employeeList = new QueryList<>();
    }

    public static void printMoreLists(List<? extends Student> students) {
        for (var s : students) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

    // public static void testList(List<String> list) {
    // for (var element : list) {
    // System.out.println("String: " + element.toUpperCase());
    // }
    // }

    // public static void testList(List<Integer> list) {
    // for (var element : list) {
    // System.out.println("String: " + element.floatValue());
    // }
    // }

    // public static <T extends Student> void printList(List<T> students) {
    // for (var s : students) {
    // System.out.println(s.getYearStarted() + ": " + s);
    // }
    // System.out.println();
    // }
}