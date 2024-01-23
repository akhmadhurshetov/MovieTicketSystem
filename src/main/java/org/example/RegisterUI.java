package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterUI extends Application {

    private Stage primaryStage;

    private void showRegistrationForm() {
        // New window (Stage)
        Stage newStage = new Stage();
        newStage.setTitle("New Register");

        // GridPane layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Form Title
        Text scenetitle = new Text("NEW REGISTER");
        scenetitle.setFont(Font.font(20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Name field
        Label nameLabel = new Label("NAME:");
        grid.add(nameLabel, 0, 1);
        TextField nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        // Email ID field
        Label emailLabel = new Label("EMAIL ID:");
        grid.add(emailLabel, 0, 2);
        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);

        // Phone Number field
        Label phoneLabel = new Label("PHONE NUMBER:");
        grid.add(phoneLabel, 0, 3);
        TextField phoneTextField = new TextField();
        grid.add(phoneTextField, 1, 3);

        // Password field
        Label passwordLabel = new Label("PASSWORD:");
        grid.add(passwordLabel, 0, 4);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 4);

        // Sign Up button
        Button signUpButton = new Button("SIGN UP");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(signUpButton);
        grid.add(hbBtn, 1, 5);

        signUpButton.setOnAction(e -> {
            // Handle sign up
        });

        // Scene
        Scene scene = new Scene(grid, 300, 275);
        newStage.setScene(scene);

        // Show the registration form
        newStage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // ... rest of the previous start method

        // Modify the New Register button event to call showRegistrationForm
//        btnRegister.setOnAction(e -> showRegistrationForm());
    }

    public static void main(String[] args) {
        launch(args);
    }
}