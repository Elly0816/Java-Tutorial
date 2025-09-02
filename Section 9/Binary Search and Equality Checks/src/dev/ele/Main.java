/**
 * 
 * This file implements the binary search method that's packaged in
 * Array class
 */

package dev.ele;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Checking equality of arrays
        String[] arrStrings = { "John", "Mary", "Mark", "Eleazar", "Matthew" };
        String[] arrStrings2 = { "Mary", "John", "Mark", "Eleazar", "Matthew", "James" };
        Arrays.sort(arrStrings);
        Arrays.sort(arrStrings2);
        if (Arrays.equals(arrStrings, arrStrings2)) {
            System.out.println("These arrays are equal!");
        } else {
            System.out.println("These arrays are not equal! ");
        }

        // Using Binary Search in arrays
        // Int array
        // With user input
        int[] intArr = createIntArray(15);
        System.out.println(Arrays.toString(intArr));
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
        Scanner sc = new Scanner(System.in);
        int value;
        while (true) {
            try {
                System.out.print("Enter the value of the integer you want to fing in the array: ");
                value = sc.nextInt();
                int index = Arrays.binarySearch(intArr, value);
                if (index <= -1) {
                    System.out.println("The item was not found in the array");
                    System.out.println("This is the array: " + Arrays.toString(intArr));
                } else {
                    System.out.println("Index: " + index + "\nValue: " + intArr[index]);
                    sc.close();
                    break;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Enter a valid integer!");
            }

        }

    }

    private static int[] createIntArray(int len) {
        int[] intArr = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            intArr[i] = rand.nextInt(100);
        }
        return intArr;
    }
}