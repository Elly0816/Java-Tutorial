package dev.ele.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lambda_Challenge {
    private List<String> firstNames = new ArrayList<>();
    private Random rand = new Random();

    public Lambda_Challenge() {
        firstNames.addAll(List.of("bob", "ANNA", "Semple", "davID", "JaCkSoN", "daNiEL", "auGUST", "AleXANder"));
    }

    // Using Array.setAll or List.replaceAll

    public void toAllUppercase() {
        firstNames.replaceAll((name) -> name.toUpperCase());
    }

    public void randomMiddleInitialWithPeriod() {
        // firstNames.replaceAll(name -> name.join(" ", randomLetter+"."));
        firstNames.replaceAll(name -> {
            char randomLetter = (char) rand.nextInt(65, 91);
            return String.join(" ", name, randomLetter + ".");
        });
    }

    public void addLastName() {
        firstNames.replaceAll((name) -> {
            String firstNameString = name.split(" ")[0];
            StringBuilder lastName = new StringBuilder(firstNameString).reverse();
            // int length = firstNameString.length();
            // for (int i = length - 1; i >= 0; i--) {
            // lastName.append(firstNameString.charAt(i));
            // }
            return name + " " + lastName.toString();
        });
    }

    public List<String> getNames() {
        return firstNames;
    }

    public List<String> removeFirstNameEqualsLastName() {
        List<String> nonDuplicates = new ArrayList<>(firstNames);
        nonDuplicates.removeIf((fullName) -> {
            String firstName = fullName.split(" ")[0];
            String lastName = fullName.split(" ")[2];
            return firstName.equalsIgnoreCase(lastName);
        });
        return nonDuplicates;
    }

    public static <T> void printArray(List<T> items) {
        System.out.println(items);
    }

    public static <T> void printOnNewLine(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
}