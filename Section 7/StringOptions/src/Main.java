public class Main {

    public static void main(String[] args) {

        String helloWorld = "Hello" + " " + "World";
        StringBuilder stringBuilder = new StringBuilder("Hello" + " " + "World");
        StringBuilder string = new StringBuilder();
        StringBuilder string2 = new StringBuilder(30);
        helloWorld.concat(" and Goodbye");
        stringBuilder.append(" and Goodbye");

        // printInformation(string);
        // printInformation(string2);
        string.append("a".repeat(16));
        string2.append("a".repeat(16));
        // printInformation(string);
        // printInformation(string2);

        // string.append(string2);
        string2.append(string);

        // printInformation(string);
        // printInformation(string2);

        // printInformation(stringBuilder);
        // printInformation(helloWorld);

        // StringBuilder stringBuilderPlus = new StringBuilder("Hello" + " " + "World");
        // StringBuilder stringBuilderPlus = new StringBuilder(12);
        // for (int i = 1; i <= 120; i++) {
        // stringBuilderPlus.append("a");

        // printInformation(stringBuilderPlus);
        // }
        // stringBuilderPlus.append("Hello, and Goodbye");
        // printInformation(stringBuilderPlus);
        StringBuilder stringBuilderPlus = new StringBuilder(12);
        stringBuilderPlus.append("Hello World");
        stringBuilderPlus.append(" and goodbye");
        stringBuilderPlus.deleteCharAt(4).insert(4, 'a');
        printInformation(stringBuilderPlus);
        stringBuilderPlus.replace(5, 6, " + ");
        printInformation(stringBuilderPlus);
        stringBuilderPlus.reverse().setLength(20);
        printInformation(stringBuilderPlus);
    }

    public static void printInformation(String string) {
        System.out.println("\n\nString = " + string);
        System.out.println("Length = " + string.length());
    }

    public static void printInformation(StringBuilder stringBuilder) {
        System.out.println("\n\nString = " + stringBuilder);
        System.out.println("Length = " + stringBuilder.length());
        System.out.println("Capacity = " + stringBuilder.capacity());

    }

}