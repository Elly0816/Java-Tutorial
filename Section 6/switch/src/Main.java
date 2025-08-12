import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer from 1 to 7: ");
        // int day = Integer.MIN_VALUE;
        int day;

        while (true) {
            try {
                day = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Enter a valid integer!: ");
                sc.nextLine();
                // day = Integer.MIN_VALUE;
            }
        }
        ;
        printDayOfWeek(day);

        for (int i = 1; i <= 8; i++) {
            printDayOfWeek(i);
        }

        sc.close();
        // System.out.print("Enter a character: ");
        // String input = sc.next();
        // while (input.length() > 1) {
        // sc.nextLine();
        // System.out.println("You entered a String, enter a character instead!");
        // System.out.print("Enter a valid character: ");
        // input = sc.next();
        // }
        // ;

        // char letter = input.toUpperCase().charAt(0);
        // String phonetic = getNatoPhonetic(letter);

        // if (phonetic.contains("bad")) {
        // System.out.println("" + letter + " is an invalid input!");
        // } else {
        // System.out.println("The NATO phonetic for " + letter + " is " + phonetic);
        // }
        // String month = sc.next();
        // String quarter = getQuarter(month);
        // if (quarter.equals("Invalid Input")) {

        // System.out.println("" + month + " is not a valid month!");
        // } else {

        // System.out.println("The month: " + month + " is in the " + quarter + "
        // quarter");
        // }

    }

    public static void printDayOfWeek(int day) {
        String dayOfWeek = switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "Invalid Input";
        };

        if (dayOfWeek.toLowerCase().contains("invalid")) {
            System.out.println(dayOfWeek);
        } else {
            System.out.println("The day " + day + " is " + dayOfWeek);
        }

        // String dayOfWeek = "";
        // switch (day) {
        // case 1:
        // dayOfWeek = "Sunday";
        // break;
        // case 2:
        // dayOfWeek = "Monday";
        // break;
        // case 3:
        // dayOfWeek = "Tuesday";
        // break;
        // case 4:
        // dayOfWeek = "Wednesday";
        // break;
        // case 5:
        // dayOfWeek = "Thursday";
        // break;
        // case 6:
        // dayOfWeek = "Friday";
        // break;
        // case 7:
        // dayOfWeek = "Saturday";
        // break;
        // default:
        // System.out.println("Invalid number entered!");
        // return;
        // }
        // ;
        // System.out.println("The day of the week is: " + dayOfWeek);
    }

    public static String getQuarter(String month) {
        return switch (month.toUpperCase()) {
            case "JANUARY", "FEBRUARY", "MARCH" -> "First";
            case "APRIL", "MAY", "JUNE" -> "Second";
            case "JULY", "AUGUST", "SEPTEMBER" -> "Third";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "Fourth";
            default -> "Invalid Input";
        };
    }

    public static String getNatoPhonetic(char character) {
        switch (character) {
            case 'A':
                return "Able";
            case 'B':
                return "Baker";
            case 'C':
                return "Charlie";
            case 'D':
                return "Dog";
            case 'E':
                return "Easy";
            default:
                return "bad Input";
        }
        // return switch (character) {
        // case 'A' -> "Able";
        // case 'B' -> "Baker";
        // case 'C' -> "Charlie";
        // case 'D' -> "Dog";
        // case 'E' -> "Easy";
        // default -> "bad input";
        // };
    }
}
// int switchValue = Integer.MIN_VALUE;

// System.out.print("Enter a value: ");
// while (switchValue == Integer.MIN_VALUE) {
// try {
// switchValue = sc.nextInt();
// } catch (InputMismatchException e) {
// System.out.println("You entered an invalid value!");
// System.out.print("Enter a valid integer: ");
// switchValue = Integer.MIN_VALUE;
// sc.next();
// }
// }
// ;

// switch (switchValue) {
// case 1 -> System.out.println("The value is: " + switchValue);
// case 2 -> System.out.println("The value is: " + switchValue);
// case 3, 4, 5 -> System.out.println("The value is: " + switchValue);
// default -> System.out.println("The value is: " + switchValue + " and it is
// not in the cased values!");
// }

// switch (switchValue) {
// case 1:
// System.out.println("The value is: " + switchValue);
// break;
// case 2:
// case 3:
// case 4:
// System.out.println("The value is: " + switchValue);
// break;
// default:
// System.out.println("The value is: " + switchValue + " and it is not in the
// cased values!");
// break;

// }

// String entry = "Nothing";
// String month = getQuarter(entry);
// System.out.println(month);
// int value = 3;
// switch (value){
// case 1 -> System.out.println("Value was 1");
// case 2 -> System.out.println("Value was 2");
// case 3, 4, 5 -> {
// System.out.println("Value was a 3, a 4, or a 5");
// System.out.println("Actually, the value was a " +value);
// }
// default -> System.out.println("Value was not 1 or 2 or 3 or 4 or 5");
// }
// if (value==1){
// System.out.println("Value was 1");
// } else if (value ==2){
// System.out.println("Value was 2");
// } else {
// System.out.println("Value was not 1 or 2");
// }

// public static String getQuarter(String month) {
// return switch (month){
// case "January", "February", "March" ->month+ " is in the First Quarter";
// case "April", "May", "June" -> month+ " is in the Second Quarter";
// case "July","August", "September" -> month+ " is in the Third Quarter";
// case "October", "November", "December" -> month+ " is in the Fourth Quarter";
// default -> {
// String badResponse = month+" is a bad month";
// yield badResponse;
// }
// };
// }
