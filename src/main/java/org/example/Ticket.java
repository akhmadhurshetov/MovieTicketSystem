package org.example;

public class Ticket {
    private int ticketId;
    private int customerId; // Reference to Customer
    private int screeningId; // Reference to Screening
    private int seatId; // Reference to Seat
    private double price;

    // Constructor
    public Ticket(int ticketId, int customerId, int screeningId, int seatId, double price) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.screeningId = screeningId;
        this.seatId = seatId;
        this.price = price;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

