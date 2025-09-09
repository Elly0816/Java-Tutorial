package dev.ele;

public class ShowOptions {
    private static String options = """
            Here are the list of available Menu Options:
                0 -> Shutdown,
                1 -> Add Items (Comma delimited);
                2 -> Remove Items (Comma delimited)

            Enter an option below: """;

    public static void showMenu() {
        // System.out.println(options);
        System.out.print(options);
    }
}