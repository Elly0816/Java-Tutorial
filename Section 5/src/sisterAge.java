public class sisterAge{
    public static void main(String[] args) {
        int age = sisterAgeNow(8, 25);
        System.out.print("Your sister is " +age+ " years old now.");
    }

    public static int sisterAgeNow(int ageThen, int ageNow){
        /*
         my sister was double my age then
         what is her age now
        */

        // int sisThen = 2*ageThen;
        // int difference = sisThen - ageThen;
        // int sisNow = ageNow + difference;

        // return sisNow;
        return ageNow + ((2*ageThen) - ageThen);

    }
}