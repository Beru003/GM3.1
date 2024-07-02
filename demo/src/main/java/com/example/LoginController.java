package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink registerLink;

    @FXML
    private void initialize() {
        // Initialization code if needed
    }

    @FXML
    private void handleLoginAction() {
        // Perform login logic here
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Replace with your actual login logic
        System.out.println("Login with: " + username + ", " + password);

        // Example: Navigate to Main after successful login
        try {
            App.setRoot("Main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToRegister() throws IOException {
        App.setRoot("Register");
    }
}
