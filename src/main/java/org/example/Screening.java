package org.example;

import java.time.LocalDateTime;

public class Screening {
    private int screeningId;
    private LocalDateTime dateTime;
    private int movieId; // Reference to Movie
    private int theaterId; // Reference to Theater

    // Constructor
    public Screening(int screeningId, LocalDateTime dateTime, int movieId, int theaterId) {
        this.screeningId = screeningId;
        this.dateTime = dateTime;
        this.movieId = movieId;
        this.theaterId = theaterId;
    }

    // Getters and Setters
    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }
}
