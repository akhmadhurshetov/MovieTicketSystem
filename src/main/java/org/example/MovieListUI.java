package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class MovieListUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Movie List");

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        // Fetch data from database
        List<MovieList> movies = MovieListCRUD.getAllMovies();

        for (MovieList movie : movies) {
            HBox hbox = createMovieCard(movie);
            vbox.getChildren().add(hbox);
        }

        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createMovieCard(MovieList movie) {
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER); // Center alignment for the content of the HBox
        hbox.setStyle("-fx-border-color: grey; -fx-border-width: 1; -fx-padding: 5; -fx-background-color: #f0f0f0;"); // Adding border and padding

        ImageView imageView = new ImageView();
        try {
            Image image = new Image(movie.getImage(), true); // true for background loading
            imageView.setImage(image);
        } catch (IllegalArgumentException e) {
            System.err.println("Error loading image: " + e.getMessage());
            // Set a default or placeholder image if the original one fails to load
            imageView.setImage(new Image("path/to/placeholder/image.png"));
        }
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER_LEFT); // Align content inside the VBox to the center left
        vbox.getChildren().add(new Label(movie.getTitle()));
        vbox.getChildren().add(new Text(movie.getShortDescription()));
        vbox.getChildren().add(new Label("Rating: " + movie.getRating()));

        Button exploreButton = new Button("Book");
        exploreButton.setOnAction(event -> exploreMovie(movie));
        vbox.getChildren().add(exploreButton); // Add the button to the VBox

        hbox.getChildren().addAll(imageView, vbox);

        return hbox;
    }

    private void exploreMovie(MovieList movie) {
        MovieBookingApp movieBookingApp = new MovieBookingApp();
        movieBookingApp.start(new Stage());
        System.out.println("Exploring movie: " + movie.getTitle());
    }

    public static void main(String[] args) {
        launch(args);
    }
}