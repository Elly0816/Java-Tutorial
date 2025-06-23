public class BarkingDog{
    public static void main(String[] args){
        System.out.print(shouldWakeUp(true, 23));
    }

    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay){
        if ((hourOfDay <= 24) && (hourOfDay >= 0)){
            if (isBarking){
                if ((hourOfDay < 8) || (hourOfDay > 22)){
                    return true;
                }
            }   
            return false;
        }
        return false;
    }
}