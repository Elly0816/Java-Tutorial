package dev.ele;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetOption {

    public static int option(Scanner sc) {
        int userChoice;
        String errorMessage = "Enter a valid option!";
        while (true) {
            try {
                userChoice = sc.nextInt();
                if (userChoice < 0 || userChoice > 2) {
                    System.out.println(errorMessage);
                    // sc.nextLine();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                ShowOptions.showMenu();
                sc.nextLine();
            }
        }
        sc.nextLine();
        return userChoice;
    }
}