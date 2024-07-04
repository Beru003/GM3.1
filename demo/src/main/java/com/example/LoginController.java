package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink registerLink;

    private List<User> users;

    @FXML
    private void initialize() {
        // Load users from CSV
        users = loadUsersFromCSV("users.csv");
    }

    @FXML
    private void handleLoginAction() {
        // Perform login logic here
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Authenticate user
        if (authenticateUser(username, password)) {
            // Example: Navigate to Main after successful login
            try {
                App.setRoot("Main");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Handle login failure
            System.out.println("Login failed: Invalid username or password");
        }
    }

    @FXML
    private void goToRegister() throws IOException {
        App.setRoot("Register");
    }

    private List<User> loadUsersFromCSV(String filePath) {
        List<User> userList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    userList.add(new User(values[0], values[1], values[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    private boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if ((user.getEmail().equals(username) || user.getFullName().equals(username)) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Inner class to represent a User
    private static class User {
        private String fullName;
        private String email;
        private String password;

        public User(String fullName, String email, String password) {
            this.fullName = fullName;
            this.email = email;
            this.password = password;
        }

        public String getFullName() {
            return fullName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
