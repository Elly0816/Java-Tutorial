import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int counter = 0, sum = 0, maxNumber;
        ArrayList<Integer> numbers = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter an integer: ");
            while (true) {
                try {
                    maxNumber = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Enter a valid integer: ");
                    sc.nextLine();
                }
            }
        }

        for (int i = 0; counter < 5 && i <= maxNumber; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                System.out.println("" + i + " is divisible by 3 and 5");
                counter++;
                sum += i;
                numbers.add(i);
            }
        }
        System.out.println("Found " + counter + " number(s) divisible by both 3 and 5. The numbers are: " + numbers
                + ". The sum of all the numbers are: " + sum);

        // int primeCounter = 0;

        // for (int i = 0; primeCounter < 3 && i <= 1000; i++) {
        // if (isPrime(i)) {
        // primeCounter++;
        // }
        // // if (primeCounter == 3) {
        // // break;
        // // }
        // }
        // System.out.println("The number of primes found is: " + primeCounter);
        // long startTime = System.nanoTime();
        // long testCase = 4294967291l;
        // // 4294967291l
        // // isPrime(testCase);
        // System.out.println("" + testCase + " is " + (isPrime(testCase) ? "" : "NOT")
        // + " a prime number");
        // long endTime = System.nanoTime();

        // long duration = endTime - startTime;
        // System.out.println("Operation took " + (duration / 1000000) + "ms");
        // ;
        // double interest = 5.5;
        // double amount = 100.00;
        // for (double i = 7.5; i <= 10; i += 0.25) {
        // if (i > 8.5) {
        // break;
        // }
        // System.out.println("$" + amount + " at " + i + "% is: $" + (amount +
        // calculateInterest(amount, i)));
        // }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return amount * (interestRate / 100);
    }

    public static boolean isPrime(long number) {
        if (number < 2) {
            System.out.println("" + number + " is not a prime!");
            return false;
        }
        for (long i = 1; i < number; i++) {
            if (i != 1 && number % i == 0) {
                System.out.println("" + number + " is not a prime!");
                return false;
            }
        }
        System.out.println("" + number + " is a prime!");
        return true;
    }
}