package org.example;

public class Customer {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    // Constructor
    public Customer(String username, String password, String name, String email, String phoneNumber) {
        this.username = username;
        this.password = password; // Note: Password should be securely hashed
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; } // Note: Hash the password before setting it
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}