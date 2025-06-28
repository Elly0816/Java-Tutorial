import java.util.Scanner;

class FloatAndDouble {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print(
                "This program will help you convert from kg's too pounds.\nFirst enter kg to convert from kg, or pounds to convert from pounds  ");
        String from = sc.next();
        Double kgs_to_pounds = 2.205, result, kgs, pounds;

        if (from.equalsIgnoreCase("kg")) {
            System.out.println("Enter a number in kgs: ");

            kgs = sc.nextDouble();
            result = kgs * kgs_to_pounds;
            System.out.println(kgs + "kg in pounds is: " + result + "lbs");
        } else if (from.equalsIgnoreCase("pounds")) {
            System.out.println("Enter a number in pounds: ");
            pounds = sc.nextDouble();
            result = pounds / kgs_to_pounds;
            System.out.println(pounds + "lbs in kilograms is: " + result + "kgs");
        } else {
            System.out.println("Invalid Input");
        }
        sc.close();

        // int int_value = 5 / 3;
        // float float_value = 5f / 3.23f;
        // double double_value = 5d / 3.23;

        // System.out.println("The int value is: " + int_value + ", the float value is:
        // " + float_value
        // + ", and the double value is: " + double_value);

        // Sca

        // // double amount = 1.3E2;
        // double min_double = Double.MIN_VALUE;
        // double max_double = Double.MAX_VALUE;
        // float max_float = Float.MAX_VALUE;
        // float min_float = Float.MIN_VALUE;

        // System.out.println("The max value for a float is: " + max_float + " and the
        // min value is: " + min_float);
        // System.out.println(
        // "The max value for a double is: " + max_double + " and the min value for a
        // double is: " + min_double);

    }
}