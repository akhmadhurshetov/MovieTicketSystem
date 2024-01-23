package org.example;

public class Seat {
    private int seatId;
    private String row;
    private int number;
    private boolean isAvailable;

    // Constructor
    public Seat(int seatId, String row, int number, boolean isAvailable) {
        this.seatId = seatId;
        this.row = row;
        this.number = number;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}