package dev.ele;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);

        hellos.forEach((s) -> System.out.println(s + ", hashcode: " + s.hashCode()));

        Set<String> mySet = new HashSet<>(hellos);
        System.out.println("mySet = " + mySet);
        System.out.println("# of elements = " + mySet.size());

        for (String value : mySet) {
            System.out.print(value + ": ");
            for (int i = 0; i < hellos.size(); i++) {
                if (value == hellos.get(i)) {
                    System.out.print("is the same reference as " + hellos.get(i) + " at index " + i + ", ");
                }
            }
            System.out.println();
        }

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        // PlayingCard aceHearts2 = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        // PlayingCard kingClubs2 = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");
        // PlayingCard queenSpades2 = new PlayingCard("Spades", "Queen");

        // List<PlayingCard> cards = Arrays.asList(aceHearts, aceHearts2, kingClubs,
        // kingClubs2, queenSpades,
        // queenSpades2);
        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);

        cards.forEach((c) -> System.out.println(c + ": " + c.hashCode()));

        Set<PlayingCard> deck = new HashSet<>();

        for (PlayingCard c : cards) {
            if (!deck.add(c)) {
                System.out.println("Found a duplicate for " + c);
            }
        }
        System.out.println(deck);

    }
}