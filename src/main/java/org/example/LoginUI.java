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

public class LoginUI extends Application {

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
            // Handle login logic here
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