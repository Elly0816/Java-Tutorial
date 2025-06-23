public class TeenNumberChecker{
    public static void main(String[] args){
        System.out.println(hasTeen(15, 20, 9));
    }

    public static boolean hasTeen(int num1 , int num2, int num3){
        return (isTeen(num1)||isTeen(num2)||isTeen(num3));
    }

    public static boolean isTeen(int number){
    
        return ((number < 20) && (number > 12));
    }
}