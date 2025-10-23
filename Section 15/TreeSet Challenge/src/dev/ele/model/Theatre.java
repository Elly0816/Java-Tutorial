package dev.ele.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

public class Theatre {

    private String theatreName;
    private int seatsInRow;
    private NavigableSet<Seat> seats = new TreeSet<>();
    // private Comparator<Seat> sorter = Comparator.comparing(Seat::getSeatNumber);
    // private NavigableSet<Seat> seats = new TreeSet<>(sorter);

    public Theatre(String name, int numberOfRows, int totalNumberOfSeats) {
        theatreName = name;
        this.seatsInRow = totalNumberOfSeats / numberOfRows;
        generateSeats(numberOfRows);
    }

    private void generateSeats(int numberOfRows) {
        if (numberOfRows > 26 || numberOfRows < 1) {
            System.err.println("Invalid number of seats!");
            return;
        }
        int start = (int) 'A';// unicode for A
        int end = start + numberOfRows;
        int i = start;
        while (i < end) {
            int j = 1;
            while (j <= seatsInRow) {
                Seat seat = new Seat((char) i, j++);
                seats.add(seat);
            }
            i++;
        }
    }

    public NavigableSet<Seat> getSeats() {
        return Collections.unmodifiableNavigableSet(seats);
    }

    public NavigableSet<Seat> getReservedSeats() {
        NavigableSet<Seat> reservedSeats = new TreeSet<>();
        for (var s : seats) {
            if (s.isReserved) {
                reservedSeats.add(s);
            }
        }
        return reservedSeats;
    }

    public Seat reserveSeat(char row, int number) {
        Seat seat = getSeat(row, number);
        if (seat == null) {
            System.out.println("Invalid seat");
            return null;
        }
        if (seat.isReserved) {
            System.out.println(seat + " not available");
            return null;
        }
        seat.setReservedStatus(true);
        System.out.println(seat + " has been reserved");
        return seat;
    }

    public NavigableSet<Seat> reserveSeats(int numberOfReservations, char rowFromS, char rowToS, int seatFrom,
            int seatTo) {
        char rowFrom = Character.toUpperCase(rowFromS);
        char rowTo = Character.toUpperCase(rowToS);
        if (!(Character.isAlphabetic(rowFrom) && Character.isAlphabetic(rowTo)) || rowFrom < seats.first().row
                || rowTo > seats.last().row) {
            System.err.println("Invalid rows");
            return null;
        }
        if (seatFrom < 1 || seatFrom > seatsInRow || seatTo > seatsInRow || seatTo < 1) {
            System.err.println("Invalid seat Numbers");
            return null;
        }
        Seat startSeat = new Seat(rowFrom, seatFrom);
        Seat endSeat = new Seat(rowTo, seatTo);
        NavigableSet<Seat> seatsCopy = new TreeSet<>(seats).subSet(startSeat, true, endSeat, true);
        seatsCopy.removeAll(getReservedSeats());
        if (seatsCopy.size() < numberOfReservations) {
            System.out.println("There are only " + seatsCopy.size() + " seats available");
            return null;
        }
        Seat[] seatsArray = seatsCopy.toArray(new Seat[seatsCopy.size()]);
        int start = 0;
        int i = start;
        List<Seat> candidateSeats = new ArrayList<>();
        while ((seatsArray.length - start >= numberOfReservations)
                && candidateSeats.size() < numberOfReservations && i < seatsArray.length) {
            // check if seats are neither on the same row nor have consecutive numbers
            if (i + 1 < seatsArray.length && (seatsArray[i].row != seatsArray[i + 1].row
                    || seatsArray[i].number + 1 != seatsArray[i + 1].number)) {
                // if (i + 1 < seatsArray.length && seatsArray[i].compareTo(seatsArray[i + 1]) >
                // 1) {
                start++;
                i = start;
                candidateSeats = new ArrayList<>();
                continue;
            }
            if (seatsArray[i].number > seatTo || seatsArray[i].number < seatFrom) {
                i++;
                continue;
            }
            candidateSeats.add(seatsArray[i]);
            i++;
        }
        if (candidateSeats.size() == numberOfReservations) {
            for (var s : candidateSeats) {
                reserveSeat(s.row, s.number);
            }
            return new TreeSet<>(candidateSeats);
        } else {
            System.out.println("Could not find enough contiguous seats");
            return null;
        }
    }

    public Seat getSeat(char row, int number) {
        Seat seat1 = new Seat(row, number);
        Seat seat2 = seats.last();
        NavigableSet<Seat> subset = seats.subSet(seat1, true, seat2, true);
        return subset.isEmpty() ? null : subset.first();
    }

    public Seat getSeat(Seat seat) {
        return getSeat(seat.row, seat.number);
    }

    public void printSeatMap() {
        printFormatter(seats, "Total Seats");
    }

    public void printReservedSeats() {
        NavigableSet<Seat> reservedSeats = getReservedSeats();
        if (reservedSeats.size() == 0) {
            System.out.println("There are no reserved seats");
            return;
        }
        printFormatter(reservedSeats, "Reserved Seats");
        // reservedSeats.forEach(System.out::println);
    }

    private void printFormatter(NavigableSet<Seat> seats, String text) {
        System.out.printf("%s----------%d %s----------%n", " ".repeat(seatsInRow * 2), seats.size(), text);
        int i = 1;
        for (var s : seats) {
            if (i % seatsInRow == 0) {
                System.out.print(s + "\n");
            } else {
                System.out.print(s);
            }
            i++;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "%s theatre has %d seats with %d seats in a row.%n".formatted(theatreName, seats.size(), seatsInRow);
    }

    public static class Seat implements Comparable<Seat> {
        private char row;
        private int number;
        private String seatNumber;
        private boolean isReserved;

        public Seat(char row, int number) {
            this.row = Character.toUpperCase(row);
            this.number = number;
            setSeatNumber();
        }

        private void setSeatNumber() {
            seatNumber = Character.toString(row) + String.format("%03d", number);
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public void setReservedStatus(boolean reserved) {
            this.isReserved = reserved;
        }

        // public boolean getReservedStatus() {
        // return this.isReserved;
        // }

        @Override
        public String toString() {
            return "%s%-8s ".formatted(seatNumber, isReserved ? "(R)" : "");
        }

        @Override
        public boolean equals(Object s) {
            if (this == s) {
                return true;
            }
            if (s == null || getClass() != s.getClass()) {
                return false;
            }

            Seat seat = (Seat) s;

            return seatNumber.equals(seat.seatNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(seatNumber);
        }

        @Override
        public int compareTo(Seat s) {
            return seatNumber.compareTo(s.seatNumber);
        }
    }

}