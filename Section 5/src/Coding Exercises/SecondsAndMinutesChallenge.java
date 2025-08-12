public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {
        int seconds = 4045;

        System.out.println("There are " + getDurationString(seconds) + " in " + seconds + " seconds");

        int minutes = 67;
        seconds = 25;

        System.out.println(
                "There are " + getDurationString(minutes, seconds) + " in " + minutes + " minutes and " + seconds
                        + " seconds.");

    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid number of seconds";
        }
        int minutes, remainingSeconds;
        minutes = seconds / 60;
        remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || (seconds < 0 || seconds > 59)) {
            return "Invalid input";
        }
        int hours, remainingMinutes, remainingSeconds;

        hours = minutes / 60;
        remainingMinutes = minutes % 60;

        remainingMinutes += seconds / 60;

        remainingSeconds = seconds % 60;

        String durationString = "" + hours + "h " + remainingMinutes + "m " + remainingSeconds + "s";

        return durationString;

    }
}