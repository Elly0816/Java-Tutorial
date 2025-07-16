public class Exercise {
    public static void main(String[] args) {
        // int final1 = calcul ateScore(gameOver, score, levelCompleted, bonus);

        calculateScore(true, 800, 5, 100);

        // int final2 = calculateScore(gameOver, score, levelCompleted, bonus);

        calculateScore(true, 10_000, 8, 200);
    };

    private static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            // System.out.println("Your final score was " +finalScore);
        }
        ;

        System.out.println("Your final score is " + finalScore);

        return finalScore;
    };
};