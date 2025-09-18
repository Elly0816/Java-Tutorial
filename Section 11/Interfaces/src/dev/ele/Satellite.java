package dev.ele;

public class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
        transition("Taking off");
        // stage = stage.getNextStage();
    }

    @Override
    public void land() {
        transition("Landing");
        // System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
        // System.out.println(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates are being recorded");
    }

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved!");
    }

    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }

}