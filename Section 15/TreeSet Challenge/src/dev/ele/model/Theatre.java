package dev.ele.model;

import java.security.InvalidParameterException;
import java.util.Collections;
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
        if (name == null) {
            throw new Error("Name cannot be null");
        }
        if (numberOfRows < 1 || totalNumberOfSeats < 1) {
            throw new InvalidParameterException(
                    "You have to have at least 1 total number of seats and at least one number of rows");
        }
        theatreName = name;
        this.seatsInRow = totalNumberOfSeats / numberOfRows;
        generateSeats(numberOfRows);
    }

    private void generateSeats(int numberOfRows) {
        if (numberOfRows > 26 || numberOfRows < 1) {
            throw new InvalidParameterException("Invalid number of rows!");
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

    public boolean validateSeats(char rowFrom, char rowTo, int seatFrom, int seatTo) {
        if (!(Character.isAlphabetic(rowFrom) && Character.isAlphabetic(rowTo)) || rowFrom < seats.first().row
                || rowTo > seats.last().row) {
            System.err.println("Invalid rows");
            return false;
        }
        if (seatFrom < 1 || seatFrom > seatsInRow || seatTo > seatsInRow || seatTo < 1) {
            System.err.println("Invalid seat Numbers");
            return false;
        }
        return true;
    }

    public NavigableSet<Seat> reserveSeats(int numberOfReservations, char rowFromS, char rowToS, int seatFrom,
            int seatTo) {
        char rowFrom = Character.toUpperCase(rowFromS);
        char rowTo = (char) Math.min(Character.toUpperCase(rowToS), seats.last().row);

        if (!validateSeats(rowFrom, rowTo, seatFrom, seatTo)) {
            return null;
        }

        if (rowFrom > rowTo || (rowFrom <= rowTo && seatFrom > seatTo)) {
            System.out.println("Invalid seat order");
            return null;
        }

        int currRow = rowFrom;
        NavigableSet<Seat> candidateSeats = null;
        while (currRow <= rowTo) {
            NavigableSet<Seat> seatsInRow = seats.subSet(new Seat((char) currRow, seatFrom), true,
                    new Seat((char) currRow, seatTo), true);
            int count = 0;
            Seat start = null;
            for (var s : seatsInRow) {
                if (count >= numberOfReservations) {
                    break;
                }
                if (s.isReserved) {
                    count = 0;
                    start = null;
                    continue;
                }
                start = start == null ? s : start;
                count++;
            }
            if (count == numberOfReservations && start != null) {
                candidateSeats = seats.subSet(start, true, new Seat((char) currRow, start.number + count), false);
                break;
            }
            currRow++;
        }
        if (candidateSeats != null) {
            candidateSeats.forEach((s) -> reserveSeat(s.row, s.number));
            // candidateSeats.forEach(System.out::println);
        } else {
            System.out.println(
                    numberOfReservations + " seats unavailable from " + new Seat((char) rowFrom, seatFrom) + " to "
                            + new Seat((char) rowTo, seatTo));
        }
        return candidateSeats;
    }

    public Seat getSeat(char row, int number) {
        for (var s : seats) {
            if ((int) s.row > (int) row) {
                return null;
            }
            if (s.row == Character.toUpperCase(row) && number == s.number) {
                return s;
            }
        }
        return null;
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