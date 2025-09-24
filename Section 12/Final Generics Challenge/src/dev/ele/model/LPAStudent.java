package dev.ele.model;

import dev.ele.util.Fields;

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

    @Override
    public boolean matchFieldValue(Fields field, String value) {
        if (field.equals(Fields.COMPLETION_PERCENTAGE)) {
            Double valueToReturn;
            try {
                valueToReturn = Double.valueOf(value);
            } catch (NumberFormatException e) {
                return false;
            }
            return Double.valueOf(this.getPercentComplete()).equals(valueToReturn);
        } else {
            return super.matchFieldValue(field, value);
        }
    };

}