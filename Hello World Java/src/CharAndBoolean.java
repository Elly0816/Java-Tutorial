class CharAndBoolean {

    public static void main(String[] args) {

        StringBuilder anotherString = new StringBuilder();
        anotherString.append("This is another String");
        anotherString.insert(6, Double.parseDouble("355"));
        System.out.println("This is the string built with the string builder: " + anotherString.toString());

        // String lastString = "10";
        // int myInt = 50;

        // System.out.println(
        // "This is the value of lastString: " + lastString + ", and this is the value
        // of myInt: " + myInt);
        // lastString += myInt;

        // System.out.println("This is the value of lastString after the concatenation:
        // " + lastString
        // + ", and this is it's type: " + ((Object) lastString).getClass().getName());
        // int myInt = Integer.parseInt("10");

        // System.out.println("This is an integer from my string: " + myInt);
        // System.out.println("And it's type is: " + ((Object)
        // myInt).getClass().getName());

        // String numberString = "250.55";
        // numberString += "49.45";
        // System.out.println(numberString);

        // String myString = "This is a string";
        // System.out.println("myString is equal to: " + myString);

        // String dollarSign = ("\u0024");
        // myString += ", and this is more of the string";
        // System.out.println("This is the new string after adding more to it: " +
        // myString);

        // System.out.println("\nAll I see is dollar signs " + dollarSign + "!");
        // boolean myTrueBoolean = true;

        // boolean myFalseBoolean = false;

        // char question = '?';
        // char unicode_question = '\u003f';
        // char alt_question = 63;

        // System.out.println(
        // "The string representation of question is: " + question + ", while the
        // unicode representation is: "
        // + unicode_question + ", and finally, the alternate integer representation is:
        // " + alt_question);

        // char myChar = '\u0076';

        // System.out.println("This is the weird character: " + myChar);

    }

}