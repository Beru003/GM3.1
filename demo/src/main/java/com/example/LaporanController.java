package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    private VBox navBar;

    @FXML
    private HBox homeButton;

    @FXML
    private HBox laporkanButton;

    @FXML
    private HBox feedbackButton;

    @FXML
    private HBox keluarButton;

    @FXML
    private Button homeBtn;

    @FXML
    private Button laporkanBtn;

    @FXML
    private Button feedbackBtn;

    @FXML
    private Button keluarBtn;

    @FXML
    private Button kirimBtn;

    private ArrayList<Issue> issueData = new ArrayList<>();

    @FXML
    private void handleHomeButtonAction() {
        System.out.println("Home button clicked");
        loadPage("/com/example/HomePage.fxml");
    }

    @FXML
    private void handleLaporkanButtonAction() {
        System.out.println("Laporkan button clicked");
        // Add navigation logic if needed
    }

    @FXML
    private void handleFeedbackButtonAction() {
        System.out.println("Feedback button clicked");
        loadPage("/com/example/Feedback.fxml");
    }

    @FXML
    private void handleKeluarButtonAction() {
        System.out.println("Keluar button clicked");
        // Close the application or navigate to login
        Stage stage = (Stage) keluarButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleKirimButtonAction() {
        saveNewDataToFile();
    }

    private void saveNewDataToFile() {
        String kategori = kategoriComboBox.getValue();
        String tanggal = tanggalDatePicker.getValue() != null ? tanggalDatePicker.getValue().toString() : "";
        String judul = judulTextField.getText();
        String lokasi = lokasiTextField.getText();
        String deskripsi = deskripsiTextArea.getText();

        int nextId = getLastIssueNumber() + 1;

        Issue newIssue = new Issue(
            String.valueOf(nextId), // Generate unique ID based on the last issue number
            judul, 
            kategori, 
            lokasi, 
            deskripsi, 
            tanggal
        );

        issueData.add(newIssue);
        appendDataToCSV(newIssue);
    }

    private int getLastIssueNumber() {
        int lastIssueNumber = 0;
        for (Issue issue : issueData) {
            int issueNumber = Integer.parseInt(issue.getNo());
            if (issueNumber > lastIssueNumber) {
                lastIssueNumber = issueNumber;
            }
        }
        return lastIssueNumber;
    }

    private void appendDataToCSV(Issue newIssue) {
        File file = new File("data.csv");

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(newIssue.getNo()).append(",");
            writer.append(newIssue.getJudul()).append(",");
            writer.append(newIssue.getKategori()).append(",");
            writer.append(newIssue.getLokasi()).append(",");
            writer.append(newIssue.getDeskripsi()).append(",");
            writer.append(newIssue.getTanggal()).append("\n");

            System.out.println("Data appended to data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadExistingData() {
        File file = new File("data.csv");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 7) {
                    Issue issue = new Issue(values[0], values[1], values[2], values[3], values[4], values[5]);
                    issueData.add(issue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Example method to load a new FXML page
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

    @FXML
    void initialize() {

        homeBtn.setOnAction(event -> handleHomeButtonAction());
        laporkanBtn.setOnAction(event -> handleLaporkanButtonAction());
        feedbackBtn.setOnAction(event -> handleFeedbackButtonAction());
        keluarBtn.setOnAction(event -> handleKeluarButtonAction());

        kategoriComboBox.getItems().addAll(
            "Jalan Rusak",
            "Pohon Tumbang",
            "Kemacetan",
            "Kecelakaan",
            "Banjir",
            "Lain-lain"
        );


        loadExistingData();
    }

    public static class Issue {
        private String no;
        private String judul;
        private String kategori;
        private String lokasi;
        private String deskripsi;
        private String tanggal;

        public Issue(String no, String judul, String kategori, String lokasi, String deskripsi, String tanggal) {
            this.no = no;
            this.judul = judul;
            this.kategori = kategori;
            this.lokasi = lokasi;
            this.deskripsi = deskripsi;
            this.tanggal = tanggal;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public String getKategori() {
            return kategori;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        public String getLokasi() {
            return lokasi;
        }

        public void setLokasi(String lokasi) {
            this.lokasi = lokasi;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getTanggal() {
            return tanggal;
        }

        public void setTanggal(String tanggal) {
            this.tanggal = tanggal;
        }
    }
}
