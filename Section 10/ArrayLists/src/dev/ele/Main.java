package dev.ele;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // List<GroceryItem> groceryArray = new ArrayList<GroceryItem>();
        // groceryArray.add(new GroceryItem("Milk"));
        // groceryArray.add(new GroceryItem("Apples", "PRODUCE", 6));
        // System.out.println(groceryArray);
        // GroceryItem[] groceryArray = new GroceryItem[3];
        // groceryArray[0] = new GroceryItem("Milk");
        // groceryArray[1] = new GroceryItem("Apples", "PRODUCE", 6);
        // groceryArray[2] = new GroceryItem("Oranges", "PRODUCE", 5);
        // System.out.println(Arrays.deepToString(groceryArray));

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("Oranges", "PRODUCE", 5));
        groceryList.add(0, new GroceryItem("Apples", "PRODUCE", 5));
        System.out.println(groceryList);
        groceryList.set(0, new GroceryItem("Bananas", "PRODUCE", 12));
        System.out.println(groceryList);
        groceryList.remove(3);
        System.out.println(groceryList);
    }
}