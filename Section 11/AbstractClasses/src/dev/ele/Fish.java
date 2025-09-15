package dev.ele;

public class Fish extends Animal {
    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(Speed speed) {
        if (speed.equals(Speed.SLOW)) {
            System.out.println(this.getExplicitType() + " lazily swimming");
        } else {
            System.out.println(this.getExplicitType() + " darting frantically");
        }
    }

    @Override
    public void makeNoise() {
        if (type.toLowerCase().equals("goldfish")) {
            System.out.println("swish");
        } else {
            System.out.println("splash");
        }
    }
}