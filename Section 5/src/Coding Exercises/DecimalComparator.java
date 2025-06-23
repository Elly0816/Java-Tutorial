public class DecimalComparator{
    public static void main(String[] args){
        System.out.print(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
    }

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2){
        int num1check = (int)(num1*1000);
        int num2check = (int)(num2*1000);
        return num1check == num2check;
    }
}