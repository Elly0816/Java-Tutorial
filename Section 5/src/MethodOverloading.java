public class MethodOverloading {

    public static void main(String[] args) {
        int myScore = calculateScore("Elly", 2000);
        System.out.println(myScore);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score + 1000;
    }
}