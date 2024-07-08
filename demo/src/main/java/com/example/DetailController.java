package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DetailController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField kategoriTextField;

    @FXML
    private TextField tanggalTextField;

    @FXML
    private TextField lokasiTextField;

    @FXML
    private TextField deskripsiTextField;

    @FXML
    private TextField judulTextField;


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
        
        kategoriTextField.setText(laporanIni.getKategori());
        tanggalTextField.setText(laporanIni.getTanggal());
        lokasiTextField.setText(laporanIni.getLokasi());
        deskripsiTextField.setText(laporanIni.getDeskripsi());
        judulTextField.setText(laporanIni.getJudul());

    }
    private void bacaIndeks(){
        try (BufferedReader br = new BufferedReader(new FileReader("indexL.csv"))) {
            indeks = Integer.valueOf(br.readLine());}
        catch (Exception e) {}
        // TODO: handle exception
    }
    
    @FXML
    private void backButton() {
        // Handle the back button logic here
        System.out.println("Back button clicked");
        try {
            loadPage("/com/example/laporanmslh.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     private void loadPage(String fxmlFile) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);    
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                        data[5]
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

        @Override
        public String toString() {
            return "Issue [no=" + no + ", judul=" + judul + ", kategori=" + kategori +", lokasi="
                    + lokasi + ", deskripsi=" + deskripsi + ", tanggal=" + tanggal + "]";
        }

    }
}
