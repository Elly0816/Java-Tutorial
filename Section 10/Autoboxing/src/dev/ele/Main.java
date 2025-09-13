package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(15); // This is the preferred method, but it's unnecessary
        // Integer deprecatedBoxing = new Integer(15); // This is not the right way to
        // box primitives in their wrapper
        // classes
        int unboxedInt = boxedInt.intValue(); // This is also unecessary

        // Automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
        // System.out.println(autoUnboxed);
        Double resultBoxes = getDoublePrimitive();
        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray.getClass().getName());

        Character[] characterArray = { 'A', 'B', 'C', 'D' };
        System.out.println(Arrays.toString(characterArray));
        System.out.println(characterArray.getClass().getName());
        var ourList = List.of(1, 2, 3, 4, 5);
        System.out.println(ourList);
    }

    private static ArrayList<Integer> getList(Integer... varargs) {
        ArrayList<Integer> arrToReturn = new ArrayList<>();
        for (int v : varargs) {
            arrToReturn.add(v);
        }
        return arrToReturn;
    }

    private static int returnAnInt(Integer i) {
        return i;
    }

    private static Integer returnAnInteger(int i) {
        return i;
    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.0);
    }

    private static double getDoublePrimitive() {
        return 100.0;
    }
}