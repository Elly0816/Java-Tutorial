package dev.ele;

import java.util.Objects;

public class PlayingCard {
    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
        this.internalHash = suit.equalsIgnoreCase("hearts") ? 11 : 12;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    @Override
    public boolean equals(Object other) {
        System.out.println("Checking playing cards equality");
        // return true;
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        PlayingCard that = (PlayingCard) other;
        return this.face.equals(that.face) && this.suit.equals(that.suit);

    }

    @Override
    public int hashCode() {
        // return internalHash;
        return Objects.hash(face, suit);
    }

}