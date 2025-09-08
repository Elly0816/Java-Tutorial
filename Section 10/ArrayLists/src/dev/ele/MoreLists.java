package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = { "Apples", "Bananas", "Milk", "Eggs" };
        List<String> list = List.of(items); // This is immutable
        System.out.println("This is the name of the class: " + list.getClass().getSimpleName());
        System.out.println(list);
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("Tomatoes");
        System.out.println(groceries);

        ArrayList<String> NextList = new ArrayList<>(
                List.of("Pickles", "Mustard", "Cheese"));

        System.out.println(NextList);
        groceries.addAll(NextList);
        // new ArrayList<String>(
        // List.of("Watermelons", "Potatoes", "Melon"))

        System.out.println(groceries);

        System.out.println("Third item = " + groceries.get(2));

        if (groceries.contains("Mustard")) {
            System.out.println("The array contains mustard");
        } else {
            System.out.println("The array does not contain mustard");
        }

        groceries.add(3, "Cheese");
        System.out.println("The index of cheese is = " + groceries.indexOf("Cheese"));
        System.out.println("The last index of cheese is = " + groceries.lastIndexOf("Cheese"));
        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        // while (groceries.contains("Cheese")) {
        // groceries.remove("Cheese");
        // }
        groceries.removeIf(g -> g.toLowerCase() == "cheese");
        System.out.println(groceries);
        groceries.removeAll(List.of("Milk", "Eggs", "Pickles"));
        System.out.println(groceries);
        groceries.retainAll(List.of("Apples", "Mustard"));
        System.out.println(groceries);
        groceries.clear();

        System.out.println("isEmpty = " + groceries.isEmpty());

        groceries.addAll(List.of("Apples", "Milk", "Mustard", "Cheese"));
        groceries.addAll(Arrays.asList("Eggs", "Pickles", "Mustard", "Ham"));
        System.out.println(groceries);
        // groceries.sort((a, b) -> a.compareTo(b));
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));
        groceryArray[1] = "New thing";
        System.out.println(Arrays.toString(groceryArray));
    }
}