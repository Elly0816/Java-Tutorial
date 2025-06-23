public class MinutesToYearsAndDays{
    public static void main(String[] args) {
        printYearsAndDays(561600);
    }

    public static void printYearsAndDays(long minutes){
        if (minutes < 0){
            System.out.println("Invalid Value");
        } else {
            long original = minutes;
            int years = (int)(minutes/525600);
            minutes = minutes%525600;
            int days = (int) (minutes/1440);
            minutes = minutes%525600;
            System.out.println(""+original+" min = "+years+" y and "+days+" d");

        }
    }
}