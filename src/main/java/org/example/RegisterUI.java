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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterUI extends Application {

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

        Label nameLabel = new Label("NAME:");
        grid.add(nameLabel, 0, 1);

        TextField nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        Label emailLabel = new Label("EMAIL ID:");
        grid.add(emailLabel, 0, 2);

        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);

        Label phoneLabel = new Label("PHONE NUMBER:");
        grid.add(phoneLabel, 0, 3);

        TextField phoneTextField = new TextField();
        grid.add(phoneTextField, 1, 3);

        Label passwordLabel = new Label("PASSWORD:");
        grid.add(passwordLabel, 0, 4);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 4);

        Button btnSignUp = new Button("SIGN UP");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btnSignUp);
        grid.add(hbBtn, 1, 5);

        btnSignUp.setOnAction(e -> {
            // Handle sign-up logic here
        });

        Scene scene = new Scene(grid, 300, 275);
        registerStage.setScene(scene);
        registerStage.show();
    }

    // The main method might not be needed if RegisterUI is not standalone.
    // If you want to make RegisterUI standalone, you can include the main method.
    public static void main(String[] args) {
        launch(args);
    }
}