package dev.ele.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Special {

    private static Random rand = new Random();
    private static List<UnaryOperator<String>> operations = new ArrayList<>(List.of(Special::removeSpaces,
            (s) -> Special.capitalize(s), Special::addRandomMiddleName, (s) -> Special.lastName(s)));

    public Special() {
    }

    public static String capitalize(String name) {
        return name.toUpperCase();
    }

    public static List<UnaryOperator<String>> getOperations() {
        return operations;
    }

    public static String addRandomMiddleName(String name) {
        char initial = (char) rand.nextInt(65, 91);

        return name + " " + initial + ".";
    }

    public static String lastName(String name) {
        return name + " " + new StringBuilder(name.split(" ")[0]).reverse().toString();
    }

    public static String removeSpaces(String name) {
        return name.strip();
    }
}