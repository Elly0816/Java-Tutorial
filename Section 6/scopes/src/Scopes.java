public class Scopes{
    public static void main(String[] args) {
        // Scopes myObj = new Scopes(5);
        // System.out.println("This is the name of the class: "+myObj.className);
    
        for (int i=0; i<=50; i++){
            System.out.println("\nThe factors of " +i+ " are:");
            printFactors(i);
        }
    }

    // public int className;

    // public Scopes(int name){
    //     className = name;
    // }

    public static boolean isPalindrome(int number) {
        
        if (number < 0){
            number *= (-1);
        }

        int hold = number;
        int reverse = 0;

        while(hold != 0){
            int remainder = hold%10;
            reverse = (reverse*10)+remainder;
            hold /=10;
        }
        return (reverse==number);
    }


    public static int sumFirstAndLastDigit(int number) {
        if(number < 0){
            return -1;
        }

        
        // if ((number >= 0) && (number < 10)){
        //     return number;
        // }

        int first = 0;
        int last = number%10;

        int hold = number;


        while(hold >0){
            first = hold%10;
            hold /= 10;
        }

        return first+last;
    }

    public static int getEvenDigitSum(int number){
        if(number < 0){
            return -1;
        }

        int hold = number;
        int sum=0;

        while(hold > 0){
            int remainder = hold%10;
            if (remainder%2 == 0){
                sum+=remainder;
            }
            hold /= 10;
        }
        return sum;
    }

    public static boolean hasSharedDigit(int  num1, int num2){
        if (((num1<10) || (num1>99)) || ((num2<10) || (num2>99))){
            return false;
        }

        int num1First=num1/10;
        int num2First=num2/10;
        int num1Remainder = num1%10;
        int num2Remainder = num2%10;

        return ((num1First==num2First) || (num1First==num2Remainder) || (num1Remainder==num2Remainder) || (num1Remainder==num2First));
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (((num1<10) || (num2<10) || (num3<10)) || ((num1>1000) || (num2>1000) || (num3>1000))){
            return false;
        }

        int last1 = num1%10;
        int last2 = num2%10;
        int last3 = num3%10;

        return ((last1==last2) || (last2==last3) || (last1==last3));
    }

    public static boolean isValid(int number) {
        return ((number >= 10) && (number <= 1000));
    }

    public static void printFactors(int number) {
        if (number < 1){
            System.out.println("Invalid Value");
        } else {
            for (int i=1; i<=number; i++){
                if (number % i == 0){
                    System.out.print(i+"\s");
                }
            }
        }
    }

    public static int getGreatestCommonDivisor(int num1, int num2) {
        if (num1<10 || num2<10){
            return -1;
        }
        
        int maxFactor = 1;
        int min = (num1<=num2) ? num1 : num2;
        int i=1;

        while(i<=min){
            if ((num1 % i == 0) && (num2 % i == 0)){
                maxFactor = i;
            }
            i++;
        }
        return maxFactor;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1){
            return false;
        }
        
        int sum = 0;
        int i = 1;
        while(i < number){
            if (number%i == 0){
                sum+=i;
            }
            i++;
        }
        return sum==number;
    }
} 