package dev.ele;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

import dev.ele.exa.PlainOld;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));

        list.forEach(System.out::println);

        calculator(Integer::sum, 2, 5);
        calculator(Double::sum, 2.7, 5.2);

        PlainOld[] reference1 = usingNewRef(PlainOld::new, 7);
        System.out.println(reference1);

        stringConcat(String::concat, "Hello", " World");

        stringTransform(String::getBytes, "Someone is doing something great!");

        Function<String, String> f = String::toUpperCase;
        String result = f.apply("This is it");
        System.out.println(result);

        Function<String, Boolean> ifIsEmpty = String::isEmpty;
        boolean checkIsEmpty = ifIsEmpty.apply("");
        System.out.println(checkIsEmpty ? "it is empty" : "it is not empty");
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of the operation: " + result);
    }

    private static PlainOld[] usingNewRef(Supplier<PlainOld> supp, int count) {
        PlainOld[] items = new PlainOld[count];
        int i = 0;
        while (i < count) {
            items[i++] = new PlainOld();
        }
        return items;
    }

    private static void stringConcat(BinaryOperator<String> func, String var1, String var2) {
        String result = func.apply(var1, var2);
        System.out.println(result);
    }

    private static <T> void stringTransform(Function<String, T> f, String item) {
        T result = f.apply(item);
        System.out.println(result);
    }
}