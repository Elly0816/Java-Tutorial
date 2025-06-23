public class SecondsAndMinutes{
    public static void main (String[] args){
        System.out.println(getDurationString(-5000));
    }

    public static String getDurationString(int seconds){
        if (seconds < 0){
            return "Invalid Input for seconds: "+seconds+"\nShould be a positive value.";
        }
        if (seconds < 60){
            return "00h 00m "+seconds+"s";
        }
        int minutes = (int) (seconds/60);
        seconds = seconds%60;
        return getDurationString(minutes, seconds);
    }

    public static String getDurationString(int minutes, int seconds){
        if ((minutes < 0) || ((seconds < 0) || (seconds > 59))){
            return "Invalid Input for minutes: "+minutes+" or seconds: "+seconds+
            "\nThey should both be positive.";
        }
        int hours = (int)(minutes/60);
        minutes = minutes%60;
        return ""+hours+"h "+minutes+"m "+seconds+"s";
    }
}