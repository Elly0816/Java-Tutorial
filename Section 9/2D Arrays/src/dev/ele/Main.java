package dev.ele;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[][] array2 = new int[5][4];

        array2[1] = new int[] { 10, 20, 30 };
        System.out.println(Arrays.deepToString(array2));

        Object[] anyArray = new Object[3];
        anyArray[0] = new String[] { "This", "is", "the", "first", "array", "element" };
        System.out.println(Arrays.deepToString(anyArray));
        System.out.println("_".repeat(15));
        anyArray[1] = new String[][] {
                { "1", "2" }, { "3", "4", "5" }, { "6", "7", "8", "9" }
        };
        System.out.println(Arrays.deepToString(anyArray));
        System.out.println("_".repeat(15));

        anyArray[2] = new int[2][2][2];
        System.out.println(Arrays.deepToString(anyArray));

        for (var item : anyArray) {
            System.out.println("_".repeat(20));
            System.out.println("Element type = " + item.getClass().getSimpleName());
            System.out.println("Element toString() = " + item);
            System.out.println(Arrays.deepToString((Object[]) item));
            System.out.println("_".repeat(20));
        }
        // Random rand = new Random();
        // int[][][] array2 = new int[4][4][6];
        // System.out.println(Arrays.deepToString(array2));
        // System.out.println("Array 2 length: " + array2.length);
        // System.out.println(Arrays.deepToString(array2));
        // System.out.println("_".repeat(30));
        // for (int i = 0; i < array2.length; i++) {
        // var arr = array2[i];
        // for (int j = 0; j < arr.length; j++) {
        // var arr2 = arr[j];
        // for (int k = 0; k < arr2.length; k++) {
        // arr2[k] = rand.nextInt(100);
        // }
        // }
        // }

        // System.out.println(Arrays.deepToString(array2));

        // for (int[] arr : array2) {
        // System.out.println(Arrays.toString(arr));
        // // for (int item : arr) {
        // // System.out.print(item + " ");
        // // }
        // // System.out.println();
        // }

        // for (int i = 0; i < array2.length; i++) {
        // var innerArray = array2[i];
        // for (int j = 0; j < innerArray.length; j++) {
        // System.out.print(innerArray[j] + " ");
        // }
        // System.out.println();
        // }
        // int[][] array = {
        // { 1, 2, 3 },
        // { 11, 12, 13, 14 },
        // { 21, 22, 23, 24, 25 },
        // { 31, 32, 33, 34, 35, 36 }
        // };

        // int[][] arr = new int[3][];

        // for (int[] arr : array) {
        // for (int item : arr) {
        // System.out.println(item);
        // }
        // }

        // for (int i = 0; i < array.length; i++) {
        // for (int j = 0; j < array[i].length; j++) {
        // System.out.println(array[i][j]);
        // }
        // }
    }

}