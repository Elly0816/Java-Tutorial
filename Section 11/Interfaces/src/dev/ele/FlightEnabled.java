package dev.ele;

public interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();

    void land();

    void fly();

    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = stage.getNextStage();
        System.out.printf("Transitioning from %s to %s%n", stage.name(), nextStage.name());
        return nextStage;
    }

}