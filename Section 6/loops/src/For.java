public class For{
    public static void main(String[] args) {
        // int number = 25;
        // int primeCount = primeCount(number);
        // System.out.println("There are " +primeCount+ " prime numbers between 0 and "+number);
        // sum3And5();
        int start = 1;
        int end = 15;
        System.out.println("The sum of odd numbers between "+start+ " and " +end+
        " is: " +sumOdd(start, end));
    }

    public static void forLoop(int number) {
        for (int i=1; i <= number; i++){
            System.out.println("This is the current number: "+i);
        }
    }
    
    public static double calculateInterest(double amount, double interest) {
        return amount * (interest/100);
    }

    public static void amountReturned(double amount, int years){
        for (double interest=7.5; interest <=10; interest+=0.25){
            if (interest > 8.5){
            break;
            }
            double toReturn = amount;
            for (int i=1; i<=years; i++){
                toReturn += calculateInterest(toReturn, interest);
            }
    
            System.out.println("$" +amount+ " at " +interest+ "% for " +years+
             " years amounts to: $" +toReturn);
        }
    }

    public static boolean isPrime(int number) {
        boolean isPrime =true;
        if (number <= 1){
            isPrime = false;
        }
        for (int i=2; i<number; i++){
            if (number % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static int primeCount(int number){
        int count = 0;
        for (int i=0; i<= number; i++){
            count = isPrime(i) ? count+1 : count;
            if(count >= 3){
                break;
            }
        }
        return count;
    }


    public static void sum3And5(){
        int sum = 0;
        int count = 0;
        for (int i=1; i<=1000; i++){
            if ((i%3==0) && (i%5==0)){
                count ++;
                sum +=i;
                System.out.println(i);
            }
            if (count >= 5){
                break;
            }
        }
        System.out.println("The sum of all the numbers above is: "+sum);
    }

    public static boolean isOdd(int number) {
        if (number < 0){
            return false;
        }
        if (number % 2 == 0){
            return false;
        }
        return true;
    }

    public static int sumOdd(int start, int end) {
        int sum=0;
        if ((start > end) || ((start < 1) || (end < 1))){
            return -1;
        }
        for (int i=start; i<=end; i++){
            if(isOdd(i)){
                sum+=i;
            }
        }
        return sum;
    }
}