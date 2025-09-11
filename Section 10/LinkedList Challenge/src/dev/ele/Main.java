package dev.ele;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<TownAndDistance> townsAndDistances = new LinkedList<>();// This holds an array of towns and their
                                                                           // distances from Sydney

        addPlace(townsAndDistances, new TownAndDistance("Adelaide", 1374));
        addPlace(townsAndDistances, new TownAndDistance("Sydney", 0));
        addPlace(townsAndDistances, new TownAndDistance("Alice Springs", 2771));
        addPlace(townsAndDistances, new TownAndDistance("Brisbane", 917));
        addPlace(townsAndDistances, new TownAndDistance("Darwin", 3972));
        addPlace(townsAndDistances, new TownAndDistance("Melbourne", 877));
        addPlace(townsAndDistances, new TownAndDistance("Perth", 3923));
        addPlace(townsAndDistances, new TownAndDistance("BRISBANE", 917));
        addPlace(townsAndDistances, new TownAndDistance("darwin", 3972));

        // System.out.println(townsAndDistances);
        townsAndDistances.sort(Comparator.comparingDouble(TownAndDistance::distance));
        ListIterator<TownAndDistance> iterator = townsAndDistances.listIterator();
        // while (iterator.hasNext()) {
        // var current = iterator.next();
        // System.out.println("Town: " + current.town() + ", Distance: " +
        // current.distance());
        // }

        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        TownAndDistance lastTown = null;
        while (isRunning) {
            String userChoice = GetInput.input(sc);
            System.out.println("_".repeat(40));
            switch (userChoice) {
                case "F" -> {
                    lastTown = handleForward(iterator, lastTown);
                }
                case "B" -> {
                    lastTown = handleBackward(iterator, lastTown);
                }
                case "L" -> handleListPlaces(townsAndDistances);
                case "M" -> handleMenu();
                case "Q" -> {
                    System.out.println("Quitting...");
                    isRunning = false;
                }
            }
        }
        sc.close();

    }

    /**
     * This adds a new town to a linked list of towns
     * This checks if there is a town with a matching name
     * This ensures there are no duplicate entries
     * 
     * @param list the linked list of towns
     * @param town the last seen town
     */
    private static void addPlace(LinkedList<TownAndDistance> list, TownAndDistance town) {
        for (TownAndDistance item : list) {
            if (item.town().equalsIgnoreCase(town.town())) {
                System.out.println(town.town() + " is already included!");
                return;
            }
        }
        list.add(town);
    }

    /**
     * This checks if the iterator is at the start of the list or at the end of the
     * list
     * 
     * @param iterator the town list iterator instance
     */
    private static void inEdgePosition(ListIterator<TownAndDistance> iterator) {
        if (!iterator.hasNext() && !iterator.hasPrevious()) {
            System.out.println("Single ");
        } else if (!iterator.hasPrevious()) {
            System.out.print("Start ");
        } else if (!iterator.hasNext()) {
            System.out.print("Final ");
        }
    }

    /**
     * 
     * @param iterator
     * @param town
     * @return the last town that was seen by the iterator using next() or
     *         previous()
     */
    private static TownAndDistance handleForward(ListIterator<TownAndDistance> iterator, TownAndDistance town) {
        TownAndDistance nextTown = null;
        if (iterator.hasNext()) {
            if (!iterator.next().equals(town)) {
                iterator.previous();
            }
        }
        if (iterator.hasNext()) {
            inEdgePosition(iterator);
            nextTown = iterator.next();
            inEdgePosition(iterator);
            System.out.println("Town: " + nextTown.town() + ", Distance from Sydney: " + nextTown.distance());
        } else {
            System.out.println("You're at the end of the list. There are no more elements after this");
        }
        System.out.println("_".repeat(40));
        return nextTown;
    };

    /**
     * 
     * @param iterator
     * @param town
     * @return the last town that was seen by the iterator using next() or
     *         previous()
     */
    private static TownAndDistance handleBackward(ListIterator<TownAndDistance> iterator, TownAndDistance town) {
        TownAndDistance previousTown = null;
        if (iterator.hasPrevious()) {
            if (!iterator.previous().equals(town)) {
                iterator.next();
            }
        }
        if (iterator.hasPrevious()) {
            inEdgePosition(iterator);
            previousTown = iterator.previous();
            inEdgePosition(iterator);
            System.out.println("Town: " + previousTown.town() + ", Distance from Sydney: " + previousTown.distance());
        } else {
            System.out.println("You're at the start of the list, there are no more elements before this");
        }
        System.out.println("_".repeat(40));
        return previousTown;
    };

    /**
     * This prints out the list of all the towns in the list
     * 
     * @param arr
     */
    private static void handleListPlaces(LinkedList<TownAndDistance> arr) {
        System.out.println("Here is a list of the town and their distance from Sydney: ");
        for (TownAndDistance item : arr) {
            // System.out.println("Town: " + item.town() + ", Distance from Sydney: " +
            // item.distance());
            System.out.println(item);
        }
        System.out.println("_".repeat(40));
    };

    /**
     * This shows the meu options
     */
    private static void handleMenu() {
        GetInput.showMenu();
        System.out.println("_".repeat(40));
    };

}