public class ControlBlock {
    public static void main(String[] args){
        
        boolean gameOver = true;
        int score = 5001;
        int levelCompleted = 5;
        int bonus = 100;

        checkScore(score);
    }

    public static void checkScore(int score){
        if ((score >= 1000) && (score <= 5000)){
            System.out.println("The score is between 999 and 4999");
        } else {
            System.out.println("The score is either less than 1000 or greater than 5000");
        }
    }
}