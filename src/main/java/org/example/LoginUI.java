package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;

public class LoginUI extends Application {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/movieticketsystem";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    private Connection connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Customer authenticateUser(String username, String password) {
        String sql = "SELECT * FROM user_detail WHERE username = ? AND password = ?"; // Update with your actual table and column names

        try (Connection conn = connectToDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    // Assuming resultSet columns match the Customer constructor parameters
                    return new Customer(
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone_number")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Movie Ticket System");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Online Movie Ticket Booking");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("USERNAME:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("PASSWORD:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btnLogin = new Button("LOGIN");
        Button btnRegister = new Button("NEW REGISTER");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnLogin);
        hbBtn.getChildren().add(btnRegister);
        grid.add(hbBtn, 1, 4);

        btnLogin.setOnAction(e -> {
            String username = userTextField.getText();
            String pwd = pwBox.getText();
            Customer customer = authenticateUser(username, pwd);

            if (customer != null) {
                MovieListUI movieListUI = new MovieListUI();
                movieListUI.start(new Stage());
                System.out.println("Login successful for user: " + customer.getName());
            } else {
                // Show error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Account does not exist or wrong credentials!");
                alert.showAndWait();
            }
        });

        btnRegister.setOnAction(e -> {
            RegisterUI registerUI = new RegisterUI();
            registerUI.start(new Stage());
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}