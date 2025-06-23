public class SpeedConverter{
    public static void main(String[] args) {
        printConversion(95.75);
    }

    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour>= 0){
            return (long)Math.round(kilometersPerHour/1.609);
        }
        return (long)-1;
    }

    public static void printConversion(double kilometersPerHour){
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if (kilometersPerHour < 0){
            System.out.print("Invalid Value");
        } else {
            System.out.print(kilometersPerHour+" km/h = " +milesPerHour+" mi/h");
        }
    }
}