package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class MovieBookingApp extends Application {
    private ComboBox<MovieList> movieComboBox;
    private DatePicker datePicker;
    private ComboBox<String> timeComboBox;
    private Spinner<Integer> ticketSpinner;

    @Override
    public void start(Stage primaryStage) {
        List<MovieList> movies = DatabaseHelper.getMovies();
        for (MovieList movie : movies) {
            System.out.println(movie.getTitle()); // This should print the title of each movie
        }

        movieComboBox = new ComboBox<>();
        movieComboBox.getItems().addAll(movies);
        datePicker = new DatePicker();

        timeComboBox = new ComboBox<>();
        timeComboBox.getItems().addAll("10:00 AM", "01:00 PM", "04:00 PM", "07:00 PM", "10:00 PM"); // Example times

        ticketSpinner = new Spinner<>(1, 10, 1); // Assuming 1 to 10 tickets

        Label totalPriceLabel = new Label("Total Price: $0.00");
        movieComboBox.setOnAction(event -> updateTotalPrice(movieComboBox, ticketSpinner, totalPriceLabel));
        ticketSpinner.valueProperty().addListener((obs, oldVal, newVal) -> updateTotalPrice(movieComboBox, ticketSpinner, totalPriceLabel));

        Button bookButton = new Button("Book");
        bookButton.setOnAction(event -> handleBooking());

        VBox layout = new VBox(10, movieComboBox, datePicker, timeComboBox, ticketSpinner, totalPriceLabel, bookButton);
        Scene scene = new Scene(layout, 400, 300);

        primaryStage.setTitle("Movie Booking");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTotalPrice(ComboBox<MovieList> movieComboBox, Spinner<Integer> ticketSpinner, Label totalPriceLabel) {
    }

    private void handleBooking() {
        MovieList selectedMovie = movieComboBox.getValue();
        LocalDate selectedDate = datePicker.getValue();
        String selectedTime = timeComboBox.getValue();
        int numberOfTickets = ticketSpinner.getValue();

        // Validate input
        if (selectedMovie == null || selectedDate == null || selectedTime == null) {
            showAlert("Booking Error", "Please complete all selections.");
            return;
        }

        // Calculate total price
        double totalPrice = selectedMovie.getPrice() * numberOfTickets;

        // Create and save tickets
        try {
            for (int i = 0; i < numberOfTickets; i++) {
                Ticket ticket;
                ticket = new Ticket(selectedMovie.getId(), selectedDate, selectedTime, numberOfTickets, totalPrice);
                // Assuming you have a method to save a ticket to the database
                saveTicketToDatabase(ticket);
            }
            showAlert("Booking Confirmed", "Your booking has been confirmed!");
        } catch (Exception e) {
            showAlert("Booking Error", "Error processing your booking.");
        }
    }

    private void saveTicketToDatabase(Ticket ticket) {
        String sql = "INSERT INTO Tickets (movieId, date, time, numberOfTickets, totalPrice) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketsystem", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ticket.getMovieId());
            pstmt.setDate(2, Date.valueOf(ticket.getDate()));
            pstmt.setString(3, ticket.getTime());
            pstmt.setInt(4, ticket.getNumberOfTickets());
            pstmt.setDouble(5, ticket.getTotalPrice());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}