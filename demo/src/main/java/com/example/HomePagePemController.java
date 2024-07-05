package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class HomePagePemController {

    @FXML
    private ImageView logoImageView;

    @FXML
    private VBox navBar;

    @FXML
    private HBox homeButton;

    @FXML
    private HBox laporanButton;

    @FXML
    private HBox feedbackButton;

    @FXML
    private HBox keluarButton;

    @FXML
    private Button homeBtn;

    @FXML
    private Button laporanBtn;

    @FXML
    private Button feedbackBtn;

    @FXML
    private Button keluarBtn;

    @FXML
    private void initialize() {
        homeBtn.setOnAction(event -> handleHomeButtonAction());
        laporanBtn.setOnAction(event -> handleLaporanButtonAction());
        feedbackBtn.setOnAction(event -> handleFeedbackButtonAction());
        keluarBtn.setOnAction(event -> handleKeluarButtonAction());
    }

    @FXML
    private void handleHomeButtonAction() {
        System.out.println("Home button clicked");
        // Add navigation logic if needed
    }

    @FXML
    private void handleLaporanButtonAction() {
        System.out.println("Laporan button clicked");
        loadPage("/com/example/laporanmslh.fxml");
    }

    @FXML
    private void handleFeedbackButtonAction() {
        System.out.println("Feedback button clicked");
        // Add navigation logic if needed
    }

    @FXML
    private void handleKeluarButtonAction() {
        System.out.println("Keluar button clicked");
        // Close the application or navigate to login
        Stage stage = (Stage) keluarButton.getScene().getWindow();
        stage.close();
    }

    // Method to load a new FXML page
    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) navBar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
