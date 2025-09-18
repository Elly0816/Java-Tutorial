package dev.ele;

public class Truck implements Trackable {

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates are being recorded");
    }
}