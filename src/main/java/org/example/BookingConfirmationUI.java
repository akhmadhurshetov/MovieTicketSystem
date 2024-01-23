package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookingConfirmationUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Booking Details");

        // Mock data, replace these with actual data from your form
        String numberOfTickets = "5";
        String theatreName = "srivishnu";
        String movieName = "sahoo";
        String date = "11-11-2018";
        String showTime = "7:00AM";
        String fare = "500";

        // Layout using VBox for vertical stacking
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setAlignment(Pos.CENTER);

        // Labels for the booking details
        Label titleLabel = new Label("BOOKING DETAILS");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label ticketsLabel = new Label("NO OF TICKETS: " + numberOfTickets);
        Label theatreLabel = new Label("THEATRE: " + theatreName);
        Label movieLabel = new Label("MOVIE: " + movieName);
        Label dateLabel = new Label("DATE: " + date);
        Label showLabel = new Label("SHOW: " + showTime);
        Label fareLabel = new Label("FARE: " + fare);

        // Buttons for booking and cancellation
        Button bookButton = new Button("BOOK");
        Button cancelButton = new Button("CANCEL");

        // Event handler for the book button
        bookButton.setOnAction(e -> {
            // Here you would handle the booking confirmation
            System.out.println("Booking confirmed!");
        });

        // Event handler for the cancel button
        cancelButton.setOnAction(e -> {
            // Close the current window
            primaryStage.close();

            // Now, open the MovieUI window again
            try {
                MovieUI movieUI = new MovieUI();
                Stage stage = new Stage();
                movieUI.start(stage); // Start the MovieUI scene on a new stage
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        // Adding all components to the VBox
        vbox.getChildren().addAll(titleLabel, ticketsLabel, theatreLabel, movieLabel, dateLabel, showLabel, fareLabel, bookButton, cancelButton);

        // Set the scene and show the stage
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
