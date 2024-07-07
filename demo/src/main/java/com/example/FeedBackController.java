package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class FeedBackController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label tanggalDilaporkanLabel;

    @FXML
    private Label judulLaporanLabel;

    @FXML
    private Label kategoriLabel;

    @FXML
    private Label lokasiLabel;

    @FXML
    private ImageView fotoLaporanImageView;

    @FXML
    private TextArea deskripsiTextArea;

    @FXML
    private Label statusLabel;

    @FXML
    private TextArea tanggapanTextArea;

    @FXML
    private ImageView fotoTanggapanImageView;

    @FXML
    private HBox feedbackSection;

    @FXML
    private TextArea feedbackTextArea;

    @FXML
    void initialize() {
        // Example data, you should replace this with actual data fetching logic
        tanggalDilaporkanLabel.setText("2023-06-15");
        judulLaporanLabel.setText("Kerusakan Jalan");
        kategoriLabel.setText("Infrastruktur");
        lokasiLabel.setText("Jl. Merdeka No. 45");
        fotoLaporanImageView.setImage(new Image("path/to/report_photo.png"));
        deskripsiTextArea.setText("Jalan berlubang di Jl. Merdeka yang sangat berbahaya bagi pengendara.");
        statusLabel.setText("Selesai");
        tanggapanTextArea.setText("Laporan Anda sudah kami tangani, jalan sudah diperbaiki.");
        fotoTanggapanImageView.setImage(new Image("path/to/response_photo.png"));

        // Show feedback section if the report is complete
        if ("Selesai".equals(statusLabel.getText())) {
            feedbackSection.setVisible(true);
        }
    }

    @FXML
    private void kirimFeedback() {
        String feedback = feedbackTextArea.getText();
        // Handle the feedback submission logic here
        System.out.println("Feedback submitted: " + feedback);
        // Optionally, clear the feedback text area after submission
        feedbackTextArea.clear();
    }
}
