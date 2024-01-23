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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUI extends Application {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    private Connection connectToDB() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
            return null;
        }
    }

    private void insertNewUser(String username, String password, String name, String email, String phoneNumber) {
        String sql = "INSERT INTO user_detail (username, password, name, email, phone_number) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connectToDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password); // In a real-world application, password should be hashed
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, phoneNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration Error");
            alert.setHeaderText(null);
            alert.setContentText("Error occurred during registration. Please try again.");
            alert.showAndWait();
        }
    }

    @Override
    public void start(Stage registerStage) {
        registerStage.setTitle("New Register");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("NEW REGISTER");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label nameLabel = new Label("Name:");
        grid.add(nameLabel, 0, 1);
        TextField nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 2);
        TextField usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 2);

        Label emailLabel = new Label("Email ID:");
        grid.add(emailLabel, 0, 3);
        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 3);

        Label phoneLabel = new Label("Phone Number:");
        grid.add(phoneLabel, 0, 4);
        TextField phoneTextField = new TextField();
        grid.add(phoneTextField, 1, 4);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 5);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 5);

        Button btnSignUp = new Button("Sign up");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnSignUp);
        grid.add(hbBtn, 1, 6);

        btnSignUp.setOnAction(e -> {
            String name = nameTextField.getText();
            String username = usernameTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            String password = passwordField.getText();

            insertNewUser(username, password, name, email, phone);
            // Here you can implement logic to switch to the login screen or another screen upon successful registration
        });

        Scene scene = new Scene(grid, 400, 400);
        registerStage.setScene(scene);
        registerStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}