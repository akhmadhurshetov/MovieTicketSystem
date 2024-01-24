package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MovieList newMovie = new MovieList("https://bst.icons8.com/wp-content/themes/icons8/app/uploads/2019/05/film-poster-design.png", "Movie Title", "Short description", "Long description", true, 9.99, "Location", 4.5);
        MovieListCRUD.addMovie(newMovie);
//        int movieId = 123;
//        MovieListCRUD.deleteMovie(movieId);
    }
}