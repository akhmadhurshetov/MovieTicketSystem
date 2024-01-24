package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/movieticketsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static List<MovieList> getMovies() {
        List<MovieList> movies = new ArrayList<>();
        String query = "SELECT id, title, location, price FROM movies";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                MovieList movie = new MovieList(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("location"),
                        resultSet.getDouble("price")
                );
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions properly in a real application
        }

        return movies;
    }
}