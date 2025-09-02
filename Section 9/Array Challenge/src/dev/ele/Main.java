package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] integers = readIntegers(sc);
        System.out.println("Below are the integers: ");
        System.out.println(Arrays.toString(integers));
        System.out.println("The minimum value in the array is: " + findMin(integers));
        // reverse(integers);

        System.out.println("This is the reversed array: " + Arrays.toString(reverseCopy(integers)));

        sc.close();
    }

    private static int[] readIntegers(Scanner sc) {
        // Prompt the user to enter a comma delimited list of numbers
        System.out.println("Enter a comma delimited list of numbers! ");

        // take in the input removing all white spaces and splitting by the comma
        String[] numsString = sc.nextLine().trim().replace(" ", "").split(",");
        // Parse only the integers from the array of strings into a dynamic array of
        // integers
        List<Integer> numsInt = new ArrayList<>();
        for (int i = 0; i < numsString.length; i++) {
            try {
                Integer num = Integer.parseInt(numsString[i]);
                numsInt.add(num);
            } catch (NumberFormatException e) {
                // TODO: handle exception
                continue;
            }
        }
        // map the values from the Integer array to an int array
        int[] nums = new int[numsInt.size()];
        int index = 0;
        for (Integer num : numsInt) {
            nums[index++] = (int) num;
        }

        return nums;
    }

    private static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private static void reverse(int[] arr) {
        // Start at index i=0 until Math.floor(len/2)
        // hold i in a temp var and swap i and len-1-i
        int len = arr.length, i = 0;
        while (i < Math.floor(len / 2)) {
            int temp = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = temp;
            i++;
            System.out.println("---->" + Arrays.toString(arr));
        }
    }

    private static int[] reverseCopy(int[] arrInp) {
        int len = arrInp.length;
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[len - 1 - i] = arrInp[i];
        }
        return arr;
    }
}