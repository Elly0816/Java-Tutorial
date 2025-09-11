package dev.ele;

import java.util.Scanner;

public class GetInput {

    private static String availableActions = """
            Available actions (select word or letter):
            (F)orward
            (B)ackward
            (L)ist Places
            (M)enu
            (Q)uit
            """;

    public static String input(Scanner sc) {
        showMenu();

        while (true) {
            String userChoice = sc.nextLine().trim().toLowerCase();
            if (userChoice.isEmpty()) {
                showMenu();
                continue;
            }
            if (userChoice.equals("forward") || userChoice.charAt(0) == 'f') {
                return "F";
            } else if (userChoice.equals("backward") || userChoice.charAt(0) == 'b') {
                return "B";
            } else if (userChoice.equals("list places") || userChoice.charAt(0) == 'l'
                    || userChoice.contains("list")) {
                return "L";
            } else if (userChoice.equals("menu") || userChoice.charAt(0) == 'm') {
                return "M";
            } else if (userChoice.equals("quit") || userChoice.charAt(0) == 'q') {
                return "Q";
            } else {
                System.out.println("Invalid Option! The available options are: ");
                showMenu();
            }

        }
    }

    public static void showMenu() {
        System.out.println(availableActions);
    }
}