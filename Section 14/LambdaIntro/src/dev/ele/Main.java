package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(new Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"), new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"), new Person("Charlie", "Brown")));

        // Using anonymous class
        // var comparatorLastName = new Comparator<Person>() {
        // @Override
        // public int compare(Person p1, Person p2) {
        // return p1.lastName().compareTo(p2.lastName());
        // }
        // };

        people.sort((p1, p2) -> p1.lastName().compareTo(p2.lastName()));
        System.out.println(people);

        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>() {
            @Override
            public int secondLevel(Person p1, Person p2) {
                return p1.firstName().compareTo(p2.firstName());
            }

            @Override
            public int compare(Person p1, Person p2) {
                int result = p1.lastName().compareTo(p2.lastName());
                return (result == 0 ? secondLevel(p1, p2) : result);
            }
        };

        people.sort(comparatorMixed);
    }

    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
}