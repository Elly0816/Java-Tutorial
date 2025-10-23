package dev.ele;

import dev.ele.model.Theatre;
import dev.ele.model.Theatre.Seat;

public class Main {
    public static void main(String[] args) {
        Theatre skyWatch = new Theatre("SkyWatch", 10, 70);

        System.out.println(skyWatch);

        skyWatch.printSeatMap();

        // skyWatch.printReservedSeats();

        bookSeats(skyWatch, 6, 'C', 'F', 2, 7);

        bookSeat(skyWatch, 'D', 4);

        bookSeat(skyWatch, 'D', 4);

        bookSeat(skyWatch, 'E', 8);

        bookSeat(skyWatch, 'D', 7);

        bookSeat(skyWatch, 'E', 2);

        bookSeats(skyWatch, 10, 'F', 'g', 2, 7);
        bookSeat(skyWatch, 'E', 2);
        bookSeats(skyWatch, 5, 'E', 'E', 3, 7);
        bookSeats(skyWatch, 3, 'D', 'D', 1, 4);

    }

    private static void bookSeat(Theatre theatre, char row, int number) {
        Seat seat = theatre.reserveSeat(row, number);
        theatre.printSeatMap();
    }

    private static void bookSeats(Theatre theatre, int numberOfReservations, char rFrom, char rTo, int sFrom, int sTo) {
        theatre.reserveSeats(numberOfReservations, rFrom, rTo, sFrom, sTo);
        theatre.printSeatMap();
    }

    private static void printSeats(Theatre theatre) {
        theatre.printSeatMap();
    }

    private static void printReservedSeats(Theatre theatre) {
        theatre.printReservedSeats();
    }
}