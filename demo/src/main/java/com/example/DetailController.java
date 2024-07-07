package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private ArrayList<Issue> issueData = new ArrayList<Issue>();
    Issue laporanIni;
    int indeks;

    @FXML
    void initialize() {
        // Initialize data, replace with actual data fetching
        loadCSVData();
        bacaIndeks();
        laporanIni = issueData.get(indeks);
        System.err.println(issueData.get(indeks).toString());
        
        kategoriLabel.setText("Jalan");
        tanggalLabel.setText("22 Juni 2024");
        lokasiLabel.setText("Jl. Aspal Abu, Sleman");
        deskripsiLabel.setText("Jalan Berlubang. Mohon segera ditanggapi.");
        fotoLaporanImageView.setImage(new Image("path/to/report_photo.png")); // Replace with actual image path

        statusComboBox.getItems().addAll("Proses", "Selesai", "Pending");
    }
    private void bacaIndeks(){
        try (BufferedReader br = new BufferedReader(new FileReader("indexL.csv"))) {
            indeks = Integer.valueOf(br.readLine());}
        catch (Exception e) {}
        // TODO: handle exception
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

    private void loadCSVData() {
        String csvFile = "data.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                Issue issue = new Issue(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6]
                );

                issueData.add(issue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static class Issue {
        private String no;
        private String judul;
        private String kategori;
        private String foto;
        private String lokasi;
        private String deskripsi;
        private String tanggal;

        public Issue(String no, String judul, String kategori, String foto, String lokasi, String deskripsi, String tanggal) {
            this.no = no;
            this.judul = judul;
            this.kategori = kategori;
            this.foto = foto;
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

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
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

        @Override
        public String toString() {
            return "Issue [no=" + no + ", judul=" + judul + ", kategori=" + kategori + ", foto=" + foto + ", lokasi="
                    + lokasi + ", deskripsi=" + deskripsi + ", tanggal=" + tanggal + "]";
        }

    }
}
