package dev.ele.utils;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserIO {
    private final Scanner sc = new Scanner(System.in);

    public void closeScanner() {
        sc.close();
    }

    public String getUserName() {
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
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                shouldContinue = true;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                shouldContinue = true;
            }
        }
        return name;
    }

    public boolean shouldRestart() {
        System.out.print("Do you want to play again? (Enter 'Y' or 'N') ");
        boolean shouldContinue = true;
        boolean shouldRestart = false;
        while (shouldContinue) {
            try {
                shouldContinue = false;
                String response = sc.nextLine().strip();
                if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
                    System.out.print("Invalid input\nEnter either Y or N: ");
                    shouldContinue = true;
                }
                if (response.equalsIgnoreCase("y")) {
                    shouldRestart = true;
                } else if (response.equalsIgnoreCase("n")) {
                    shouldRestart = false;
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                shouldContinue = true;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                shouldContinue = true;
            }
        }
        return shouldRestart;
    }

    public int getNumberOfOpponents() {
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

    public Options getUserOption() {
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