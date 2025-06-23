public class Exercise{
    public static void main(String[] args){
        double first = 20.00d;
        double second = 80.00d;
        double result1 = (first+second)*100.00d;
        double remainder = result1%40.00d;
        boolean isRemainder = ((remainder == 0) ? false : true);
        System.out.println("Does:\n" +"((" +first+ "+" +second+ ")" +
        "*100.00)%40.00");
        String yesOrNo = isRemainder ? ("Yes, it is: "+remainder) : ("No, it is: "+remainder);
        System.out.println("Have a remainder?\n"+yesOrNo);
    }
}