package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieListCRUD {

    // Method to add a new movie
    public static void addMovie(MovieList movie) {
        String sql = "INSERT INTO movies (image, title, shortDescription, longDescription, isActive, price, location, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie.getImage());
            pstmt.setString(2, movie.getTitle());
            pstmt.setString(3, movie.getShortDescription());
            pstmt.setString(4, movie.getLongDescription());
            pstmt.setBoolean(5, movie.isActive());
            pstmt.setDouble(6, movie.getPrice());
            pstmt.setString(7, movie.getLocation());
            pstmt.setDouble(8, movie.getRating());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a list of all movies
    public static List<MovieList> getAllMovies() {
        List<MovieList> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                MovieList movie = new MovieList(
                        rs.getString("image"),
                        rs.getString("title"),
                        rs.getString("shortDescription"),
                        rs.getString("longDescription"),
                        rs.getBoolean("isActive"),
                        rs.getDouble("price"),
                        rs.getString("location"),
                        rs.getDouble("rating"),
                        rs.getInt("id")
                                );
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public static void updateMovie(MovieList movie, int movieId) {
        String sql = "UPDATE movies SET image = ?, title = ?, shortDescription = ?, longDescription = ?, isActive = ?, price = ?, location = ?, rating = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie.getImage());
            pstmt.setString(2, movie.getTitle());
            pstmt.setString(3, movie.getShortDescription());
            pstmt.setString(4, movie.getLongDescription());
            pstmt.setBoolean(5, movie.isActive());
            pstmt.setDouble(6, movie.getPrice());
            pstmt.setString(7, movie.getLocation());
            pstmt.setDouble(8, movie.getRating());
            pstmt.setInt(9, movieId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a movie
    public static void deleteMovie(int movieId) {
        String sql = "DELETE FROM movies WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, movieId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a single movie by id
    public static MovieList getMovieById(int movieId) {
        String sql = "SELECT * FROM movies WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, movieId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new MovieList(
                        rs.getString("image"),
                        rs.getString("title"),
                        rs.getString("shortDescription"),
                        rs.getString("longDescription"),
                        rs.getBoolean("isActive"),
                        rs.getDouble("price"),
                        rs.getString("location"),
                        rs.getDouble("rating"),
                        rs.getInt("id")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
