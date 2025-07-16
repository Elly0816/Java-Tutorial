public class Challenge {

    public static void main(String[] args) {
        double firstDouble = 20.00d, secondDouble = 80.00d, remainder = ((firstDouble + secondDouble) * 100d) % 40.00d;
        System.out.println("The remainder is: " + remainder);
        boolean noRemainder = remainder == 0d ? true : false;

        if (noRemainder) {

            System.out.println("Got no remainder");
        } else {
            System.out.println("Got some remainder");

        }

    }
}