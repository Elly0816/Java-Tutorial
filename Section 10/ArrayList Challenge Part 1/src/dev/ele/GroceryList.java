package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GroceryList {

    private static ArrayList<String> groceryItems = new ArrayList<>();

    public static void add(String... items) {
        for (String item : items) {
            boolean isValid = true;
            if (groceryItems.contains(item)) {
                isValid = false;
                System.out.printf("%s is already in the list! It's at index %d%n", item,
                        groceryItems.indexOf(item));
            }
            if (isValid) {
                groceryItems.add(item.toUpperCase());
            }
        }
    }

    public static void displayItems() {
        System.out.println("These are the items in your grocery list: ");
        groceryItems.sort(Comparator.naturalOrder());
        System.out.println(groceryItems);
    }

    public static int numberOfItems() {
        return groceryItems.size();
    }

    public static void remove(int index) {
        groceryItems.remove(index);
    }

    public static void remove(String... items) {
        groceryItems.removeAll(Arrays.asList(items));
    }

}