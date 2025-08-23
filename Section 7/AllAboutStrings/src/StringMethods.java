public class StringMethods {

    public static void main(String[] args) {
        String birthDate = "25/08/1997";
        int startingIndex = birthDate.indexOf("1997");
        System.out.println("Starting Index: " + startingIndex);
        System.out.println("Birth year: " + birthDate.substring(startingIndex));

        int monthStartIndex = 3, monthEndIndex = 5, dayStartIndex = 0, dayEndIndex = 2;
        System.out.println("Birth month: " + birthDate.substring(monthStartIndex, monthEndIndex));

        String newDate = String.join("-", birthDate.substring(dayStartIndex, dayEndIndex),
                birthDate.substring(monthStartIndex, monthEndIndex), birthDate.substring(startingIndex));
        System.out.println(newDate);

        birthDate = birthDate.replace("/", "...");
        System.out.println(birthDate);

        System.out.println("ABC\n".repeat(15));
        System.out.println("-".repeat(20));

        System.out.println("ABC\n".repeat(15).indent(8));
        System.out.println("-".repeat(20));

        System.out.println("ABC\n".repeat(15).indent(8).indent(-5));
        System.out.println("-".repeat(20));
    }
}
