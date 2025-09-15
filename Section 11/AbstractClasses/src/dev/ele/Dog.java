package dev.ele;

public class Dog extends Mammal {
    private String earShape;
    private String tailShape;

    public Dog(String type, String size, double weight, String earShape, String tailShape) {
        super(type, size, weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public void move(Speed speed) {
        // System.out.print(this.getSize() + " " + this.type + " is ");
        if (speed.equals(Speed.FAST)) {
            System.out.println(this.getExplicitType() + " is running.");
        } else {
            System.out.println(this.getExplicitType() + " is walking.");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds all year round");
    }

    @Override
    public void makeNoise() {
        if (this.type == "Wolf") {
            System.out.print("Howling! ");
        } else {
            System.out.print("Woof! ");
        }
    }

}