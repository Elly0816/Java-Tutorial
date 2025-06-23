import java.util.Scanner;

public class Input{
    public static void main(String[] args) {
        
        minMax();
    }


    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("What is your name?\n");
        System.out.println("Hi " +name+ ", Thanks for taking the course");    
        int yearOfBirth = Integer.parseInt(System.console().readLine("What year were you born " +name+ "?\n"));
        int age = currentYear-yearOfBirth;
        // System.out.println("Hi " +name+ ", You are "+age+" years old");    
        return "You are "+age+" years old " +name;
    }
    
    public static String getInputFromScanner(int currentYear) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.nextLine();
        System.out.println("Hi " +name+ ", Thanks for taking the course");    
        System.out.println("What year were you born " +name+ "?");
        int yearOfBirth = Integer.parseInt(sc.nextLine());
        while ((yearOfBirth > currentYear) || ((currentYear - yearOfBirth) > 125) || yearOfBirth < 0){
            System.out.println("You can't have been born in the year "+yearOfBirth+ " " +name+
            ", Please enter a valid year of birth:");
            yearOfBirth = Integer.parseInt(sc.nextLine());
        }
        int age = currentYear-yearOfBirth;    
        sc.close();
        return "You are "+age+" years old " +name;
    }

    public static void sumOfNumbers() {
        Scanner sc = new Scanner(System.in);
        double sum=0;
        double number=0;
        for (int i=1; i<=5; i++){
            Boolean isValid = false;
            System.out.println("Enter a number:");
            String numberString = sc.nextLine();
            while(!isValid){
                try {
                    isValid = true;
                    number = Double.parseDouble(numberString);
                } catch (Exception NumberFormatException) {
                    isValid = false;
                    System.out.println("Enter a valid number:");
                    numberString = sc.nextLine();
                }
            }
            sum += number;

        }
        sc.close();
        
        System.out.println("The total of the 5 numbers is: "+sum);
        
    }

    public static void minMax() {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        boolean isContinue = true;
        Scanner sc = new Scanner(System.in);
        while(isContinue){
            System.out.println("Enter a number: ");
            try{
                Double num = Double.parseDouble(sc.nextLine());
                if (num>max){
                    max = num;
                }
                if (num < min){
                    min = num;
                }
                
            } catch (Exception numberFormaException){
                isContinue=false;
            }
        }
        if ((max == Double.MIN_VALUE) || (min == Double.MAX_VALUE)){
            System.out.println("You entered no valid number");
        } else {
            System.out.println("The max value entered was: "+max+ 
            " and the min value entered was: "+min);
        }
        sc.close();
    }

    
}