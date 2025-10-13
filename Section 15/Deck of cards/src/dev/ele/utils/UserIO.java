package dev.ele.utils;

import java.util.Scanner;

public class UserIO {
    private static Scanner sc;

    public static void startScanner() {
        sc = new Scanner(System.in);
    }

    public static void closeScanner() {
        sc.close();
    }

    public static String getUserName() {
        String name = "";
        boolean shouldContinue = true;
        while (shouldContinue) {
            try {
                name = sc.nextLine();
                shouldContinue = false;
                if (name.isBlank()) {
                    System.out.print("You can't leave name empty! ");
                    shouldContinue = true;
                    continue;
                }
                for (int i = 0; i < name.length(); i++) {
                    if (!Character.isAlphabetic(name.charAt(i)) && name.charAt(i) != ' ') {
                        System.out.print("Invalid character in name ");
                        shouldContinue = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                shouldContinue = true;
            }
        }
        return name;
    }

    public static int getNumberOfOpponents() {
        int numberOfOpponents = 0;
        boolean shouldContinue = true;
        while (shouldContinue) {
            try {
                numberOfOpponents = Integer.parseInt(sc.nextLine());
                if (numberOfOpponents > 6) {
                    System.out.print("The maximum number of players you can enter is 6! ");
                    continue;
                } else {
                    shouldContinue = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter a valid number less than 7 ");
                continue;
            }
        }
        return numberOfOpponents;
    }

    public static Options getUserOption() {
        Options userOption = null;
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.print("Enter 'H' or 'h' to hit and 'S' or 's' to stand: ");
            String option = sc.nextLine().strip();
            shouldContinue = false;
            if (option.length() > 1 || (!option.equalsIgnoreCase("H") && !option.equalsIgnoreCase("S"))) {
                shouldContinue = true;
                System.out.println("Enter a valid input! ");
            }
            if (option.equalsIgnoreCase("H")) {
                userOption = Options.HIT;
            } else {
                userOption = Options.STAND;
            }
        }
        return userOption;
    }
}