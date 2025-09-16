package dev.ele;

import java.util.ArrayList;

public class Store {
    public static ArrayList<ProductForSale> products = new ArrayList<>();
    public static ArrayList<OrderItem> order = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Running main in Store");
        ConsumerElectronic laptop = new ConsumerElectronic("Razer", "Blade 2025", "Laptop", 3599.99,
                "Gaming/Workstation Laptop");
        addProduct(laptop);
        ConsumerElectronic phone = new ConsumerElectronic("Apple", "iPhone 17 pro", "Mobile Phone", 1599.99,
                "iPhone mobile Phone");
        addProduct(phone);
        ConsumerElectronic headPhone = new ConsumerElectronic("Sony", "XM 5000 2025", "HeadPhones", 799.99,
                "XM 5000 with SOTA noise cancellation and transparency mode, unmatched call quality, and best audio quality on the market");
        addProduct(headPhone);
        Clothing shirt = new Clothing("Balmain", 2025, OccasionType.CASUAL, Size.L, "shirt", 239.99,
                "High quality island shirt for the summer");
        addProduct(shirt);
        Clothing shorts = new Clothing("Fendi", 2025, OccasionType.CASUAL, Size.M, "Shorts", 199.99,
                "High quality short for the summer");
        addProduct(shorts);
        Clothing shoe = new Clothing("Tom Ford", 2025, OccasionType.CASUAL, Size.L, "Shoe", 299.99,
                "High quality loafers");
        addProduct(shoe);
        BuildingMaterial lumber = new BuildingMaterial("Wood", true, "Lumber", 15,
                "High quality oak lumber used for building");
        addProduct(lumber);
        BuildingMaterial tile = new BuildingMaterial("Ceramic", true, "Tile", 20,
                "High quality ceramic tiles for bathroom and kitchen");
        addProduct(tile);
        BuildingMaterial steel = new BuildingMaterial("Steel", true, "Steel", 15,
                "High quality steel for reinforcement of various structures");
        addProduct(steel);
        VideoGame eafc25 = new VideoGame("EA", "Sport", false, Platform.PS5, "PS5 sport game", 69.99,
                "EA's latest offering of the world's most popular sports game, EAFC25");
        addProduct(eafc25);
        VideoGame gta6 = new VideoGame("RockStar Games", "Open World", true, Platform.PC, "PC Open World game", 99.99,
                "Rockstar's long awaited latest edition of the GTA franchise. Massive open world action adventure");
        addProduct(gta6);

        printProducts();

        for (ProductForSale p : products) {
            int quantity = 0;
            if (p instanceof Clothing) {
                quantity = 3;
            } else if (p instanceof ConsumerElectronic) {
                quantity = 1;
            } else if (p instanceof VideoGame) {
                quantity = 1;
            } else if (p instanceof BuildingMaterial) {
                quantity = 20;
            }
            addItem(new OrderItem(quantity, p));
        }

        printOrderedItems();

        printPrices();
        printTotalOrder();

    }

    public static void addItem(OrderItem item) {
        order.add(item);
    }

    public static void printPrices() {
        for (OrderItem o : order) {
            o.product().printPricedItem(o.quantity());
            addNewLine();
        }
        addNewLine();
    }

    public static void printOrderedItems() {
        for (OrderItem o : order) {
            System.out.println("QUANTITY: " + o.quantity());
            o.product().showDetails();
            addNewLine();
        }
        addNewLine();
    }

    public static void addProduct(ProductForSale product) {
        products.add(product);
    }

    public static void printProducts() {
        for (ProductForSale p : products) {
            p.showDetails();
            addNewLine();
        }
        addNewLine();
    }

    public static void printTotalOrder() {
        double total = 0;
        for (OrderItem o : order) {
            total += o.product().getSalesPrice(o.quantity());
        }
        System.out.printf("The total price for the order is: %.2f", total);
        System.out.println();
        addNewLine();
    }

    public static void addNewLine() {
        System.out.println("_".repeat(30));
    }

}