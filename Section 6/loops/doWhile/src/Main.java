public class Main {
    public static void main(String[] args) {

        int i = 0;

        long startTime = System.nanoTime();
        do {
            if (i % 15 == 0 && i != 0) {

                System.out.println("" + i + " is divisible by 15");
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        } while (i <= 100);
        long finishTime = System.nanoTime();
        System.out.println("The loop took " + ((finishTime - startTime) / 1_000_000) + "ms");
    }
}