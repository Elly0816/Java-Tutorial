package dev.ele;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DayOfTheWeek weekday = DayOfTheWeek.TUES;
        System.out.println(weekday);

        System.out.printf("Name is %s, Ordinal value = %d%n", weekday.name(), weekday.ordinal());

        for (int i = 0; i < 21; i++) {
            DayOfTheWeek randomDay = getRandomDay();
            switchDayOfWeek(randomDay);
            // System.out.printf("Name is %s, Ordinal value is %d%n", randomDay.name(),
            // randomDay.ordinal());

            // if (randomDay == DayOfTheWeek.FRI) {
            // System.out.println("The day is a Friday!");
            // }
        }

        for (Topping t : Topping.values()) {
            System.out.println(t.name() + "'s price: " + t.getPrice());
        }
    }

    public static void switchDayOfWeek(DayOfTheWeek weekday) {
        int day = weekday.ordinal() + 1;
        switch (weekday) {
            case WED -> System.out.println("Wednesday is day " + day);
            case SAT -> System.out.println("Saturday is day " + day);
            default -> System.out
                    .println(weekday.name().charAt(0) + weekday.name().substring(1).toLowerCase() + "day is day" + day);
        }
    }

    public static DayOfTheWeek getRandomDay() {
        int randomInt = new Random().nextInt(7);
        DayOfTheWeek[] allDays = DayOfTheWeek.values();
        return allDays[randomInt];

    }
}