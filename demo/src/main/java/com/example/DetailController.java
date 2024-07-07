package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DetailController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView fotoLaporanImageView;

    @FXML
    private Label kategoriLabel;

    @FXML
    private Label tanggalLabel;

    @FXML
    private Label lokasiLabel;

    @FXML
    private Label deskripsiLabel;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private TextArea komentarTextArea;

    @FXML
    private Button kirimButton;

    @FXML
    void initialize() {
        // Initialize data, replace with actual data fetching
        kategoriLabel.setText("Jalan");
        tanggalLabel.setText("22 Juni 2024");
        lokasiLabel.setText("Jl. Aspal Abu, Sleman");
        deskripsiLabel.setText("Jalan Berlubang. Mohon segera ditanggapi.");
        fotoLaporanImageView.setImage(new Image("path/to/report_photo.png")); // Replace with actual image path

        statusComboBox.getItems().addAll("Proses", "Selesai", "Pending");
    }

    @FXML
    private void kirimTanggapan() {
        // Handle the response submission logic here
        String status = statusComboBox.getValue();
        String komentar = komentarTextArea.getText();
        System.out.println("Status: " + status + ", Komentar: " + komentar);
        // Optionally clear the fields after submission
        statusComboBox.setValue(null);
        komentarTextArea.clear();
    }

    @FXML
    private void goBack() {
        // Handle the back button logic here
        System.out.println("Back button clicked");
    }
}
