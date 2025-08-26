public class Main {

    public static void main(String[] args) {

        // String desc = "Generic Car";
        // String[] carsTypes = { null, "electric", "gas powered", "hybrid" };

        // for (int i = 0; i < carsTypes.length; i++) {
        // Car newCar = Car.getCar(carsTypes[i], desc);
        // // System.out.printf("%n");
        // Car.printCar(newCar);
        // System.out.printf("%n");
        // runRace(newCar);
        // System.out.printf("%n%n");
        // }

        Car ferrari = new GasPoweredCar("2025 red Ferrari 598 GTS", 340, 1.5, 10, 8);
        Car tesla = new ElectricCar("2025 Tesla Model-X", 300, 0.75, 450, 4500);
        Car porsche = new HybridCar("2025 Porsche 911 GT3", 330, 1.1, 7, 8, 2000);
        Car toyota = new Car("2025 Lexus GS", 225, 3.2);

        Car[] cars = { ferrari, tesla, porsche, toyota };
        for (int i = 0; i < cars.length; i++) {
            // Car newCar = Car.getCar(cars[i], desc);
            // System.out.printf("%n");
            Car.printCar(cars[i]);
            System.out.printf("%n");
            runRace(cars[i]);
            System.out.printf("%n%n");
        }
    }

    public static void runRace(Car car) {
        car.drive();
    }

}