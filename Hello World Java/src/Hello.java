public class Hello {

    public static void main(String[] args) {

        byte myByte = 10;
        short myShort = 20;
        int myInt = 50;

        int sum = myByte + myShort + myInt;
        long myLong = 50_000L + 10 * sum;
        System.out.println("This is the text value of the long: " + myLong);

        // int myNewByteValue = (short) Byte.MIN_VALUE * 2;

        // System.out.println("This is the value of my new byte value: " +
        // myNewByteValue);
        // long my_number = 2_147_483_648L;

        // System.out.println("This is the number: " + my_number);

        // Declaring multiple variables on the same line

        // int first_number = 256, second_nummber = 445, third_number = 231;

        // System.out.println(first_number + ", " + second_nummber + ", " +
        // third_number);

        // int min_value = Integer.MIN_VALUE;
        // int max_value = Integer.MAX_VALUE;

        // System.out.println("This is the maximum Integer value: " + max_value
        // + ".\nWhile this is the minimum integer value: " + min_value);

        // System.out.println("I'm trying to add one to the max integer value: " +
        // (max_value + 1)
        // + " and trying to subtract one from the min integer value: " + (min_value -
        // 1));

        // long min_long_value = Long.MIN_VALUE;
        // long max_long_value = Long.MAX_VALUE;

        // System.out.println("The size of an byte is: " + Byte.SIZE + "bits");
        // System.out.println("The size of an short is: " + Short.SIZE + "bits");
        // System.out.println("The size of an integer is: " + Integer.SIZE + "bits");
        // System.out.println("The size of an long is: " + Long.SIZE + "bits");

        // System.out.println("The maximum long value is: " + max_long_value + ", while
        // the minimum long value is: "
        // + min_long_value);
        // System.out.println("Trying to add on to the maximum long value gives: " +
        // (9_223_372_036_854_775_807L)
        // + ", while trying to remove one from the minimum long value gives: " +
        // (-9_223_372_036_854_775_808L));

        // long my_own_long = 100L;

        // System.out.println(((Object) my_own_long).getClass().getName());
        // System.out.println(Long.SIZE);

        // int myFirstNumber = (10 + 5) + (2 * 10);
        // int mySecondNumber = 12;
        // int myThirdNumber = myFirstNumber * 2;

        // int[] numbers = { myFirstNumber, mySecondNumber, myThirdNumber };

        // int myTotal = 0;
        // System.out.println("These are the numbers: ");
        // for (int i = 0; i < 3; i++) {
        // System.out.println(numbers[i]);
        // myTotal = Math.addExact(numbers[i], myTotal);
        // }

        // System.out.println("The total is: " + myTotal);

        // int myLastOne = 1000 - myTotal;

        // System.out.println("This is my last one: " + myLastOne);

        // String name = "Eleazar";
        // System.out.println("Hello " + name + "!");
        // System.out.println("This is another line");
    }
}

// public class Hello{
// public static void main(String[] args){
// System.out.println("Hello, Elly");

// boolean isAlien = false;
// if (!isAlien){
// System.out.println("It is not an alien");
// } else if (isAlien){
// System.out.println("It is an alien");
// }

// int topScore = 50;
// if (topScore < 50){
// System.out.println("Top Score is less than 50");
// } else if (topScore >= 50 && topScore<100){
// System.out.println("Top Score is more than 49 but less than 100");
// } else if (topScore == 100){
// System.out.println("The TopScore is equal to: "+topScore);
// System.out.println("You got the top score!");
// }

// int secondTopScore = 95;
// if ((topScore > secondTopScore) && (topScore < 100)){
// System.out.println("Greater than second top score but less than 100");
// }

// if ((topScore > 90) || (secondTopScore <= 90)) {
// System.out.println("Either or both of the conditions are true");
// }

// int newValue = 50;
// if (newValue == 50){
// System.out.println("This is not an error");
// }

// boolean isCar = false;
// if (isCar){
// System.out.println("It is a car");
// } else {
// System.out.println("This is not a car");
// }

// String makeOfCar = "Ford";
// boolean isDomestic = (makeOfCar == "VolksWagen") ? false : true;
// String answer = (isDomestic) ? "It is Domestic" : "It is not Domestic";
// System.out.println(answer);

// int ageOfClient = 25;
// String ageText = (ageOfClient >= 18) ? "The client is Eighteen or above" :
// "The client is younger than Eighteen";
// System.out.println(ageText);
// }
// }