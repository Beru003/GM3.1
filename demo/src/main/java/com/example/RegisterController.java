package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        registerButton.setOnAction(event -> handleRegisterAction());
    }

    @FXML
    private void handleRegisterAction() {
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Perform your validation logic here
        if (password.equals(confirmPassword)) {
            // Save data to CSV
            saveToCSV(fullName, email, password);

            // Navigate to login after registration
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/login.fxml"));
                Parent loginRoot = loader.load();
                Stage stage = (Stage) registerButton.getScene().getWindow();
                stage.setScene(new Scene(loginRoot));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Handle password mismatch
            System.out.println("Passwords do not match");
        }
    }

    private void saveToCSV(String fullName, String email, String password) {
        try (FileWriter fw = new FileWriter("users.csv", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(fullName + "," + email + "," + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToLogin() {
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
