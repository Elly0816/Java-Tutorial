public class doWhile{
    public static void main(String[] args){
        // //Regular for loop
        // for (int i=1; i<=5; i++){
        //     System.out.println(i);
        // }
        
        // System.out.println("\n");
        
        // //regular while loop
        // int i=1;
        // while (true){
        //     System.out.println(i);
        //     i++;
        //     if (i>5){
        //         break;
        //     }
        // }
        
        // System.out.println("\n");

        // //do while loop
        // int j=1;
        // do {
        //     System.out.println(j);
        //     j++;
        // } while (j<=5);
        // int number = 24;
        // for (int i=5; i<=20; i++){
        // }



        // int i=5;
        // int evenTotal = 0;
        // int oddTotal = 0;
        // while (i<=20){
        //     if (isEvenNumber(i)){
        //         evenTotal++;
        //         System.out.println(i);
        //     } else {
        //         oddTotal++;
        //     }
        //     if (evenTotal >= 5){
        //         break;
        //     }
            
        //     i++;
        // }

        // System.out.println("Total of odd: " +oddTotal+ "\nTotal of even: " +evenTotal);

        int number = 1234;
        System.out.println(sumDigits(number));
    }

    public static boolean isEvenNumber(int number){
        if (number % 2 == 0){
            return true;
        }
        return false;
    }

    public static int sumDigits(int number) {
        if (number < 0){
            return -1;
        }
        
        if ((number >= 0) && (number <10)){
            return number;
        }

        int sum=0;

        /*
            modulus operation between the number and ten
            add the result to the sum
            cast the division of the number and the ten to an int and save as the new number
            do it until the number is equal to zero
        */
        // do {
        //     sum += number % 10;
        //     number = (int) (number/10);
        // } while (number > 0);

        while (number > 0){
            sum += (number % 10);
            number = (int) (number/10);
        }

        return sum;
    }
}