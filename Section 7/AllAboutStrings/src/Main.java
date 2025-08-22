public class Main {
    public static void main(String[] args) {
        printInformation("");
    }

    public static void printInformation(String string) {
        int length = string.length();
        System.out.printf("Length: %,d%n", length);
        if (string.isEmpty())
            return;
        System.out.printf("First character: %c%n", string.charAt(0));
        System.out.printf("Last character: %c%n", string.charAt(length - 1));

    }

}