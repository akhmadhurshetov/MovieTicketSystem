package org.example;

import java.time.LocalDate;

public class Ticket {
    private int movieId;
    private LocalDate date;
    private String time;
    private int numberOfTickets;
    private double totalPrice;

    // Constructor
    public Ticket(int movieId, LocalDate date, String time, int numberOfTickets, double totalPrice) {
        this.movieId = movieId;
        this.date = date;
        this.time = time;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    // Getters
    public int getMovieId() {
        return movieId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    // ... (Other methods, if any)
}