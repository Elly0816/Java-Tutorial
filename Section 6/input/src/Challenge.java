import java.util.InputMismatchException;
import java.util.Scanner;

public class Challenge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // System.out.println("The sum of all the numbers is: " + getSum(sc));
        getMinMax(sc);
        sc.close();
    }

    public static void getMinMax(Scanner sc) {

        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        System.out.println("This is going to keep track of the min and max integer entries");
        while (true) {
            try {
                System.out.print("Enter a number, you can enter a character when you want to quit: ");
                double num = sc.nextDouble();
                if (num > max) {
                    max = num;
                }
                if (num < min) {
                    min = num;
                }
                System.out.println("MAX: " + max + "\nMIN: " + min);
            } catch (InputMismatchException e) {
                if (min == Double.MAX_VALUE || max == Double.MIN_VALUE) {
                    System.out.println("No valid numbers entered");
                }
                System.out.print("Quitting...");
                break;
            }
        }
    }

    public static double getSum(Scanner sc) {

        double sum = 0, currNum = 0;
        int i = 0, num = 0;

        System.out.print("Enter the amount of numbers you want to add: ");
        while (true) {
            try {
                num = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("Enter a valid integer: ");
            }
        }

        while (i < num) {
            System.out.print("Enter number #" + (i + 1) + ": ");
            try {
                currNum = sc.nextDouble();
                sum += currNum;
                i++;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("Enter a valid number!\n");
            }
        }
        return sum;

    }
}
