package dev.ele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import dev.ele.model.Contact;
import dev.ele.model.ContactData;

public class TreeSetMain {

    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        System.out.println(emails);
        System.out.println(phones);

        // Constructor with comparator argument
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        // NavigableSet<String> justNames = phones.stream().map(Contact::getName)
        // .collect(Collectors.toCollection(TreeSet::new));

        // No args constructor
        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach((c) -> justNames.add(c.getName()));
        System.out.println(justNames);

        // Constructor with collection argument
        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        System.out.println(fullSet);

        // Using a set's comparator for sorting other collections
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("-----------------------------");
        fullList.forEach(System.out::println);

        // Getting the min and max values from the TreeSet
        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());
        System.out.println("The min is: " + min);
        System.out.println("The max is: " + max);

        // Getting the first and last items on the sorted set
        Contact first = fullSet.first();
        Contact last = fullSet.last();
        System.out.println("The first contact is: " + first);
        System.out.println("The last contact is: " + last);

        // Poll first and Poll last that removes and returns the first and last element
        // of the set
        NavigableSet<Contact> fullSetCopy = new TreeSet<>(fullSet);
        System.out.println("The set at first has " + fullSet.size() + " elements.");
        Contact pollFirst = fullSetCopy.pollFirst();
        System.out.println("The first element in the set is " + pollFirst);
        Contact pollLast = fullSetCopy.pollLast();
        System.out.println("The last element in the set is " + pollLast);
        System.out.println("The set now has " + fullSetCopy.size() + " elements.");

        // Identifying the closest match to a value
        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");
        for (Contact c : List.of(daffy, daisy, last, snoopy)) {
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }

        for (Contact c : List.of(daffy, daisy, first, snoopy)) {
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }

        // Descending set
        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("--------------------------------");

        Contact lastContact = descendingSet.pollLast();

        System.out.println("The contact removed is: " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("The original set: ");
        fullSet.forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        // Getting a subset view of a set ending at e with headSet(e) (elements are
        // strictly
        // less than e) or starting at e with tailSet(e) (elements are greater than or
        // equal to
        // e)
        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion);
        headSet.forEach(System.out::println);
        System.out.println("-----------------------------------");
        var tailSet = fullSet.tailSet(marion);
        tailSet.forEach(System.out::println);

        System.out.println("-----------------------------------");
        Contact linus = new Contact("Linus Van Pelt");
        var subset = fullSet.subSet(linus, marion);
        subset.forEach(System.out::println);

    }
}