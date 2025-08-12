public class MethodOverloading {

    public static void main(String[] args) {
        // System.out.println("New score is " + calculateScore("Elly", 2000));

        // System.out.println("The other new score is " + calculateScore(400));

        // System.out.println("The third score is: " + calculateScore());

        System.out.println("5 feet, 8 inches in centimeters is: " + convertToCentimeters(5, 8) + "cm");
        System.out.println("68 inches in centimeters is: " + convertToCentimeters(68) + "cm");
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score + 1000;
    }

    public static int calculateScore(int score) {
        // System.out.println("Unnamed Player scored " + score + " points");
        // return score + 1000;
        return calculateScore("Anonymous", score);
    }

    public static int calculateScore() {

        System.out.println("There is no player name and there is no player score");
        return 0;
    }

    public static double convertToCentimeters(int heightInInches) {
        return heightInInches * 2.54;
    }

    public static double convertToCentimeters(int heightInFeet, int heightInInches) {
        return (convertToCentimeters((heightInFeet * 12) + heightInInches));
    }

}