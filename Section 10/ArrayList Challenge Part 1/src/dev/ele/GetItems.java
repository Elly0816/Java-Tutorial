package dev.ele;

import java.util.Scanner;

public class GetItems {
    private static String[] items;

    public static String[] getItemsFromUser(Scanner sc) {
        System.out.println("Enter your items below. Remember to seperate by commas!\nPress the enter key when done");
        items = sc.nextLine().toUpperCase().trim().replace(" ", "").split(",");
        return items;
    }

    public static void getDeleteItemsFromUser(Scanner sc) {
        boolean isValid = true;
        if (GroceryList.numberOfItems() < 1) {
            System.out.println("Your grocery list is empty, nothing to delete");
            return;
        }
        System.out.println("You can either enter a comma delimited list of items, or an index");
        while (isValid) {
            String item = sc.nextLine();
            try {
                int index = Integer.parseInt(item);
                if (index < 0 || index > GroceryList.numberOfItems() - 1) {
                    System.out.println("Invalid Index! ");
                } else {
                    GroceryList.remove(index);
                    isValid = false;
                }

            } catch (NumberFormatException e) {
                String[] items = item.toUpperCase().trim().replace(" ", "").split(",");
                GroceryList.remove(items);
                isValid = false;

            }
        }
    }
}