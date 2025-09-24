package dev.ele;

import java.util.Comparator;
import java.util.List;

import dev.ele.model.LPAStudent;
import dev.ele.model.Student;
import dev.ele.util.Comparison;
import dev.ele.util.Fields;
import dev.ele.util.QueryList;
import dev.ele.util.comparators.StudentCourseComparator;
import dev.ele.util.comparators.StudentIdComparator;
import dev.ele.util.comparators.StudentNameComparator;
import dev.ele.util.comparators.StudentPercentCompleteComparator;
import dev.ele.util.comparators.StudentYearComparator;

public class Main {
    public static void main(String[] args) {

        QueryList<LPAStudent> students = new QueryList<>();
        int i = 0;
        while (i < 25) {
            LPAStudent s1 = new LPAStudent();
            students.add(s1);
            i++;
        }
        students.sort(compareBy(Fields.COMPLETION_PERCENTAGE, true));
        printListItems(students);
        // students.sort(Comparator.naturalOrder());
        // printListItems(students);
        System.out.println("MATCHES");
        var matches = students
                .getMatches(Fields.COURSE, "C++")
                .filter(Fields.COMPLETION_PERCENTAGE, "50",
                        Comparison.GREATER_THAN);
        matches.sort(Comparator.naturalOrder());
        printListItems(matches);

    }

    private static void printListItems(List<?> items) {
        for (var i : items) {
            System.out.println(i);
        }
        System.err.println();
    }

    private static <T extends Student> Comparator<T> compareBy(Fields fieldName, boolean reversed) {
        var comparator = switch (fieldName) {
            case ID -> new StudentIdComparator<T>();
            case COURSE -> new StudentCourseComparator<T>();
            case YEAR -> new StudentYearComparator<T>();
            case COMPLETION_PERCENTAGE -> new StudentPercentCompleteComparator<T>();
            case NAME -> new StudentNameComparator<T>();
            default -> new StudentIdComparator<T>();
        };
        return reversed ? comparator.reversed() : comparator;
    }
}