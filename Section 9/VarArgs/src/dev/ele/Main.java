package dev.ele;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello World again");
        // System.out.println(Arrays.toString(args));

        String[] splitString = "Hello World, this is the text that has been split".split(" ");
        printText(splitString);
        System.out.println("_".repeat(20));

        printText("Something", "Interesting", "is", "going", "on", "make", "it", "make", "sense");

        String text = String.join(", ", "Someone", "is", "doing", "something", "fishy", "and", "it", "blows", "my",
                "mind");

        printText(text);

        String[] stringArr = { "This", "is", "a", "string", "array", "and", "it", "is", "weird" };

        printText(stringArr);

        String[] text2 = String.join(", ", new String[] { "a", "b", "c" }).split(", ");

        System.out.println("_".repeat(30));
        printText(text2);
    }

    private static void printText(String... varargs) {
        System.out.println(varargs.length);
        for (String item : varargs) {
            System.out.println(item);
        }
    }
}