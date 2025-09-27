package dev.ele.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;
    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.burger = new Burger("regular", 2.5);
        this.drink = new Item("coke", "drink", 1.5);
        // System.out.println(drink.name);
        this.side = new Item("fries", "side", 2.0);
        this.conversionRate = conversionRate;
    }

    public double getTotal() {
        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    public void addToppings(String... selectedToppings) {
        burger.addToppings(selectedToppings);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%20s$%.2f%n".formatted(burger, drink, side, "Total Due: ", getTotal());
    }

    // Generic Item class
    private class Item {
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        public String toString() {
            return "%-10s%-5s $%-5.2f".formatted(type, name, getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }

    }

    // Burger class
    private class Burger extends Item {
        private List<Item> toppings;

        public Burger(String name, double price) {
            super(name, "Burger", price);
            toppings = new ArrayList<>();
        }

        public Burger(String name) {
            this(name, 5.0);
        }

        public double getPrice() {
            double toppingsPrice = 0;
            for (var t : toppings) {
                toppingsPrice += t.price;
            }
            return super.price + toppingsPrice;
        }

        private void addToppings(String... toppings) {
            for (var t : toppings) {
                try {
                    Topping topping = Topping.valueOf(t.toUpperCase());
                    this.toppings.add(new Item(topping.name(), "topping", topping.getPrice()));
                } catch (IllegalArgumentException e) {
                    System.out.println(t + " is not available!");
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder toppingsString = new StringBuilder();
            for (var t : toppings) {
                toppingsString.append("%s%n".formatted(t.toString().strip()));
            }
            return super.toString() + "\n" + toppingsString.toString().toUpperCase();
        }

        // Topping enum
        private enum Topping {
            CHEESE, TOMATO, LETTUCE, BACON, PICKLES;

            private double getPrice() {
                return switch (this) {
                    case CHEESE -> 0.75;
                    case PICKLES -> 0.25;
                    case TOMATO -> 0.5;
                    case BACON -> 1.0;
                    case LETTUCE -> 0.0;
                    default -> 0;
                };
            }
        }
    }

}