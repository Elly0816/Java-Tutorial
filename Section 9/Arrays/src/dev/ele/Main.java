package dev.ele;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] myIntArray = new int[10];
        myIntArray[0] = 45;
        myIntArray[1] = 1;
        myIntArray[5] = 50;

        double[] myDoubleArry = new double[10];
        myDoubleArry[2] = 3.5;

        System.out.println(myDoubleArry[2]);

        int[] firstTen = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("First= " + firstTen[0]);
        int arrayLength = firstTen.length;
        System.out.println("Last= " + firstTen[arrayLength - 1]);
        System.out.println("Length of the array is " + arrayLength);

        int[] newArray = new int[5];
        // newArray = new int[] { 5, 4, 3, 2, 1 };
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newArray.length - i;
        }

        for (int item : newArray) {
            // System.out.print(item);
            if (item != newArray[newArray.length - 1]) {
                if (item == newArray[0]) {
                    System.out.print("[" + item + ", ");
                } else {
                    System.out.print(item + ", ");
                }
            } else {
                System.out.print(item + "]");
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(newArray));
        // for (int i = 0; i < newArray.length; i++) {
        // }
        System.out.println();
        Object objVar = newArray;
        if (objVar instanceof int[]) {
            System.out.println("The object is really an int array");
        }

        Object[] objectArray = new Object[7];

        objectArray[0] = "Hello";
        objectArray[1] = Integer.valueOf("23");
        objectArray[2] = new StringBuilder("This is a string builder");
        objectArray[3] = Double.valueOf("22.5");
        objectArray[4] = Character.valueOf('g');
        objectArray[5] = Arrays.toString(objectArray);
        objectArray[6] = Arrays.toString(objectArray);

        for (Object val : objectArray) {
            System.out.print(val + " ");
        }

    }
}