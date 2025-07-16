import java.util.InputMismatchException;
import java.util.Scanner;

public class Section4 {

    public static void main(String[] args) {

        String name;
        Scanner sc;
        String regexForName = "^[a-zA-Z ]+$";
        boolean isNotValidName = true;

        System.out.print("What is your name: ");

        do {

            sc = new Scanner(System.in);

            name = sc.nextLine();

            isNotValidName = !name.matches(regexForName);

            if (isNotValidName) {
                System.out.println("Enter a valid name!");
            }

        } while (isNotValidName);

        // sc.close();
        /*
         * 
         * NOTE: You cannot reopen a scanner that uses system.in after closing it.
         * 
         * 
         */

        System.out.println("Hi, " + name);

        int newValue = 0;

        boolean isNotValidNumber = true;

        System.out.print("Enter a number: ");

        // sc = new Scanner(System.in);
        do {
            try {
                newValue = sc.nextInt();
                isNotValidNumber = false;
            } catch (InputMismatchException e) {
                isNotValidNumber = true;
                sc.next();
                System.out.print("Enter a valid number: ");
            }
        } while (isNotValidNumber);
        sc.close();

        if (newValue > 50) {
            System.out.println("The condition has been met");
            System.out.println("New value is " + newValue);
        } else {
            System.out.println("The condition has not been met");
            System.out.println("New Value is " + newValue);

        }

    }

}