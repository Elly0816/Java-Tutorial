public class MethodOverloading{
    public static void main(String[] args) {
        int newScore = calculateScore("Eleazar", 5000);
        System.out.println("New score is: "+newScore);

        int anotherScore = calculateScore(newScore);
        System.out.println("New score is: "+anotherScore);

        calculateScore();
    }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player " +playerName+ " scored " +score+ " points");
        return score+1000;
    }

    public static int calculateScore(int score){
        System.out.println("Unnamed player scored " +score+ " points");
        return score+1000;
    }

    public static int calculateScore(){
        System.out.println("No player name or score");
        return 0;
    }
}