package dev.ele;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import dev.ele.util.Lambda_Challenge;

public class Main {
    public static void main(String[] args) {

        // Consumer<String> printParts = new Consumer<String>() {
        // @Override
        // public void accept(String sentence) {
        // String[] parts = sentence.split(" ");
        // for (String part : parts) {
        // System.out.println(part);
        // }
        // }
        // };

        String item = "This is something to print";
        splitStringAndPrintOnNewLine(item, (s) -> System.out.println(s));

        String tester = "1234567890";

        // everySecondCharacter(item, (i) -> item.charAt(i));
        // String result = everySecondCharacter(item, (words) -> {
        // StringBuilder returnVal = new StringBuilder();
        // for (int i = 0; i < words.length(); i++) {
        // if (i % 2 == 0) {
        // returnVal.append(words.charAt(i));
        // }
        // }
        // return returnVal.toString();
        // });

        String result = everySecondCharacter(tester, (words) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < words.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(words.charAt(i));
                }
            }
            return returnVal.toString();
        });
        System.out.println(result);

        String supplierResult = usingSupplier(() -> "I love Java!");
        System.out.println(supplierResult);

        // Lambda Challenge

        Lambda_Challenge challenge = new Lambda_Challenge();

        Lambda_Challenge.printArray(challenge.getNames());
        challenge.toAllUppercase();
        Lambda_Challenge.printArray(challenge.getNames());
        challenge.randomMiddleInitialWithPeriod();
        Lambda_Challenge.printArray(challenge.getNames());
        challenge.addLastName();
        Lambda_Challenge.printArray(challenge.getNames());
        Lambda_Challenge.printOnNewLine(challenge.removeFirstNameEqualsLastName());
    }

    private static String usingSupplier(Supplier<String> supp) {
        return supp.get();
    }

    private static void splitStringAndPrintOnNewLine(String sentence, Consumer<String> consumer) {
        List<String> words = Arrays.asList(sentence.split(" "));
        words.forEach((word) -> consumer.accept(word));
        // for (String word : words) {
        // consumer.accept(word);
        // }
    }

    private static String everySecondCharacter(String sentence, Function<String, String> function) {
        return function.apply(sentence);
    }

    private static String everySecondCharacter(String sentence, UnaryOperator<String> function) {
        return function.apply(sentence);
    }

}