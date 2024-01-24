package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MovieUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Movie Details");

        // Create the root grid pane and set its properties
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));



        // Add UI components to the grid pane
        Label movieLabel = new Label("Select Movie:");
        ComboBox<String> movieComboBox = new ComboBox<>();
        movieComboBox.getItems().addAll("Novda", "Tangalik Bolalar", "Chinor ostida duel", "Mahallada duv-duv gap");

        Label theatreLabel = new Label("Select Location:");
        ComboBox<String> theatreComboBox = new ComboBox<>();
        theatreComboBox.getItems().addAll("Panorama", "Anhor Cinema", "Cinema Place");

        Label dateLabel = new Label("Select Date:");
        DatePicker datePicker = new DatePicker();

        Label timeLabel = new Label("Select Time:");
        ComboBox<String> timeComboBox = new ComboBox<>();
        timeComboBox.getItems().addAll("14:00", "19:00", "21:00");

        Label ticketsLabel = new Label("Number of Tickets:");
        TextField ticketsTextField = new TextField();

        Button btnSubmit = new Button("Submit");

        // Adding components to grid
        gridPane.add(movieLabel, 0, 0);
        gridPane.add(movieComboBox, 1, 0);
        gridPane.add(theatreLabel, 0, 1);
        gridPane.add(theatreComboBox, 1, 1);
        gridPane.add(dateLabel, 0, 2);
        gridPane.add(datePicker, 1, 2);
        gridPane.add(timeLabel, 0, 3);
        gridPane.add(timeComboBox, 1, 3);
        gridPane.add(ticketsLabel, 0, 4);
        gridPane.add(ticketsTextField, 1, 4);
        gridPane.add(btnSubmit, 1, 5);

        btnSubmit.setOnAction(e -> {
            // Close the current window
            primaryStage.close();

            // Now, open the MovieUI window again
            try {
                TicketUI ticketUI = new TicketUI();
                Stage stage = new Stage();
                ticketUI.start(stage); // Start the MovieUI scene on a new stage
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Set the scene and show the stage
        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
