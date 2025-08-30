/**
 * 
 * This file contains the introdution to Arrays 
 * and advanced Arrays in Java
 * 
 * You'vs already used arrays in previous chapters/sections
 */

package dev.ele;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] newArray = getRandomArray(10);
        System.out.println(Arrays.toString(newArray));
        Arrays.sort(newArray);
        System.out.println(Arrays.toString(newArray));

        int[] secondArray = new int[10];
        Arrays.fill(secondArray, 25);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = getRandomArray(5);
        int[] thirdArrayCopy = Arrays.copyOf(thirdArray, thirdArray.length);
        Arrays.sort(thirdArrayCopy);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(thirdArrayCopy));

        int[] smallerArray = getRandomArray(10);
        int[] smallerArrayCopy = Arrays.copyOf(smallerArray, smallerArray.length / 2);
        System.out.println(Arrays.toString(smallerArray));
        System.out.println(Arrays.toString(smallerArrayCopy));

    }

    private static int[] getRandomArray(int len) {
        int[] array = new int[len];
        Random rand = new Random();

        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(100);
        }

        return array;
    }
}