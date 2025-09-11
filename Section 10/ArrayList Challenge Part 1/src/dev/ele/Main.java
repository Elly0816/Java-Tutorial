package dev.ele;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isRunning = true;
        while (isRunning) {
            ShowOptions.showMenu();
            int option = GetOption.option(sc);
            switch (option) {
                case 0 -> {
                    isRunning = false;
                    System.out.println("Quitting...");
                }
                case 1 -> {
                    // Handle adding items to list
                    GroceryList.add(GetItems.getItemsFromUser(sc));
                    System.out.println("_".repeat(70));
                    GroceryList.displayItems();
                    System.out.println("_".repeat(70));
                }
                case 2 -> {
                    // Handle removing items from the list
                    /**
                     * Since the user can enter either an int or a String
                     * I need to be able to handle both
                     * 
                     */
                    GetItems.getDeleteItemsFromUser(sc);
                    System.out.println("_".repeat(70));
                    GroceryList.displayItems();
                    System.out.println("_".repeat(70));

                }
            }
        }

        sc.close();
    }
}