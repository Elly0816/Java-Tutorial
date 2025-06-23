public class MethodChallenge{

    
    public static void main(String[] args) {
        int score = 1500;    

        System.out.println(displayHighScorePosition("Tim",
        calculateHighScorePosition(score)));
    
        score = 1000;

        System.out.println(displayHighScorePosition("Tom",
        calculateHighScorePosition(score)));

        
        score = 500;

        System.out.println(displayHighScorePosition("Sam",
        calculateHighScorePosition(score)));

        
        score = 100;

        System.out.println(displayHighScorePosition("Tam",
        calculateHighScorePosition(score)));

        
        score = 25;

        System.out.println(displayHighScorePosition("Cam",
        calculateHighScorePosition(score)));
    }

    public static String displayHighScorePosition(String name, int position){
        return name+" managed to get into position "
        +position+ " on the high score list";
    }

    public static int calculateHighScorePosition(int score){
        int toReturn = 4;
        
        if (score >= 1000){
            toReturn = 1;
        } else if (score >= 500){
            toReturn = 2;
        } else if (score >= 100){
            toReturn = 3;
        } 
        return toReturn;
    }
}


