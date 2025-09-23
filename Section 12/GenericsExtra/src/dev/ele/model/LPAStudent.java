package dev.ele.model;

public class LPAStudent extends Student {
    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);

    }

    public double getPercentComplete() {
        return percentComplete;
    }

    public String toString() {
        return super.toString() + "%13.2f%%".formatted(percentComplete);
    }

}