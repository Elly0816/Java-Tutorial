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
        printNewLine(names);

        operateNames(names);

        System.out.println("-".repeat(35));

        System.out.println("Transformed names");
        printNewLine(names);
    }

    private static String applyOperators(String name) {
        String newName = name;
        for (var o : Special.getOperations()) {
            newName = o.apply(newName);
        }
        return newName;
    }

    private static void operateNames(List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            names.set(i, names.get(i).transform(Main::applyOperators));
        }
    }

    private static void printNewLine(List<String> names) {
        for (var n : names) {
            System.out.println(n);
        }
    }
}