import java.time.Year;

public class Main {

    public static void main(String[] args) {
        System.out.println("""
                This is something that I can hardly believe.
                They did this not me!
                These are the reasons you should believe me:
                    First Point.
                        First sub point.
                """);

        int age = 35;
        double height = 177.45;
        String name = "John";
        int yearOfBirth = Year.now().getValue() - age;
        System.out.printf("%n%s is %d years old.%nHe was born in %d and he is %.2fm tall", name, age, yearOfBirth,
                height);

        for (int i = 1; i <= 100_000; i *= 10) {
            System.out.printf("Printing %,6d%n", i);
        }

        String formattedString = String.format("%s's age is %d", name, age);
        System.out.println(formattedString);

        formattedString = "%s's age is %d".formatted(name, age);
        System.out.println(formattedString);

    }

}