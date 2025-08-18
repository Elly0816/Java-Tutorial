import java.io.IOError;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        int year = Year.now().getValue();

        Scanner scanner = new Scanner(System.in);
        // minMax();

        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        while (true) {
            try {
                if (Pattern.compile("^[A-Za-z]+$").matcher(name).matches()) {// This only matches strings
                    break;
                }
                throw new Error("Your input should only contain letters! ");
            } catch (Error e) {
                System.out.print(e.getMessage() + "\nEnter a valid name: ");
                name = scanner.nextLine();
            }
        }

        try {
            System.out.println("Hi " + name + ", this is your age using system console: "
                    +
                    usingSystemConsole(year));
            // scanner.close();
            // throw new IOError(new Error("There was an IOError"));
            // throw error;

        } catch (IOError e) {
            System.out.println(e.getMessage());

            System.out.println("Hi " + name + ", this is your age using the scanner class: " + usingScanner(year));
        }
        scanner.close();

    }

    public static String usingSystemConsole(int currentYear) {

        // System.out.print("What is your currentYear of birth? ");
        String birthcurrentYear = System.console().readLine("What is your year of birth? ");
        int birthcurrentYearInt = -1;
        while (true) {
            try {

                birthcurrentYearInt = Integer.parseInt(birthcurrentYear);
                if (birthcurrentYearInt > currentYear || currentYear - birthcurrentYearInt >= 120) {
                    // System.out.print("Enter a valid currentYear!: ");
                    birthcurrentYear = System.console()
                            .readLine(
                                    "Enter a valid year between " + currentYear + " and " + (currentYear - 120) + ": ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input!");
                birthcurrentYear = System.console().readLine("Enter a valid year of birth: ");
            }
        }
        return "You are " + (currentYear - birthcurrentYearInt) + " years old!";
    }

    public static String usingScanner(int currentYear) {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is your yaer of birth? ");
        int birthYear = -1;
        while (true) {
            try {
                birthYear = sc.nextInt();
                if (birthYear > currentYear || currentYear - birthYear >= 120) {
                    sc.nextLine();
                    System.out
                            .print("Enter a valid year between " + currentYear + " and " + (currentYear - 120) + ": ");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                // TODO: handle exception
                System.out.print("Invalid Input!\nEnter a valid year: ");
                sc.nextLine();
            }
        }

        sc.close();
        return "You are " + (currentYear - birthYear) + " years old!";
    }

    // public static String getInputFromConsole(int currentYear) {
    // String name = System.console().readLine("What is your name?\n");
    // System.out.println("Hi " +name+ ", Thanks for taking the course");
    // int yearOfBirth = Integer.parseInt(System.console().readLine("What year were
    // you born " +name+ "?\n"));
    // int age = currentYear-yearOfBirth;
    // // System.out.println("Hi " +name+ ", You are "+age+" years old");
    // return "You are "+age+" years old " +name;
    // }

    // public static String getInputFromScanner(int currentYear) {
    // Scanner sc = new Scanner(System.in);
    // System.out.println("What is your name?");
    // String name = sc.nextLine();
    // System.out.println("Hi " +name+ ", Thanks for taking the course");
    // System.out.println("What year were you born " +name+ "?");
    // int yearOfBirth = Integer.parseInt(sc.nextLine());
    // while ((yearOfBirth > currentYear) || ((currentYear - yearOfBirth) > 125) ||
    // yearOfBirth < 0){
    // System.out.println("You can't have been born in the year "+yearOfBirth+ " "
    // +name+
    // ", Please enter a valid year of birth:");
    // yearOfBirth = Integer.parseInt(sc.nextLine());
    // }
    // int age = currentYear-yearOfBirth;
    // sc.close();
    // return "You are "+age+" years old " +name;
    // }

    // public static void sumOfNumbers() {
    // Scanner sc = new Scanner(System.in);
    // double sum=0;
    // double number=0;
    // for (int i=1; i<=5; i++){
    // Boolean isValid = false;
    // System.out.println("Enter a number:");
    // String numberString = sc.nextLine();
    // while(!isValid){
    // try {
    // isValid = true;
    // number = Double.parseDouble(numberString);
    // } catch (Exception NumberFormatException) {
    // isValid = false;
    // System.out.println("Enter a valid number:");
    // numberString = sc.nextLine();
    // }
    // }
    // sum += number;

    // }
    // sc.close();

    // System.out.println("The total of the 5 numbers is: "+sum);

    // }

    // public static void minMax() {
    // double max = Double.MIN_VALUE;
    // double min = Double.MAX_VALUE;
    // boolean isContinue = true;
    // Scanner sc = new Scanner(System.in);
    // while(isContinue){
    // System.out.println("Enter a number: ");
    // try{
    // Double num = Double.parseDouble(sc.nextLine());
    // if (num>max){
    // max = num;
    // }
    // if (num < min){
    // min = num;
    // }

    // } catch (Exception numberFormaException){
    // isContinue=false;
    // }
    // }
    // if ((max == Double.MIN_VALUE) || (min == Double.MAX_VALUE)){
    // System.out.println("You entered no valid number");
    // } else {
    // System.out.println("The max value entered was: "+max+
    // " and the min value entered was: "+min);
    // }
    // sc.close();
    // }

}