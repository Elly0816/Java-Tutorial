package dev.ele;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Perth");
        placesToVisit.add("Adelaide");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);
        addMoreElements(placesToVisit);
        // System.out.println(placesToVisit);
        // removeElements(placesToVisit);
        System.out.println(placesToVisit);
        // gettingElements(placesToVisit);
        // printItinerary3(placesToVisit);
        testIterator(placesToVisit);

    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin");
        list.addLast("Hobart");

        // Queue methods
        list.offer("Melbourne");
        list.offerLast("Toowoomba");
        list.offerFirst("Brisbane");

        // Stack methods
        list.push("Alice Springs");
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();// This removes the first element in the list
        System.out.println(s1 + " was removed");
        String s2 = list.removeFirst();// This removes the first element in the list
        System.out.println(s2 + " was removed");
        String s3 = list.removeLast();// This removes the last element in the list
        System.out.println(s3 + " was removed");

        // Queue/Dequeue poll methods
        String p1 = list.poll(); // removes first element
        System.out.println(p1 + " was removed");
        String p2 = list.pollFirst(); // removes first element
        System.out.println(p2 + " was removed");
        String p3 = list.pollLast(); // removes last element
        System.out.println(p3 + " was removed");

        list.push("Melbourne");
        list.push("Sydney");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop();// removes the first element
        System.out.println(p4 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println("Retrieved Element = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());

        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.lastIndexOf("Melbourne"));
        // Queue retieval method
        System.out.println("Element from element() = " + list.element());
        // Stack retrieval method
        System.out.println("Element form peek() =  " + list.peek());
        System.out.println("Element form peekFirst() =  " + list.peekFirst());
        System.out.println("Element form peekLast() =  " + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println("--> From: " + list.get(i) + " to " + list.get(i + 1));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list) {
            if (town.equals(previousTown)) {
                continue;
            }
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        // list.forEach((item) -> {System.out.println(item);});
        ListIterator<String> iterator = list.listIterator(1);
        String previousTown = list.getFirst();
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list) {
        var iterator = list.listIterator();
        while (iterator.hasNext()) {
            // System.out.println(iterator.next());
            if (iterator.next().equalsIgnoreCase("Brisbane")) {
                iterator.add("Lake Wivenhoe");
            }
        }

        while (iterator.hasPrevious()) {
            System.out.println("This is the current place " + iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.next());
    }

}