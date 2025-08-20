public class Main {

    public static void main(String[] args) {

        LPAStudent[] students = new LPAStudent[5];

        for (int i = 1; i <= 5; i++) {
            students[i - 1] = new LPAStudent(i + "234251", switch (i) {
                case 1 -> "Eleazar";
                case 2 -> "Jeremiah";
                case 3 -> "Jeffrey";
                case 4 -> "Xavier";
                case 5 -> "Alexander";
                default -> "Anonymous";
            }, "1/1/200" + i, switch (i) {
                case 1 -> "C++, Python, TypeScript/JavaScript, Java, C, React";
                case 2 -> "Python, C++, C";
                case 3 -> "Python";
                case 4 -> "Unknown";
                case 5 -> "HTML/CSS";
                default -> "Invalid";
            });
        }

        for (int i = 0; i < students.length; i++) {
            System.out.println("Student #" + (i + 1) + " is: " + students[i]);
            // students[i].setId("0");
            System.out.println(students[i]);
        }
    }
}