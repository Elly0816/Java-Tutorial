public class Exercise{
    public static void main(String[] args){
        
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        // int final1 = calcul  ateScore(gameOver, score, levelCompleted, bonus);

        System.out.println("The first score is: "
        +calculateScore(gameOver, score, levelCompleted, bonus));
        
        score = 10_000;
        levelCompleted = 8;
        bonus = 200;

        // int final2 = calculateScore(gameOver, score, levelCompleted, bonus);

        System.out.println("The second score is: "
        +calculateScore(gameOver, score, levelCompleted, bonus));
    };

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;


        if (gameOver){
            finalScore +=(levelCompleted*bonus);
            // System.out.println("Your final score was " +finalScore);
        };

        return finalScore;
    };
};