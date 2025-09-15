package dev.ele;

public abstract class Mammal extends Animal {

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(Speed speed) {
        System.out.print(getExplicitType() + " ");
        System.out.println(speed.equals(Speed.FAST) ? "runs" : "walks");
    }

    public abstract void shedHair();

    // @Override
    // public
}