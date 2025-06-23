public class MethodOverloading{
    public static void main(String[] args){
        System.out.println(convertToCentimeters((int)convertToCentimeters(5, 9)));
    }

    public static double convertToCentimeters(int heightInInches){
        System.out.println(heightInInches+" inches to centimeters is: "+heightInInches*2.54+" cm");
        return heightInInches*2.54;
    }

    public static double convertToCentimeters(int feet, int inches){
        System.out.println("You entered "+feet+" feet and "+inches+" inches");
        return (feet*12) + inches;
    }
}