package dev.ele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = new Bird();
        FlightEnabled flier = new Bird();
        Trackable tracked = new Bird();

        // animal.move();
        // bird.move();

        // flier.takeOff();
        // flier.fly();
        // tracked.track();
        // flier.land();

        inFlight(flier);

        inFlight(new Jet());

        Trackable truck = new Truck();
        truck.track();

        // double KmToMiles = FlightEnabled.KM_TO_MILES * 20;
        double Km = 320;
        // System.out.println(Km + "km to miles is: " + FlightEnabled.KM_TO_MILES * Km +
        // "miles");
        System.out.printf("%.2fKM is %.2fMiles%n", Km, Km * FlightEnabled.KM_TO_MILES);

        Satellite nav2 = new Satellite();
        getOrbit(nav2);

        ArrayList<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(nav2);
        fliers.add(new DragonFly("Dragonicanus elevatus", "West African"));
        fliers.add(new Bird());
        fliers.add(new Jet());
        // for (FlightEnabled f : fliers) {
        // inFlight(f);
        // }

        List<FlightEnabled> betterFliers = new LinkedList<>();
        betterFliers.add(nav2);
        betterFliers.add(new DragonFly("Dragonicanus elevatus", "West African"));
        betterFliers.add(new Bird());
        betterFliers.add(new Jet());

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);
    }

    private static void getOrbit(Satellite s) {
        s.takeOff();
        s.fly();
        s.track();
        s.achieveOrbit();
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void triggerFliers(ArrayList<FlightEnabled> fliers) {
        for (var f : fliers) {
            f.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnabled> fliers) {
        for (var f : fliers) {
            f.fly();
        }
    }

    private static void landFliers(List<FlightEnabled> fliers) {
        for (var f : fliers) {
            f.land();
        }
    }
}