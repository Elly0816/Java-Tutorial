package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] originalArray = new String[] { "First", "Second", "Third" };
        // String[] originalArray = new String[6];
        var originalList = Arrays.asList(originalArray);
        originalList.set(0, "One");
        // for (int i = 0; i < originalArray.length; i++) {
        // originalList.set(i, Integer.toString(i));
        // }
        System.out.println("List: " + originalList);
        System.out.println("Array: " + Arrays.toString(originalArray));

        originalList.sort(Comparator.reverseOrder());
        System.out.println("array sorted: " + Arrays.toString(originalArray));

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");

        System.out.println(newList);

        ArrayList<String> stringLists = new ArrayList<>(List.of("Jan", "Feb", "Mar"));
        String[] stringArray = stringLists.toArray(new String[0]);
        System.out.println(Arrays.toString(stringArray));
    }
}