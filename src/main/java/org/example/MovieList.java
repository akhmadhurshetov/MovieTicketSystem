package org.example;

public class MovieList {
    private String image; // URL or path to the image
    private String title;
    private String shortDescription;
    private String longDescription;
    private boolean isActive;
    private double price;
    private String location; // Assume this is a string, but could be an object depending on requirements
    private double rating;
    private int id;

    // Constructor
    public MovieList(String image, String title, String shortDescription, String longDescription,
                     boolean isActive, double price, String location, double rating) {
        this.image = image;
            this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.isActive = isActive;
        this.price = price;
        this.location = location;
        this.rating = rating;
    }

    // Getters and Setters
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}