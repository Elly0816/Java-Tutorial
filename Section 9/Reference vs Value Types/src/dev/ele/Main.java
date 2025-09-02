package dev.ele;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[20];
        int[] anotherArr = arr;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(anotherArr));

        anotherArr[0] = 10;
        modifyArray(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(anotherArr));

    }

    private static void modifyArray(int[] array) {
        array[1] = 2;
    }
}