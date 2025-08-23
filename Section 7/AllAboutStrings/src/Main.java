public class Main {
    public static void main(String[] args) {
        printInformation("Hello World");
        printInformation("");
        printInformation("\t   \n");

        String helloWorld = "Hello World";
        char indexOfchar = 'l';
        String stringToLookUp = "llo";
        System.out.printf("The last index of '%c' is %d%n%n", indexOfchar, helloWorld.lastIndexOf(indexOfchar, 9));/**
                                                                                                                    * Understand
                                                                                                                    * how
                                                                                                                    * this
                                                                                                                    * works
                                                                                                                    * 
                                                                                                                    * 
                                                                                                                    * indexOf
                                                                                                                    * and
                                                                                                                    * lastIndexOf
                                                                                                                    * are
                                                                                                                    * both
                                                                                                                    * string
                                                                                                                    * inspection
                                                                                                                    * methods
                                                                                                                    * 
                                                                                                                    **/
        System.out.printf("The index of '%c' is %d%n%n", indexOfchar, helloWorld.indexOf(indexOfchar, 3));
        System.out.printf("The index of '%s' is %d%n%n", stringToLookUp, helloWorld.indexOf(stringToLookUp));

        String helloWorldLower = helloWorld.toLowerCase();
        boolean contentEquals = helloWorld.contentEquals(helloWorldLower);
        boolean equals = helloWorld.equals(helloWorldLower);
        boolean equalsIgnorCasing = helloWorld.equalsIgnoreCase(helloWorldLower);
        System.out.printf("Using contentEquals: %s is equal to %s: %b%n", helloWorld, helloWorldLower,
                contentEquals);
        System.out.printf("Using equals: %s is equal to %s: %b%n", helloWorld, helloWorldLower, equals);
        System.out.printf("Using equalsIgnoreCasing: %s is equal to %s: %b%n", helloWorld, helloWorldLower,
                equalsIgnorCasing);

        if (helloWorld.toLowerCase().startsWith("hello")) {
            System.out.printf("String starts with hello%n%n");
        }

        if (helloWorld.toLowerCase().endsWith("world")) {
            System.out.printf("String ends with hello");

        }
    }

    public static void printInformation(String string) {
        int length = string.length();
        System.out.printf("Length: %,d%n", length);
        if (string.isEmpty()) {
            System.out.println("String is Empty!%n%n".formatted());
            return;
        }
        if (string.isBlank()) {
            System.out.println("String is Blank!");
            // return;
        }
        System.out.printf("First character: %c%n", string.charAt(0));
        System.out.printf("Last character: %c%n%n%n", string.charAt(length - 1));

    }

}