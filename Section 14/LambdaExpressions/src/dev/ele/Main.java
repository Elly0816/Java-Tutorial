package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        for (String l : list) {
            System.out.println(l);
        }

        System.out.println("----------");

        list.forEach(s -> System.out.println(s));

        System.out.println("----------");
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + (char) (first - 32));
        });

        // int result = calculator((a, b) -> a + b, 5, 2);
        int result = calculator((a, b) -> a + b, 5, 2);
        double result2 = calculator((a, b) -> a / b, 5.0, 2.0);
        String result3 = calculator((a, b) -> a + " " + b, "Hello", "world");

        var items = sorter(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(items);

        var coords = Arrays.asList(
                new double[] { 47.2160, -95.2348 },
                new double[] { 29.1566, -89.2456 },
                new double[] { 35.1556, -90.0659 });

        // Consumer functional interface
        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        // BiConsumer<Double, Double> p1 = (lat, lon) -> System.out.printf("[lat: %.3f,
        // lon: %.3f]%n", lat, lon);
        // var firstPoint = coords.get(0);
        // processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("------------------------------");
        coords.forEach(
                s -> processPoint(s[0], s[1], (lat, lon) -> System.out.printf("[lat: %.3f, lon: %.3f]%n", lat, lon)));

        // System.out.println(list);
        // list.removeIf(s -> s.equalsIgnoreCase("Charlie"));
        // System.out.println(list);

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));
        System.out.println("---------------");
        System.out.println(list);
        list.removeIf(s -> s.startsWith("ea"));
        System.out.println(list);

        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("---------------");
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        // Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
        // + switch (i) {
        // case 0 -> "one";
        // case 1 -> "two";
        // case 2 -> "three";
        // case 3 -> "four";
        // default -> "";
        // });
        // System.out.println(Arrays.toString(emptyStrings));

        Random rand = new Random();
        String[] namesList = { "Bob", "Sam", "Joe", "Isaac", "Randy", "Jake", "Finn" };
        System.out.println(Arrays.toString(namesList));
        String[] randomValues = randomlySelectedValues(35, namesList,
                () -> rand.nextInt(namesList.length));
        System.out.println(Arrays.toString(randomValues));
    }

    public static <T> T calculator(BinaryOperator<T> function, T v1, T v2) {
        // T result = function.operate(v1, v2);
        T result = function.apply(v1, v2);
        System.out.println("Result of operation is: " + result);
        return result;
    }

    public static <T extends Comparable<T>> List<T> sorter(List<T> supp) {
        supp.sort(((a, b) -> b.compareTo(a)));
        Supplier<List<T>> supp2 = () -> supp;
        return supp2.get();
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }

    // public static <T> T calculator(Operation<T> function, T v1, T v2) {
    // T result = function.operate(v1, v2);
    // System.out.println("Result of operation is: " + result);
    // return result;
    // }
}