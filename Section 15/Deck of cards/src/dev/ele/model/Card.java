package dev.ele.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Face face;
    private final int rank;

    private Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
        this.rank = face.getRank();
    }

    private Card(Suit suit, int rank) {
        this.suit = suit;
        this.face = Face.getFaceFromRank(rank);
        this.rank = rank;
    }

    @Override
    public int compareTo(Card other) {
        return comparisonValue(this).compareTo(comparisonValue(other));
    }

    private String comparisonValue(Card c) {
        return c.rank + " " + c.getSuitChar();
    }

    public char getSuitChar() {
        return suit.getImage();
    }

    public String getFaceValue() {
        return face.getFaceValue();
    }

    public int getRank() {
        return rank;
    }

    public static Card getNumericCard(Suit suit, int rank) {
        if (rank >= 0 && rank <= 12) {
            return new Card(suit, rank);
        }
        System.err.println(rank + " is an invalid rank");
        return null;
    }

    public static Card getFaceCard(Suit suit, Face face) {
        return new Card(suit, face);
    }

    public static List<Card> getStandardDeck() {
        List<Card> deck = new ArrayList<>();
        for (Face f : Face.values()) {
            for (Suit s : Suit.values()) {
                deck.add(new Card(s, f));
            }
        }
        return deck;
    }

    public static void printCards(List<Card> cards) {
        printCards("Current Deck", cards, 4);
    }

    public static void printCards(String description, List<Card> cards, int rowCount) {
        System.out.println(description);
        int maxCardsPerRow = cards.size() / rowCount;
        maxCardsPerRow = cards.size() % rowCount == 0 ? maxCardsPerRow : maxCardsPerRow + 1;
        int i = 0;
        for (Card c : cards) {
            System.out.print(c + " ");
            i++;
            if (i >= maxCardsPerRow) {
                System.out.println();
                i = 0;
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "%s%c(%d)".formatted(getFaceValue(), getSuitChar(), getRank());
    }

    // the equals signature takes in an object
    @Override
    public boolean equals(Object other) {
        if (this == other) {// check reference equality
            return true;
        }
        if (other == null || getClass() != other.getClass()) {// Type check
            return false;
        }
        Card o = (Card) other;// Safe casting
        return this.getFaceValue().equals(o.getFaceValue()) && this.getRank() == o.getRank()
                && this.getSuitChar() == o.getSuitChar();
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face, rank);
    }

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage() {
            int unicodeInt = switch (this) {
                case SPADE -> 9824;
                case CLUB -> 9827;
                case HEART -> 9829;
                case DIAMOND -> 9830;
                default -> 0;
            };
            return Character.toChars(unicodeInt)[0];
        }
    }

    public enum Face {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        public String getFaceValue() {
            String value = switch (this) {
                case TWO -> "2";
                case THREE -> "3";
                case FOUR -> "4";
                case FIVE -> "5";
                case SIX -> "6";
                case SEVEN -> "7";
                case EIGHT -> "8";
                case NINE -> "9";
                case TEN -> "10";
                case JACK -> "J";
                case QUEEN -> "Q";
                case KING -> "K";
                case ACE -> "A";
                default -> "";
            };
            return value;
        }

        public int getRank() {
            String faceValue = this.getFaceValue();
            int value = switch (faceValue) {
                case "J" -> 9;
                case "Q" -> 10;
                case "K" -> 11;
                case "A" -> 12;
                default -> Integer.valueOf(faceValue) - 2;
            };
            return value;
        }

        static Face getFaceFromRank(int rank) {
            Face rankFace = switch (rank) {
                case 0 -> Face.TWO;
                case 1 -> Face.THREE;
                case 2 -> Face.FOUR;
                case 3 -> Face.FIVE;
                case 4 -> Face.SIX;
                case 5 -> Face.SEVEN;
                case 6 -> Face.EIGHT;
                case 7 -> Face.NINE;
                case 8 -> Face.TEN;
                case 9 -> Face.JACK;
                case 10 -> Face.QUEEN;
                case 11 -> Face.KING;
                case 12 -> Face.ACE;
                default -> Face.TWO;
            };
            return rankFace;
        }
    }
}