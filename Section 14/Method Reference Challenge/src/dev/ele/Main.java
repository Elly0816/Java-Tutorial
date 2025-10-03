package dev.ele;

import java.util.ArrayList;
import java.util.List;

import dev.ele.util.Special;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                List.of("     Joe ", "      james ", " aleXandER        ", "            JuLiUs   ", "       AllEN     ",
                        "  JeRemiaH     ", "       CaleB         ", "      EmManUel           "));

        System.out.println("Names");
        printOnNewLines(names);

        operateNames(names);

        System.out.println("-".repeat(35));

        System.out.println("Transformed names");
        printOnNewLines(names);
    }

    private static String applyOperators(String name) {
        String newName = name;
        for (var o : Special.getOperations()) {
            newName = o.apply(newName);
        }
        return newName;
    }

    private static void operateNames(List<String> names) {
        names.replaceAll(Main::applyOperators);
    }

    private static void printOnNewLines(List<String> names) {
        for (var n : names) {
            System.out.println(n);
        }
    }
}