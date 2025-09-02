package dev.ele;

import java.util.Arrays;
// import java.util.Comparator;
import java.util.Random;

/*
 * This file contains the array challenge from Java Masterclass
 * It should sort an array of integers in descending order
 * 
 */

public class Main {
    public static void main(String[] args) {
        int[] arr = generateIntArray(10);
        System.out.println("This is the unsorted Array: " + Arrays.toString(arr));
        // Arrays.sort(arr);
        // System.out.println("This is the default sorted Array: " +
        // Arrays.toString(arr));
        sortArrayDesc(arr);
        System.out.println("This is the sorted Array in descending order: " + Arrays.toString(arr));
        doubleEntries(arr);
        System.out.println("This is the array after doubling the entries: " + Arrays.toString(arr));
    }

    private static int[] generateIntArray(int len) {
        int[] arr = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    private static void sortArrayDesc(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    private static void doubleEntries(int[] arr) {
        int i = 0;
        for (int item : arr) {
            System.out.println("Item before doubling: " + item);
            item *= 2;
            arr[i++] = item;
            System.out.println("Item after doubling: " + item);
        }
    }
}