package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button registerButton;

    @FXML
    private void initialize() {
        // Initialization code if needed
    }

    @FXML
    private void handleRegisterAction() {
        // Perform registration logic here
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Replace with your actual registration logic
        System.out.println("Register with: " + fullName + ", " + email + ", " + password);

        // Example: Go to login after registration
        try {
            App.setRoot("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToLogin() {
        try {
            App.setRoot("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
