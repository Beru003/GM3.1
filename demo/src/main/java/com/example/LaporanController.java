package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.File;

public class LaporanController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> kategoriComboBox;

    @FXML
    private DatePicker tanggalDatePicker;

    @FXML
    private TextField judulTextField;

    @FXML
    private TextField lokasiTextField;

    @FXML
    private TextArea deskripsiTextArea;

    @FXML
    private Button pilihFileButton;

    @FXML
    private ImageView fotoImageView;

    @FXML
    void initialize() {
        kategoriComboBox.getItems().addAll(
            "Jalan Rusak", 
            "Pohon Tumbang", 
            "Kemacetan", 
            "Kecelakaan", 
            "Banjir", 
            "Lain-lain"
        );

        pilihFileButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"),
                    new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi", "*.mov")
            );
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            if (selectedFile != null) {
                // Set the file path to lokasiTextField or handle the file as needed
                lokasiTextField.setText(selectedFile.getAbsolutePath());
            }
        });
    }
}
