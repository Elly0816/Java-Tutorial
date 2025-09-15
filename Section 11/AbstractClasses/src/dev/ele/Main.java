package dev.ele;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Animal animal = new Animal("animal", "big", 100);
        Dog dog = new Dog("Wolf", "big", 120, "Sharp", "Perky");
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Fish("Goldfish", "small", 0.75));
        animals.add(new Dog("Golden Retriever", "large", 75, "Droopy", "Curved"));
        animals.add(new Fish("Mackarel", "large", 5.75));
        animals.add(new Dog("GSD", "large", 60, "Pointy", "Straight"));
        animals.add(new Fish("Cod", "large", 5.75));
        animals.add(new Dog("Staffordshire bulldog", "medium", 45, "Flappy", "Straight"));
        animals.add(new Fish("Salmon", "medium", 3.75));
        animals.add(new Dog("Wolf", "Large", 93, "Pointy", "Straight"));
        animals.add(new Horse("Clydesdale", "Large", 530));

        for (Animal a : animals) {
            doAnimalStuff(a);
            System.out.println(a.getExplicitType());
        }

    }

    private static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move(Speed.SLOW);
        if (animal instanceof Mammal mammal) {
            mammal.shedHair();
        }
    }
}