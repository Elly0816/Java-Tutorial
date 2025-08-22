public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal("Generic Animal", "Huge", 400);
        doAminalStuff(animal, "slow");

        Dog golden = new Dog("Golden Retriever", 65, "Floppy", "Swimmer");
        doAminalStuff(golden, "Slow");
        Dog gsd = new Dog("GSD", 70);
        gsd.makeNoise();
        // Dog dog = new Dog();
        doAminalStuff(gsd, "fast");

        Dog yorkie = new Dog("Yorkie", 12);
        doAminalStuff(yorkie, "fast");

        Dog grey = new Dog("Wolf", 85);
        doAminalStuff(grey, "fast");

        Fish goldie = new Fish("Goldfish", 3, 3, 2);
        doAminalStuff(goldie, "fast");

    }

    public static void doAminalStuff(Animal animal, String speed) {
        animal.move(speed);
        animal.makeNoise();
        System.out.println(animal);
        System.out.println("_ _ _ _");
    }
}