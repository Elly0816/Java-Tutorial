import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int num;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer greater than 0: ");

        while (true) {
            try {
                num = sc.nextInt();
                // if (num < 1) {
                // System.out.print("Enter a positive integer!: ");
                // sc.nextLine();
                // continue;
                // } else {

                // break;
                // }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Enter a valid integer greater than 0!: ");
                sc.nextLine();
            }
        }

        sc.close();
        // NumberToWords(reverse(num));
        NumberToWords(num);

        // System.out.println("The factors of " + num + " are: ");
        // printFactors(num);
        // System.out.println(num + " " + (isPalindrome(num) ? "IS" : "IS NOT") + " a
        // palindrome");
        // System.out.println("The sum of all digits in " + num + " is: " +
        // sumDigits(num));
        // System.out.println("The original number was: " + num);

        // int i = 5, isEvenCount = 0, isOddCount = 0;
        // while (i <= 200) {
        // if (isEvenNumber(i)) {
        // isEvenCount++;
        // System.out.print(i + ", ");
        // } else {
        // isOddCount++;
        // i++;
        // continue;
        // }
        // if (isEvenCount >= 5) {
        // System.out.println("\nThe total count of even numbers is: " + isEvenCount
        // + " and the total count of odd numbers found is: " + isOddCount);
        // break;
        // }
        // i++;
        // }
    }

    public static int reverse(int num) {
        int temp = 0;
        while (num >= 10) {
            // if(num/10>=1)
            temp += num % 10;
            temp *= 10;
            num /= 10;
        }
        temp += num;
        return temp;
    }

    public static void NumberToWords(int num) {
        if (num < 0) {
            System.out.println("Invalid Value");
        }

        // while the number is positive
        // if the number is zero;
        // return it and divide by 10
        //
        while (num >= 0) {
            if (num>=10 && num%10==0) {
                System.out.println("Zero");
                num /= 10;
                continue;
            }
            System.out.println(numberInString(num % 10));
            num /= 10;
        }
        System.out.println(numberInString(num % 10));

        // while (num >= 10) {
        // System.out.println(numberInString(num % 10));
        // num /= 10;
        // }
        // System.out.println(numberInString(num % 10));

    }

    public static String numberInString(int num) {
        return switch (num) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "Invalid Value";
        };
    }

    public static void printFactors(int num) {
        if (num < 1) {
            System.out.println("Invalid Value");
            return;
        }

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPalindrome(int number) {
        int myNum = Math.abs(number);
        int reverseNum = 0, temp = myNum;

        while (temp >= 10) {
            reverseNum += temp % 10;
            temp /= 10;
            reverseNum *= 10;
        }
        reverseNum += temp;

        return myNum == reverseNum;
    }

    public static int sumDigits(int number) {
        if (number < 0) {
            return -1;
        }

        // While number is more than 10;
        // Get remainder from 10 division
        // Add remainder to sum var
        // Divide number by 10;
        // Add final number to sum
        int sum = 0, temp = 0;

        while (number > 10) {
            temp = number % 10;
            sum += temp;
            number /= 10;
        }
        sum += number;
        return sum;

    }

    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
